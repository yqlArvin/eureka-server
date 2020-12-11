package com.eureka;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by yuql on 2019/2/21.
 */
@Component
public class EurekaStateChangeListener {

    /**
     * 服务下线事件
     * @param eurekaInstanceCanceledEvent
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(appName);
        System.out.println(serverId);
        System.out.println("注意：服务已下线");
    }

    /**
     * 服务注册事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);
        System.out.println("注意：服务已注册");
    }

    /**
     * 服务续约事件
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
        System.out.println("注意：服务已续约");
    }

    /**
     * 注册中心启动事件
     * @param event
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        System.out.println("注意：注册中心启动");
    }

    /**
     * 启动事件
     * @param event
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        System.out.println("注意：服务已启动");
    }
}