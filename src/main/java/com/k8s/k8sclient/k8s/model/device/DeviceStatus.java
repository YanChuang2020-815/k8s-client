package com.k8s.k8sclient.k8s.model.device;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionStatus;
import lombok.Data;

import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 18:22
 */
@Data
public class DeviceStatus extends CustomResourceDefinitionStatus {
    private static final long serialVersionUID = 4141618159868320004L;

    private List<DeviceTwin> twins;
}
