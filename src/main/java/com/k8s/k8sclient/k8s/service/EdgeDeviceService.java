package com.k8s.k8sclient.k8s.service;

import com.k8s.k8sclient.k8s.model.device.EdgeDevice;
import com.k8s.k8sclient.k8s.model.deviceModel.EdgeDeviceModel;

import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 15:27
 */
public interface EdgeDeviceService {
    void watchDeviceStatus(EdgeDevice edgeDevice);

    void watchResourceStatus();

    List<EdgeDevice> getAllDevice();

    List<EdgeDeviceModel> getAllDeviceModel();

    void createEdgeDeviceModel(EdgeDeviceModel edgeDeviceModel);

    void createEdgeDevice(EdgeDevice edgeDevice);
}
