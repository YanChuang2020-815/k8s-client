package com.k8s.k8sclient.k8s.service.impl;


import com.k8s.k8sclient.k8s.crd.DoneableDummy;
import com.k8s.k8sclient.k8s.crd.Dummy;
import com.k8s.k8sclient.k8s.crd.DummyList;
import com.k8s.k8sclient.k8s.model.device.Device;
import com.k8s.k8sclient.k8s.model.device.DeviceList;
import com.k8s.k8sclient.k8s.model.device.DoneableDevice;
import com.k8s.k8sclient.k8s.service.DeviceService;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionList;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.fabric8.kubernetes.client.dsl.Resource;
import java.util.List;

/**
 * Created by rongshuai on 2020/7/2 15:28
 */
@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private KubernetesClient k8sClient;

    public static String DEVICE_CRD_GROUP = "devices.kubeedge.io";
    public static String DEVICE_CRD_NAME = "devices." +  DEVICE_CRD_GROUP;

    @Override
    public void watchDeviceStatus(Device device) {
        CustomResourceDefinitionList crds = k8sClient.customResourceDefinitions().list();
        List<CustomResourceDefinition> crdsItems = crds.getItems();
        System.out.println("Found " + crdsItems.size() + " CRD(s)");
        CustomResourceDefinition deviceCRD = null;
        for (CustomResourceDefinition crd : crdsItems) {
            ObjectMeta metadata = crd.getMetadata();
            if (metadata != null) {
                String name = metadata.getName();
                System.out.println("    " + name + " => " + metadata.getSelfLink());
                if (DEVICE_CRD_NAME.equals(name)) {
                    deviceCRD = crd;
                }
            }
        }

        NonNamespaceOperation<Device, DeviceList, DoneableDevice, Resource<Device, DoneableDevice>> deviceClient =
                k8sClient.customResources(deviceCRD, Device.class, DeviceList.class, DoneableDevice.class);

//        Device created = new Device();
//        ObjectMeta metadata = new ObjectMeta();
//        metadata.setName();
        deviceClient.withResourceVersion(device.getMetadata().getResourceVersion()).watch(new Watcher<Device>() {
            @Override
            public void eventReceived(Action action, Device resource) {
                System.out.println("==> " + action + " for " + resource);
                if (resource.getSpec() == null) {
                    log.error("No Spec for resource " + resource);
                }
            }

            @Override
            public void onClose(KubernetesClientException cause) {
            }
        });

    }

    @Override
    public List<Device> getAllDevice() {
        CustomResourceDefinitionList crds = k8sClient.customResourceDefinitions().list();
        List<CustomResourceDefinition> crdsItems = crds.getItems();
        System.out.println("Found " + crdsItems.size() + " CRD(s)");
        CustomResourceDefinition deviceCRD = null;
        for (CustomResourceDefinition crd : crdsItems) {
            ObjectMeta metadata = crd.getMetadata();
            if (metadata != null) {
                String name = metadata.getName();
                System.out.println("    " + name + " => " + metadata.getSelfLink());
                if (DEVICE_CRD_NAME.equals(name)) {
                    deviceCRD = crd;
                }
            }
        }
        NonNamespaceOperation<Device, DeviceList, DoneableDevice, Resource<Device, DoneableDevice>> deviceClient =
                k8sClient.customResources(deviceCRD, Device.class, DeviceList.class, DoneableDevice.class);
        CustomResourceList<Device> deviceList = deviceClient.list();
        List<Device> items = deviceList.getItems();
        return items;
    }
}
