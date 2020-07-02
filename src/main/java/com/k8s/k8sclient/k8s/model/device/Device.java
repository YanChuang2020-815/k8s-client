package com.k8s.k8sclient.k8s.model.device;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import lombok.Data;

/**
 * Created by rongshuai on 2020/7/2 17:06
 */
@Data
public class Device extends CustomResource implements Namespaced {
    private static final long serialVersionUID = 7828260264410099956L;

    private DeviceSpec spec;

    private DeviceStatus status;
}
