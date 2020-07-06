package com.k8s.k8sclient.k8s.controller;

import com.k8s.k8sclient.k8s.model.device.EdgeDevice;
import com.k8s.k8sclient.k8s.service.EdgeDeviceService;
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
@RequestMapping("edgeDevice")
@Api(value = "k8s",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EdgeDeviceController {
    @Resource
    private EdgeDeviceService edgeDeviceService;

    @GetMapping("getAllEdgeDevice")
    @ApiOperation( "获取全部设备")
    public List<EdgeDevice> getAllDevice() {
        return edgeDeviceService.getAllDevice();
    }

    @PostMapping("watchEdgeDevice")
    @ApiOperation( "监听指定设备")
    public void watchDevice(@RequestBody EdgeDevice edgeDevice) {
        edgeDeviceService.watchDeviceStatus(edgeDevice);
    }

    @GetMapping("getAllEdgeDeviceModel")
    @ApiOperation("获取全部设备类型")
    public Object getAllEdgeDeviceModel() {
        return edgeDeviceService.getAllDeviceModel();
    }
}
