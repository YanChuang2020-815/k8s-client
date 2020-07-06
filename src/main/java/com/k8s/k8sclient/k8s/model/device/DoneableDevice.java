package com.k8s.k8sclient.k8s.model.device;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.CustomResourceDoneable;

/**
 * Created by rongshuai on 2020/7/2 18:49
 */
public class DoneableDevice extends CustomResourceDoneable<EdgeDevice> {
    public DoneableDevice(EdgeDevice resource, Function function) {
        super(resource, function);
    }
}
