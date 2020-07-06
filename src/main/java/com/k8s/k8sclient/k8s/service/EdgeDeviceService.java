package com.k8s.k8sclient.k8s.service;

import com.k8s.k8sclient.k8s.model.device.EdgeDevice;

import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 15:27
 */
public interface EdgeDeviceService {
    void watchDeviceStatus(EdgeDevice edgeDevice);

    List<EdgeDevice> getAllDevice();

    Object getAllDeviceModel();
}
