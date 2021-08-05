package com.icashgw.icashgw.controller;

import com.icashgw.icashgw.entity.MapCashBox;
import com.icashgw.icashgw.entity.User;
import com.icashgw.icashgw.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class QueueRoutingController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/queue")
    public String setQueueRouting(
            @RequestHeader String username,
            @RequestHeader String password,
            @RequestHeader String token,
            @RequestHeader String json
    )
    {
        User userFind = userRepository.findByUsername(username);
        if(userFind!= null && userFind.getPassword().equals(password)){
            return "Верны данные авторизации.";
//            String token = UUID.randomUUID().toString();
//            MapCashBox mapCashBox = new MapCashBox();
//            mapCashBox.setToken(token);
//            mapCashBox.setOrganization(inn);
//            mapCashRepository.save(mapCashBox);
//
//            return token;
        }else{
            return "Не верны данные авторизации.";
        }

    }
}
