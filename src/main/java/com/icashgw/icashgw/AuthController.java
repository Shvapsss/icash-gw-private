package com.icashgw.icashgw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapCashRepository mapCashRepository;

    @RequestMapping("/generatetoken")
    public String getAuth(@RequestHeader String user, @RequestHeader String password)
    {
        User user1 = userRepository.findByUsername(user);

        if(user1!= null && user1.getPassword().equals(password)){

            String token = UUID.randomUUID().toString();
            MapCash mapCash = new MapCash();
            mapCash.setToken(token);
            mapCashRepository.save(mapCash);

             return token;
        }else{
            return "Не верны данные авторизации.";
        }

    }

}
