<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Device Repairing Form</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: Arial, sans-serif;
            animation: changeBackground 10s infinite alternate;
            background: linear-gradient(to right, #ff9a9e, #fad0c4);
        }

        @keyframes changeBackground {
            0% { background: linear-gradient(to right, #ff9a9e, #fad0c4); }
            25% { background: linear-gradient(to right, #a18cd1, #fbc2eb); }
            50% { background: linear-gradient(to right, #fad0c4, #ff9a9e); }
            75% { background: linear-gradient(to right, #fbc2eb, #a18cd1); }
            100% { background: linear-gradient(to right, #ff9a9e, #fad0c4); }
        }
        
        .form_div {
         
            margin: auto;
            width: 60%;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: grey;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            align-items: center; /* Center align items horizontally */
        }
        
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color:white;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }
        
        form {
            padding: 10px;
            width: 100%; /* Ensure form width stretches to match parent */
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }
        
        input[type="text"],
        input[type="date"],
        input[type="file"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s;
        }
        
        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="file"]:focus {
            outline: none;
            border-color: #007bff;
        }
        
        input[type="radio"] {
            display: inline-block;
            margin-right: 10px;
            margin-bottom: 8px;
        }
        
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        
        footer {
            background-color: #343a40;
            text-align: center;
            color: #fff;
            margin-top: 20px;
            padding: 20px 0;
        }
        
        footer a {
            color: #fff;
            text-decoration: none;
        }
        
        footer a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form_div">
        <h1>Device Repairing Form</h1>
        <form action="/addDevice" method="post" enctype="multipart/form-data">
            <fieldset>
                
              <label for="mobNo">Register Mobile Number</label>
                  <input type="text" name="mobNo" placeholder="e.g., 1234567890" id="mobNo">
                
                <label for="peripheral">Peripheral</label>
                <input type="text" name="peripheral" placeholder="e.g., laptop, mobile, tablet" id="peripheral">
                <label for="devicename">Device Name</label>
                <input type="text" name="devicename" id="devicename" placeholder="Enter device name">
                <label for="devicemodel">Device Model</label>
                <input type="text" name="devicemodel" id="devicemodel" placeholder="Enter device model">
                <label for="devicecompany">Device Company</label>
                <input type="text" name="devicecompany" id="devicecompany" placeholder="Enter device company">
                <label for="deviceproblem">Device Problem</label>
                <input type="text" name="deviceproblem" id="deviceproblem" placeholder="Enter device problem">
            </fieldset>

            <fieldset>
                <legend>Repairing Status</legend>
                <input type="radio" name="reparingStatus" value="scrap" id="scrap">
                <label for="scrap">Scrap</label>
                <input type="radio" name="reparingStatus" value="inprocess" id="inprocess">
                <label for="inprocess">In Process</label>
                <input type="radio" name="reparingStatus" value="complete" id="complete">
                <label for="complete">Complete</label>
            </fieldset>

            <fieldset>
                <legend>Payment Status</legend>
                <input type="radio" name="paymentStatus" value="paid" id="paid">
                <label for="paid">Paid</label>
                <input type="radio" name="paymentStatus" value="advance" id="advance">
                <label for="advance">Advance</label>
                <input type="radio" name="paymentStatus" value="notpaid" id="notpaid">
                <label for="notpaid">Not Paid</label>
            </fieldset>

            <fieldset>
                <legend>Billing Details</legend>
                <label for="partName">Part Name</label>
                <input type="text" name="partName" id="partName" placeholder="Enter part name">
                <label for="price">Price</label>
                <input type="text" name="price" id="price" placeholder="Enter price">
            </fieldset>

           <label for="billRecipt">Upload a Billing Receipt</label>
           <input type="file" name="billrecipt" id="billRecipt" placeholder="Upload receipt">

            <label for="date">Date</label>
            <input type="date" name="date" id="date">

            <input type="submit" value="Submit Form">
        </form>
    </div>
    <!-- Footer -->
    <footer>
        <div class="container">
            <p>&copy; 2024 Designed and maintained by <a href="#" target="_blank">NetSec Technology</a>. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
