package com.k8s.k8sclient.k8s.model.deviceModel;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.k8s.k8sclient.k8s.model.modelType.ModelType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by rongshuai on 2020/7/6 11:53
 */
@Data
public class DeviceModelProperty implements Serializable {
    private static final long serialVersionUID = -6470127224282448887L;

    private String name;

    private String description;

    private ModelType type;
}
