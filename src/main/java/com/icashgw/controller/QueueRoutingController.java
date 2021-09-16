package com.icashgw.controller;

import com.icashgw.entity.JsonRequest;
import com.icashgw.entity.MapCashBox;
import com.icashgw.enums.StatusRequest;
import com.icashgw.repo.JsonReqestRepository;
import com.icashgw.repo.MapCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class QueueRoutingController {
    @Autowired
    JsonReqestRepository jsonReqestRepository;
    @Autowired
    MapCashRepository mapCashRepository;

    @RequestMapping("/queue/**")
    public String setQueueRouting(
            @RequestHeader String token,
            @RequestBody String json,
            HttpServletRequest httpServletRequest
           // @RequestHeader String json
    )
    {
//        User userFind = userRepository.findByUsername(username);
//        if(userFind!= null && userFind.getPassword().equals(password)){
        String path = httpServletRequest.getRequestURL().toString().split("/queue/")[1];
        MapCashBox tokenFind = mapCashRepository.findByToken(token);
        if (tokenFind!= null && tokenFind.getToken().equals(token))
        {
            JsonRequest jsonReqest = new JsonRequest(json,path,token,new Date(),StatusRequest.NEW,new Date());
            jsonReqestRepository.save(jsonReqest);

            return jsonReqest.get_id().toString();
        }else{
            return "Не верно указаны данные авторизации.";
        }

    }
    @RequestMapping("/queuestatus")
    public String getStatus(
            @RequestHeader String token,
            @RequestHeader String request){
        //вернуть статус и json который отдала касса
        MapCashBox tokenFind = mapCashRepository.findByToken(token);
        if (tokenFind!= null && tokenFind.getToken().equals(token)) {
            return "status "+ jsonReqestRepository.findById(request).get().getStatusRequest().toString() + " responce " +jsonReqestRepository.findById(request).get().getRequest();
        }else {
            return "no index";
        }
    }
}
