package com.qgqcc.springcloud.configclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	private final ContextRefresher contextRefresher;

	@Autowired
	public SpringCloudConfigClientApplication(ContextRefresher contextRefresher) {
		this.contextRefresher = contextRefresher;
	}

	/**
	 * 每个一秒自动更新
	 */
	@Scheduled(fixedRate = 1000L)
	public void update(){
		Set<String> refresh = contextRefresher.refresh();
		if (!refresh.isEmpty()){
			System.out.print("本次更新：" + refresh);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

}
