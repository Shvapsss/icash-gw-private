package com.icashgw.icashgw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TokenRoutingServise tokenRoutingServise;

    @RequestMapping("/cash")
    // public MapCash hello(@RequestParam String name){
    public List<String> auth(@RequestHeader String token){
        return tokenRoutingServise.hosts(token);
    }
    //hels check

}
