package com.k8s.k8sclient.k8s.model.device;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/7/2 18:42
 */
@Data
public class DeviceDesiredMetadata implements Serializable {
    private static final long serialVersionUID = 4543902750763795816L;

    private String type;
}
