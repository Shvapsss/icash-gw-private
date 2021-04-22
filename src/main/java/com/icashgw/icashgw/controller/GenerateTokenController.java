package com.icashgw.icashgw.controller;

import com.icashgw.icashgw.entity.MapCashBox;
import com.icashgw.icashgw.entity.User;
import com.icashgw.icashgw.repo.MapCashRepository;
import com.icashgw.icashgw.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class GenerateTokenController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapCashRepository mapCashRepository;

    @RequestMapping("/generatetoken")
    public String setGenerateToken(
            @RequestHeader String username,
            @RequestHeader String inn,
            @RequestHeader String password
    )
    {
        User userFind = userRepository.findByUsername(username);
        if(userFind!= null && userFind.getPassword().equals(password)){

            String token = UUID.randomUUID().toString();
            MapCashBox mapCashBox = new MapCashBox();
            mapCashBox.setToken(token);
            mapCashBox.setInn(inn);
            mapCashRepository.save(mapCashBox);

             return token;
        }else{
            return "Не верны данные авторизации.";
        }

    }

    @RequestMapping("/updatetoken")
    public String setUpdateToken(@RequestHeader String token, @RequestHeader String host)
    {
        MapCashBox tokenFindObj = mapCashRepository.findById(token).get();




//        User userFind = userRepository.findByUsername(username);
//        if(userFind!= null && userFind.getPassword().equals(password)){
//
//            String token = UUID.randomUUID().toString();
//            MapCashBox mapCashBox = new MapCashBox();
//            mapCashBox.setToken(token);
//            mapCashRepository.save(mapCashBox);
//
//            return token;
//        }else{
//            return "Не верны данные авторизации.";
//        }

        return tokenFindObj.getToken();
    }


}
