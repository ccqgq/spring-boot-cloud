package com.qgqcc.springcloud.configclient.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * bootstrap的配置bean
 * @author 繁华
 * @create 2018-11-19
 **/
@Configuration
public class MyConfiguration implements ApplicationContextInitializer{

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //从spring的上下文中获取ConfigurableEnvironment
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        //定义一个新的 propertySource，并且插入到首位
        propertySources.addFirst(createPropertySource());

    }
    private PropertySource createPropertySource(){
        Map<String,Object> source = new HashMap<>();
        source.put("ccqgq","qiguoqiang");

        PropertySource propertySource = new MapPropertySource("myPropertySource",source);
        return propertySource;
    }
}
