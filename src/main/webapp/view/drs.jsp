<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Device Information Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"], input[type="tel"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="radio"] {
        display: inline-block;
        margin-right: 10px;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<div class="container">
    <h2>Device Information Form</h2>
    <form id="deviceForm" action="/submitForm" method="post">

        <label for="customerName">Customer Name:</label>
        <input type="text" id="customerName" name="customerName" required>

        <label for="customerAddress">Address:</label>
        <input type="text" id="customerAddress" name="customerAddress" required>

        <label for="phoneNumber">Phone Number:</label>
        <input type="tel" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}" required>

        <label>Type of Device:</label><br>
        <input type="radio" id="laptop" name="deviceType" value="laptop" required>
        <label for="laptop">Laptop</label>
        <input type="radio" id="desktop" name="deviceType" value="desktop">
        <label for="desktop">Desktop</label>
        <input type="radio" id="printer" name="deviceType" value="printer">
        <label for="printer">Printer</label>
        <input type="radio" id="cctv" name="deviceType" value="cctv">
        <label for="cctv">CCTV</label>
        <input type="radio" id="other" name="deviceType" value="other">
        <label for="other">Other</label><br>

        <label for="serialNumber">Serial Number:</label>
        <input type="text" id="serialNumber" name="serialNumber">

        <label for="modelNumber">Model Number:</label>
        <input type="text" id="modelNumber" name="modelNumber">

        <label>Adaptor:</label><br>
        <input type="radio" id="adaptorYes" name="adaptor" value="yes">
        <label for="adaptorYes">Yes</label>
        <input type="radio" id="adaptorNo" name="adaptor" value="no">
        <label for="adaptorNo">No</label><br>

        <input type="submit" value="Submit">
    </form>
</div>

<script>
    document.getElementById("deviceForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent the form from submitting normally

        // Extract form data
        const formData = new FormData(event.target);
        const customerName = formData.get("customerName");
        const customerAddress = formData.get("customerAddress");
        const phoneNumber = formData.get("phoneNumber");
        const deviceType = formData.get("deviceType");
        const serialNumber = formData.get("serialNumber");
        const modelNumber = formData.get("modelNumber");
        const adaptor = formData.get("adaptor");

        // Compose WhatsApp message
        const message = `Customer Name: ${customerName}\nAddress: ${customerAddress}\nPhone Number: ${phoneNumber}\nType of Device: ${deviceType}\nSerial Number: ${serialNumber}\nModel Number: ${modelNumber}\nAdaptor: ${adaptor}`;

        // Simulate sending WhatsApp message
        alert("WhatsApp message:\n\n" + message);
    });
</script>

</body>
</html>
