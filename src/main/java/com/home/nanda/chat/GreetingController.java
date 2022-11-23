package com.home.nanda.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting(String message) throws Exception {
		Thread.sleep(500); // simulated delay
//		System.out.println(message);
		return message;
	}

}