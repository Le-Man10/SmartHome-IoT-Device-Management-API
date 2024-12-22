# SmartHome-IoT-Device-Management-API

# Overview

**Purpose:** managing IoT devices in a smart home environment.  
**Target Audience:** Smarthome residents  
**Version:** v1  

# Authentication  
**Authentication type:** JWT  
  
**Purpose for chosen Authentication type:** offers token-based, stateless authentication. This will work well with the REST API.  
  
**Permissions**  
 - The user can register new devices, view all devices, Control the devices, update device information, delete device information and check device status.  
# Endpoint summary and details
**device Endpoints**  
1. Device Registration with examples  
**Endpoint:** POST/devices  
```json
{
    "deviceId": "device001",
    "deviceType": "light",
    "deviceName": "Living Room Light",
    "location": "Living Room",
    "status": "off"
}  
```

```json  
{
    "deviceId": "device002",
    "deviceType": "thermostat",
    "deviceName": "Main Thermostat",
    "location": "Hallway",
    "status": "off"
}  
```
2. Device Control with examples

**Endpoint:** POST/devices/{deviceId}/control

```json
{
    "command": "turn_on",
    "parameters": {
        "brightness": 75
    }
}
```

```json
{
    "command": "set_temperature",
    "parameters": {
        "temperature": 22
    }
}
```
3. Status Updates
**Endpoint:** POST/devices/{deviceId}/status

Request Body Example 1
```json
{
    "status": "on",
    "timestamp": "2024-06-14T10:00:00Z"
}
```
Request Body Example 2
```json
{
    "status": "off",
    "timestamp": "2024-06-14T11:00:00Z"
}
```
5. Device Query
**Endpoint:** GET/devices/{deviceId}  


Example Response 1
```json
{
    "deviceId": "device001",
    "deviceType": "light",
    "deviceName": "Living Room Light",
    "location": "Living Room",
    "status": "on"
}
```
Example Response 2
```json
{
    "deviceId": "device002",
    "deviceType": "thermostat",
    "deviceName": "Main Thermostat",
    "location": "Hallway",
    "status": "off"
}
```
6. Device List Query
**Endpoint:** GET/devices.    


Example Response
```json
[
    {
        "deviceId": "device001",
        "deviceType": "light",
        "deviceName": "Living Room Light",
        "location": "Living Room",
        "status": "on"
    },
    {
        "deviceId": "device002",
        "deviceType": "thermostat",
        "deviceName": "Main Thermostat",
        "location": "Hallway",
        "status": "off"
    }
]
```
7. User Profile Query
**Endpoint:** GET/users/{username}   

Example Response 1
```json
{
    "username": "john_doe",
    "email": "john@example.com",
    "registeredDevices": ["device001"]
}
```
Example Response 2
```json
{
    "username": "jane_smith",
    "email": "jane@example.com",
    "registeredDevices": ["device002"]
}
```
8. Update Device Information
**Endpoint:** PUT/devices/{deviceId}  


Request Body Example 1
```json
{
    "deviceName": "Living Room Main Light",
    "location": "Living Room",
    "status": "off"
}
```
Request Body Example 2
```json
{
    "deviceName": "Hallway Thermostat",
    "location": "Hallway",
    "status": "on"
}
```
 9. Device Registration with Invalid Data

 **Endpoint:** POST/devices    
 

 Request Body Example 1 (Missing Fields)
```json
 
{
    "deviceId": "device003",
    "deviceType": "camera"
    // Missing deviceName, location, and status
}
```
 Request Body Example 2 (Invalid Data Types)
```json
{
    "deviceId": 1003,  // Should be a string
    "deviceType": "sensor",
    "deviceName": "Garden Sensor",
    "location": "Garden",
    "status": true  // Should be a string ("on" or "off")
}
```
 10. Unauthorized Device Control Attempt

 **Endpoint:** POST/devices/{deviceId}/control.  

 Request Body Example
```json 
{
    "command": "turn_off",
    "parameters": {}
}
```
 Response Example
```json
{
    "error": "Unauthorized",
    "message": "User does not have permission to control this device."
}
```
 11. Device Status Update with Invalid Timestamp

 Endpoint: POST/devices/{deviceId}/status

 Request Body Example
 ```json
{
    "status": "on",
    "timestamp": "invalid-timestamp"
}
```
 Response Example
```json
{
    "error": "Invalid data",
    "message": "Timestamp is not in the correct format."
}
```
14. Device Deletion

 Endpoint: DELETE/devices/{deviceId}

 Example Request
 
// No body required
 Example Response

```json
{
    "message": "Device device001 successfully deleted."
}
```
 15. Retrieve Device Status History

 Endpoint: GET /devices/{deviceId}/status-history

 Example Response
 ```json
[
    {
        "status": "off",
        "timestamp": "2024-06-14T09:00:00Z"
    },
    {
        "status": "on",
        "timestamp": "2024-06-14T10:00:00Z"
    },
    {
        "status": "off",
        "timestamp": "2024-06-14T11:00:00Z"
    }
]
```
 16. Bulk Device Registration

 Endpoint: POST/devices/bulk

 Request Body Example  
```json
[
    {
        "deviceId": "device004",
        "deviceType": "light",
        "deviceName": "Kitchen Light",
        "location": "Kitchen",
        "status": "off"
    },
    {
        "deviceId": "device005",
        "deviceType": "camera",
        "deviceName": "Front Door Camera",
        "location": "Front Door",
        "status": "on"
    }
]
```
 Example Response
```json

{
    "message": "Bulk device registration successful.",
    "registeredDevices": ["device004", "device005"]
}
```
 17. Device Control with Invalid Command

 Endpoint: POST/devices/{deviceId}/control

 Request Body Example
```json
{
    "command": "invalid_command",
    "parameters": {}
}
```
 Response Example
```json

{
    "error": "Bad Request",
    "message": "Invalid control command."
}
```
20. Device Control with Missing Parameters

 Endpoint: POST/devices/{deviceId}/control

 Request Body Example
 ```json
{
    "command": "set_temperature"
    // Missing "parameters" field
}
```
 Response Example
```json

{
    "error": "Bad Request",
    "message": "Parameters are required for this command."
}
```

**users endpoint**
 
User Registration Endpoint: POST/users/register
Request Body Example 1
```json
{
    "username": "john_doe",
    "password": "SecurePass123",
    "email": "john@example.com"
}
```
Request Body Example 2
```json
{
    "username": "jane_smith",
    "password": "AnotherPass456",
    "email": "jane@example.com"
}
```
User Login Endpoint: POST/users/login

Request Body Example 1
```json
{
    "username": "john_doe",
    "password": "SecurePass123"
}
```
Request Body Example 2
```json
{
    "username": "jane_smith",
    "password": "AnotherPass456"
}
```
 12. User Registration with Duplicate Username

 Endpoint: POST/users/register

 Request Body Example
```json
{
    "username": "john_doe",
    "password": "NewSecurePass789",
    "email": "newjohn@example.com"
}
```
 Response Example
```json
 {
    "error": "Conflict",
    "message": "Username already exists."
}
```
 13. User Login with Incorrect Password

 Endpoint: POST/users/login

 Request Body Example
```json

{
    "username": "john_doe",
    "password": "WrongPass123"
}
```
 Response Example
 ```json
{
    "error": "Unauthorized",
    "message": "Incorrect username or password."
}
```
18. Retrieve All Devices for a User

 Endpoint: GET/users/{username}/devices

 Example Response
```json

[
    {
        "deviceId": "device001",
        "deviceType": "light",
        "deviceName": "Living Room Light",
        "location": "Living Room",
        "status": "on"
    },
    {
        "deviceId": "device003",
        "deviceType": "camera",
        "deviceName": "Front Yard Camera",
        "location": "Front Yard",
        "status": "off"
    }
]
```

 19. Update User Profile Information

 Endpoint: PUT/users/{username}

 Request Body Example
```json 
{
    "email": "newemail@example.com",
    "password": "NewSecurePass789"
}
```
 Example Response
 ```json
{
    "message": "User profile updated successfully."
}
```
