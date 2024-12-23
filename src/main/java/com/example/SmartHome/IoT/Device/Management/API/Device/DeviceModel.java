package com.example.SmartHome.IoT.Device.Management.API.Device;

public class DeviceModel {
    private int deviceID;
    private String deviceType;
    private String deviceName;
    private String location;
    private String status;

    public DeviceModel(int DeviceID,String deviceType,String deviceName,String Location,String status){
        this.deviceID  = DeviceID;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.location = Location;
        this.status = status;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
