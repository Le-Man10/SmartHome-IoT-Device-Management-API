# SmartHome-IoT-Device-Management-API

# Overview

**Purpose:** managing IoT devices in a smart home environment.  
**Target Audience:** Smarthome residents  
**Version:**v1  

# Authentication  
**Authentication type:**JWT  
**Purpose for chosen Authentication type:** offers token-based, stateless authentication. This will work well with the REST API.  
**Permissions**  
 - The user can register new devices, view all devices, Control the devices, update device information, delete device information and check device status.  
# Endpoint summary and details
**device Endpoints**  
1. Device Registration with examples  
Endpoint: POST/devices  

```json
{
    "deviceId": "device001",
    "deviceType": "light",
    "deviceName": "Living Room Light",
    "location": "Living Room",
    "status": "off"
}  

```json  
{
    "deviceId": "device002",
    "deviceType": "thermostat",
    "deviceName": "Main Thermostat",
    "location": "Hallway",
    "status": "off"
}  
2. Device Control with examples

Endpoint: POST/devices/{deviceId}/control

```json
{
    "command": "turn_on",
    "parameters": {
        "brightness": 75
    }
}


```json
{
    "command": "set_temperature",
    "parameters": {
        "temperature": 22
    }
}
3. Status Updates
Endpoint: POST/devices/{deviceId}/status
Request Body Example 1

{
    "status": "on",
    "timestamp": "2024-06-14T10:00:00Z"
}
Request Body Example 2
{
    "status": "off",
    "timestamp": "2024-06-14T11:00:00Z"
}  

**users endpoint**
 


