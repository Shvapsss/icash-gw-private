package com.icashgw.controller;

import com.google.gson.Gson;
import com.icashgw.entity.HostCash;
import com.icashgw.entity.MapCashBox;
import com.icashgw.entity.User;
import com.icashgw.enums.TypeCashBox;
import com.icashgw.repo.MapCashRepository;
import com.icashgw.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
public class GenerateTokenController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapCashRepository mapCashRepository;

    @RequestMapping("/generatebox")
    public String setGenerateToken(
            @RequestHeader String username,
            @RequestHeader String inn,
            @RequestHeader String kpp,
            //@RequestHeader List<HostCash> hosts,
            @RequestBody String body,
            @RequestHeader String password
    )
    {
        User userFind = userRepository.findByUsername(username);
        if(userFind!= null && userFind.getPassword().equals(password)){

            List<HostCash> hosts = new Gson().fromJson(body, List.class);

            String token = UUID.randomUUID().toString();
            MapCashBox mapCashBox = new MapCashBox(inn,kpp,token);
            if(hosts.size()>1){
                mapCashBox.setType(TypeCashBox.POOL);
            }else {
                mapCashBox.setType(TypeCashBox.BOX);
            }
            mapCashBox.setHost(hosts);
            mapCashRepository.save(mapCashBox);

             return token;
        }else{
            return "Не верны данные авторизации.";
        }

    }

    @RequestMapping("/updatehost")
    public String setUpdateToken(
            @RequestHeader String token,
            @RequestHeader String username,
            @RequestHeader String password,
            @RequestBody String body)
    {
        User userFind = userRepository.findByUsername(username);
        if(userFind!= null && userFind.getPassword().equals(password)){
            MapCashBox tokenFindObj = mapCashRepository.findById(token).get();
            List<HostCash> hosts = new Gson().fromJson(body, List.class);
            tokenFindObj.setHost(hosts);
            return "update:ok";
        }else{
            return "Не верны данные авторизации.";
        }


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

        //return tokenFindObj.getToken();
    }


}
