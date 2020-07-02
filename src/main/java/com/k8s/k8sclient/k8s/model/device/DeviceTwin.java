package com.k8s.k8sclient.k8s.model.device;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/7/2 18:36
 */
@Data
public class DeviceTwin implements Serializable {
    private static final long serialVersionUID = 195692202174978859L;

    private String propertyName;

    private DeviceDesired desired;
}
