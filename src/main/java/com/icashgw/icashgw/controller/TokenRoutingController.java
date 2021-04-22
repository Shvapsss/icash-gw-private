package com.icashgw.icashgw.controller;

import com.icashgw.icashgw.service.TokenRoutingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TokenRoutingController {

    @Autowired
    private TokenRoutingServise tokenRoutingServise;

    @RequestMapping("/cashbox")
    // public MapCash hello(@RequestParam String name){
    public List<String> auth(@RequestHeader String token){
        return tokenRoutingServise.hosts(token);
    }
    //health check

    @RequestMapping("/execute")
    public String execute(@RequestHeader String token, HttpServletRequest httpServletRequest){
        List<String> hosts = tokenRoutingServise.hosts(token);
        String hostURL = hosts.get(0);

        return "";
    }

}
