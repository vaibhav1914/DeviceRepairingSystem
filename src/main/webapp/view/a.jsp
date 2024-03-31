<!DOCTYPE html>
<%@page import="com.DevicesReparingServices.DevicesReparingServices.Model.DeviceInfo"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DataList</title>
    <style>
    body{
    	margin:0px;
        	padding:0px;
    }
        .container {
            width: 95%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow-x: auto; /* Enable horizontal scrollbar if needed */
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 6px; /* Reduced padding for smaller rows and columns */
            text-align: left;
            border-bottom: 1px solid #ddd;
            font-size: 14px; /* Reduced font size */
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold; /* Making table headers bold */
        }

        .table-name {
            color: #007bff; /* Change color for table name */
            font-size: 24px; /* Adjust font size if needed */
            margin-bottom: 10px; /* Add some margin to separate table name from the table */
        }

        .apply-button {
            background-color: #007bff;
            color: #fff;
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .apply-button:hover {
            background-color: #0056b3;
        }
         footer {
            background-color: #343a40;
            text-align: center;
            color: #fff;
            margin: 1rem 0 0 0;
            padding: 20px 0;
        }

        
    </style>
</head>
<body>
    <div class="container">
        <div class="table-name">DataList</div>
        <table>
            <thead>
                <tr>
                    <th>Device Company</th>
                    <th>Mobile Number</th>
                    <th>Device Model</th>
                    <th>Device Problem</th>
                    <th>Payment Status</th>
                    <th>Peripheral</th>
                    <th>Price</th>
                    <th>Repairing Status</th>
                    <th>Date</th>
                    <th>Bill Receipt</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<DeviceInfo> entityList = (List<DeviceInfo>) request.getAttribute("indexList");
                if (entityList != null && !entityList.isEmpty()) {
                    for (DeviceInfo entity : entityList) {
                        String billReceipt = entity.getBillReciptPath(); // Assuming you have a method to get the receipt path
                %>
                <tr>
                    <td><%= entity.getDevicecompany() %></td>
                    <td><%= entity.getMobNo() %></td>
                    <td><%= entity.getDevicemodel() %></td>
                    <td><%= entity.getDevicename() %></td>
                    <td><%= entity.getPaymentStatus()%></td>
                    <td><%= entity.getPeripheral()%></td>
                    <td><%= entity.getPrice()%></td>
                    <td><%= entity.getReparingStatus() %></td>
                    <td><%= entity.getDate() %></td>
                    <td><a href="<%= entity.getBillReciptPath() %>">Download Receipt</a></td>
                </tr>
                <% 
                    } 
                } else { 
                %>
                <tr>
                    <td colspan="12">No data listings available.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <!-- Footer -->
    <footer>
        <div>
            <p>&copy; 2024 Designed and maintained by NetSec Technology. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
