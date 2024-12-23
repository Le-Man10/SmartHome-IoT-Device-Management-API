package com.example.SmartHome.IoT.Device.Management.API.Device;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/devices")
public class DeviceController {
    ResponseEntity<DeviceModel> device ;
    ResponseEntity<Map<String,String>> Response;
    @PostMapping("")
    public ResponseEntity<Map<String,String>>postdevice(@RequestBody Map<String,String> request) {
        
        return Response;
    }
    @PostMapping("/{deviceId}/control")
    public ResponseEntity<Map<String,String>> postControlCommand (@RequestParam int deviceID,@RequestBody Map<String,String> request) {
        return Response ;
    }
    @PostMapping("/{deviceId}/status")
    public ResponseEntity<Map<String,String>> postStatus(@RequestParam int deviceID,@RequestBody Map<String,String> request) {
        
        return Response ; 
    }
    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceModel> getMethodName(@RequestParam int deviceId) {
        return device;
    }
    @GetMapping("")
    public ArrayList<ResponseEntity<DeviceModel>> getalldevices() {
        ArrayList<ResponseEntity<DeviceModel>> devices = null;
        return devices;
    }@PutMapping("/{deviceid}")
    public ResponseEntity<DeviceModel> putdevice(@PathVariable int id, @RequestBody Map<String,String> request) {
        //TODO: process PUT request
        
        return device;
    }
    @DeleteMapping("/{deviceId}")
    public ResponseEntity<Map<String,String>> deletedevice(@PathVariable int id) {
        //TODO: process PUT request
        
        return Response;
    }
    @GetMapping("/{deviceId}/status-history")
    public ResponseEntity<Map<String,String>> getstatushistory(@RequestParam int deviceid) {
        return Response;
    }
    @PostMapping("/bulk")
    public ResponseEntity<Map<String,String>> postBulk(@RequestBody ArrayList<Map<String,String>> request) {
        //TODO: process POST request
        return Response;
    }
    
    

    
    
    
}
