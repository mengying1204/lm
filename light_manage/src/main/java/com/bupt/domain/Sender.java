package com.bupt.domain;

import com.bupt.common.utils.NumberUtills;
import com.bupt.service.LightService;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created by CJ on 2017/10/24.
 */
@Component
public class Sender {
	@Autowired
	LightService lightService;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Scheduled(fixedRate = 5000)
	public void send() {
		List<Light> lights=lightService.findAll();
		int size=lights.size();
		Random random=new Random();
		int num= random.nextInt(size);
		Light light=lights.get(num);
		light.setState(NumberUtills.state());

		String context=new Gson().toJson(light);

		//String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("monitor", context);
	}

}