package com.icashgw.controller;

import com.icashgw.entity.JsonRequest;
import com.icashgw.entity.MapCashBox;
import com.icashgw.entity.User;
import com.icashgw.enums.StatusRequest;
import com.icashgw.repo.JsonReqestRepository;
import com.icashgw.repo.MapCashRepository;
import com.icashgw.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class QueueRoutingController {
    @Autowired
    private JsonReqestRepository jsonReqestRepository;
//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private MapCashRepository mapCashRepository;

    @RequestMapping("/queue")
    public String setQueueRouting(
//            @RequestHeader String username,
//            @RequestHeader String password,
            @RequestHeader String token,
            @RequestHeader String json
    )
    {
//        User userFind = userRepository.findByUsername(username);
//        if(userFind!= null && userFind.getPassword().equals(password)){
        String tokenFind = mapCashRepository.findByToken(token).getToken();
        if(tokenFind!= null & tokenFind.equals(token))
        {
            JsonRequest jsonReqest = new JsonRequest();
            jsonReqest.setJson(json);
            jsonReqest.setToken(token);
            jsonReqest.setDateOfReceipt(new Date());
            jsonReqest.setStatusRequest(StatusRequest.NEW);
            jsonReqestRepository.save(jsonReqest);

            return "ok";
        }else{
            return "Не верны данные авторизации.";
        }

    }
}
