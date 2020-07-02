package com.k8s.k8sclient.k8s.service;

import com.k8s.k8sclient.k8s.model.device.Device;

import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 15:27
 */
public interface DeviceService {
    void watchDeviceStatus(Device device);

    List<Device> getAllDevice();
}
