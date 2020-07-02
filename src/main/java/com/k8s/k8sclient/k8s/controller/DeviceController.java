package com.k8s.k8sclient.k8s.controller;

import com.k8s.k8sclient.k8s.model.device.Device;
import com.k8s.k8sclient.k8s.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 15:25
 */
@RestController
@RequestMapping("device")
@Api(value = "k8s",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeviceController {
    @Resource
    private DeviceService deviceService;

    @GetMapping("getAllDevice")
    @ApiOperation( "获取全部设备")
    public List<Device> getAllDevice() {
        return deviceService.getAllDevice();
    }

    @PostMapping("watchDevice")
    @ApiOperation( "监听指定设备")
    public void watchDevice(@RequestBody Device device) {
        deviceService.watchDeviceStatus(device);
    }
}
