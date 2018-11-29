package com.qgqcc.springcloud.configclient.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * PropertySourceLocator 自定义PropertySourceLocator的实现
 * @author 繁华
 * @create 2018-11-19
 **/
public class MyPropertySourceLocator implements PropertySourceLocator{

    @Override
    public PropertySource<?> locate(Environment environment) {
        if (environment instanceof ConfigurableEnvironment){
            ConfigurableEnvironment cast = ConfigurableEnvironment.class.cast(environment);
            MutablePropertySources propertySources = cast.getPropertySources();
            //定义一个新的 propertySource，并且插入到首位
            propertySources.addFirst(createPropertySource());
        }
        return null;
    }

    private PropertySource createPropertySource(){
        Map<String,Object> source = new HashMap<>();
        source.put("spring.application.name","spring-cloud-cc");
        //设置名称和来源
        PropertySource propertySource = new MapPropertySource("spring-cloud-myPropertySource",source);
        return propertySource;
    }
}
