package com.bupt.controller;

import com.bupt.domain.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by CJ on 2017-10-24.
 */
@Controller
@RequestMapping("/")
public class RabbitMQController {
    @Autowired
    Sender sender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void send(){
        sender.send();
    }
}
