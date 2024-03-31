package com.DevicesReparingServices.DevicesReparingServices.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.DevicesReparingServices.DevicesReparingServices.Model.CustomerLogin;
import com.DevicesReparingServices.DevicesReparingServices.Model.DeviceInfo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Controller
public class Device_R_S_Controller {

	@Autowired
	SessionFactory sf;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/signUp")
	public ModelAndView signUp(@ModelAttribute CustomerLogin cusLog) {
		Session s1 = sf.openSession();
		CustomerLogin cus = s1.get(CustomerLogin.class, cusLog.getEmail());
		if (cus != null) {
			return new ModelAndView("index");
		} else {

			Session ss = sf.openSession();
			Transaction tx = ss.beginTransaction();
			ss.save(cusLog);
			tx.commit();
			return new ModelAndView("home");
		}

	}

	@RequestMapping("/signIn")
	public ModelAndView signIn(@ModelAttribute CustomerLogin cusLog) {
		Session ss = sf.openSession();
		Query query = ss.createQuery("from CustomerLogin");
		List<CustomerLogin> list = query.list();
		for (CustomerLogin customerLogin : list) {
			if (customerLogin.getEmail().equals(cusLog.getEmail())
					&& customerLogin.getPassword().equals(cusLog.getPassword())) {
				return new ModelAndView("home");
			}
		}
		return new ModelAndView("index");
	}

	
	
//--------------------------------------------------------------


	@RequestMapping("/indexdetails")
	public ModelAndView idetails() {
	    // Open session
	    try (Session session = sf.openSession()) {
	        // Retrieve list of DeviceInfo objects
	        List<DeviceInfo> indexList = session.createQuery("from DeviceInfo", DeviceInfo.class).list();

	        // Construct base URL for bill receipt
	        String baseUrl = "http://localhost:8080/billrecipt/";

	        // Iterate through the DeviceInfo list and update bill receipt paths
	        for (DeviceInfo indexEntity : indexList) {
	            String billRFileName = indexEntity.getBillReciptPath(); // Assuming getBillReciptPath() returns file name

	            // Extract file name from bill receipt path
	            int index = billRFileName.lastIndexOf("/");
	            String result = billRFileName.substring(index + 1);
	            
	            System.out.println("hiii "+result);

	            // Construct complete bill receipt URL
	            String billReURL = baseUrl + result;

	            // Update bill receipt path
	            indexEntity.setBillReciptPath(billReURL);
	            System.out.println(billReURL);
	        }

	        // Create ModelAndView object
	        ModelAndView modelAndView = new ModelAndView();

	        // Set view name
	        modelAndView.setViewName("a");

	        // Add indexList to ModelAndView
	        modelAndView.addObject("indexList", indexList);

	        // Return ModelAndView
	        return modelAndView;
	    } catch (Exception e) {
	        // Handle any exceptions
	        e.printStackTrace();
	        return null; // Or handle the exception gracefully and return an appropriate ModelAndView
	    }
	}

	
	@RequestMapping("/a")
	public ModelAndView page() {
		return new ModelAndView("a");
	}
	
	
	//---------------------------------------------------------
	
	
	
	

    
    
 
        
        @PostMapping("/addDevice")
        public ModelAndView addDeviceInfOO(@ModelAttribute DeviceInfo deviceInfo,
                                           @RequestParam("billrecipt") MultipartFile billrecipt) {
            ModelAndView modelAndView = new ModelAndView("home");
            Session ss = sf.openSession();
            Transaction tx = ss.beginTransaction();
            if (billrecipt.isEmpty()) {
                modelAndView.addObject("error", "Uploaded bill receipt is empty.");
                return modelAndView;
            }

            try {
                String uploadsDir = "D:/NETSEC pvt ltd/DevicesReparingServices/DevicesReparingServices/src/main/webapp/billrecipt";
                String fileName = billrecipt.getOriginalFilename();
                System.out.println("file Name"+fileName);
//                String filePath = Paths.get(uploadsDir, fileName).toString();
//                
//                Files.createDirectories(Paths.get(uploadsDir));
                
                
                String filePath = Paths.get(uploadsDir, fileName).toString();
             // Replace backward slashes with forward slashes
             filePath = filePath.replace("\\", "/");
             System.out.println("file " + filePath);
//             Files.createDirectories(Paths.get(filePath));
                
                
                Files.copy(billrecipt.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

                deviceInfo.setBillReciptPath(filePath);
               
                ss.save(deviceInfo);
                tx.commit();
                modelAndView.addObject("success", "DeviceInfo added successfully.");
            } catch (IOException e) {
                modelAndView.addObject("error", "Error saving bill receipt: " + e.getMessage());
                e.printStackTrace();
            }

            return modelAndView;
        }
        
       //--------------------------------------messAGE
        @RequestMapping("/drs")
        public ModelAndView drs() 
        {
        	return new ModelAndView("drs");
        }
        
        
        @Value("${twilio.account_sid}")
        private String twilioAccountSid;

        @Value("${twilio.auth_token}")
        private String twilioAuthToken;

        @Value("${twilio.whatsapp.number}")
        private String twilioWhatsappNumber;

        @PostMapping("/submitForm")
        public String submitForm(
                @RequestParam("customerName") String customerName,
                @RequestParam("customerAddress") String customerAddress,
                @RequestParam("phoneNumber") String phoneNumber,
                @RequestParam("deviceType") String deviceType,
                @RequestParam("serialNumber") String serialNumber,
                @RequestParam("modelNumber") String modelNumber,
                @RequestParam("adaptor") String adaptor
        ) {
            // Initialize Twilio
            Twilio.init(twilioAccountSid, twilioAuthToken);

            // Compose WhatsApp message
            String messageBody = "Customer Name: " + customerName + "\n" +
                    "Address: " + customerAddress + "\n" +
                    "Phone Number: " + phoneNumber + "\n" +
                    "Type of Device: " + deviceType + "\n" +
                    "Serial Number: " + serialNumber + "\n" +
                    "Model Number: " + modelNumber + "\n" +
                    "Adaptor: " + adaptor;

            // Send WhatsApp message
            Message message = Message.creator(
                    new PhoneNumber("whatsapp:" + twilioWhatsappNumber),
                    new PhoneNumber("whatsapp:" + twilioWhatsappNumber),
                    messageBody)
                    .create();

            System.out.println("WhatsApp message SID: " + message.getSid());

            return "redirect:/success.html"; // Redirect to a success page
        }
       
       
}
