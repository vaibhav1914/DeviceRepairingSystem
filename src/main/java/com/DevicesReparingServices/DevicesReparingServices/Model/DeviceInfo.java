package com.DevicesReparingServices.DevicesReparingServices.Model;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class DeviceInfo {
	 
	    @Id
	    private int id;
	    private long mobNo;
	    private String peripheral;
	    private String devicename;
	    private String devicemodel;
	    private String devicecompany;
	    private String deviceproblem;
	    private String reparingStatus;
	    private String paymentStatus;
	    private String partName;
	    private double price;
	    private transient MultipartFile billrecipt;
	    private String billReciptPath;
	    private LocalDate date;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getMobNo() {
			return mobNo;
		}
		public void setMobNo(long mobNo) {
			this.mobNo = mobNo;
		}
		public String getPeripheral() {
			return peripheral;
		}
		public void setPeripheral(String peripheral) {
			this.peripheral = peripheral;
		}
		public String getDevicename() {
			return devicename;
		}
		public void setDevicename(String devicename) {
			this.devicename = devicename;
		}
		public String getDevicemodel() {
			return devicemodel;
		}
		public void setDevicemodel(String devicemodel) {
			this.devicemodel = devicemodel;
		}
		public String getDevicecompany() {
			return devicecompany;
		}
		public void setDevicecompany(String devicecompany) {
			this.devicecompany = devicecompany;
		}
		public String getDeviceproblem() {
			return deviceproblem;
		}
		public void setDeviceproblem(String deviceproblem) {
			this.deviceproblem = deviceproblem;
		}
		public String getReparingStatus() {
			return reparingStatus;
		}
		public void setReparingStatus(String reparingStatus) {
			this.reparingStatus = reparingStatus;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public String getPartName() {
			return partName;
		}
		public void setPartName(String partName) {
			this.partName = partName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public MultipartFile getBillrecipt() {
			return billrecipt;
		}
		public void setBillrecipt(MultipartFile billrecipt) {
			this.billrecipt = billrecipt;
		}
		public String getBillReciptPath() {
			return billReciptPath;
		}
		public void setBillReciptPath(String billReciptPath) {
			this.billReciptPath = billReciptPath;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public DeviceInfo(int id, long mobNo, String peripheral, String devicename, String devicemodel,
				String devicecompany, String deviceproblem, String reparingStatus, String paymentStatus,
				String partName, double price, MultipartFile billrecipt, String billReciptPath, LocalDate date) {
			super();
			this.id = id;
			this.mobNo = mobNo;
			this.peripheral = peripheral;
			this.devicename = devicename;
			this.devicemodel = devicemodel;
			this.devicecompany = devicecompany;
			this.deviceproblem = deviceproblem;
			this.reparingStatus = reparingStatus;
			this.paymentStatus = paymentStatus;
			this.partName = partName;
			this.price = price;
			this.billrecipt = billrecipt;
			this.billReciptPath = billReciptPath;
			this.date = date;
		}
		public DeviceInfo() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "DeviceInfo [id=" + id + ", mobNo=" + mobNo + ", peripheral=" + peripheral + ", devicename="
					+ devicename + ", devicemodel=" + devicemodel + ", devicecompany=" + devicecompany
					+ ", deviceproblem=" + deviceproblem + ", reparingStatus=" + reparingStatus + ", paymentStatus="
					+ paymentStatus + ", partName=" + partName + ", price=" + price + ", billrecipt=" + billrecipt
					+ ", billReciptPath=" + billReciptPath + ", date=" + date + "]";
		}
		

    }
