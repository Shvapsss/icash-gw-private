package com.icashgw.controller;

import com.icashgw.entity.HostCash;
import com.icashgw.service.TokenRoutingServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
public class TokenRoutingController {

    @Autowired
    private TokenRoutingServise tokenRoutingServise;

    @RequestMapping("/gethost")
    // public MapCash hello(@RequestParam String name){
    public List<HostCash> auth(@RequestHeader String token){
        return tokenRoutingServise.hosts(token);
    }
    //health check

    @PostMapping("/execute/**")
    public String execute(@RequestHeader String token, @RequestBody String body, HttpServletRequest httpServletRequest){
        RestTemplate restTemplate = new RestTemplate();
        List<HostCash> hosts = tokenRoutingServise.hosts(token);
        HostCash hostURL = hosts.get(0);
        //HostCash hostURL = hosts.get(new Random().nextInt(hosts.size()-1));
        //String hostURL = hosts;
        //HostCash hostURL = hosts.get((int)Math.random() * (hosts.size()-1));
        String path = httpServletRequest.getRequestURL().toString().split("/execute/")[1];
        HttpMethod httpMethod = HttpMethod.resolve(httpServletRequest.getMethod().toUpperCase());
        HttpHeaders headers = new HttpHeaders();
        //headers.add("username",username.getValue());

        String response = restTemplate.exchange("http://"+hostURL.getHost()+":"+hostURL.getPort()+"/"+path, httpMethod,new HttpEntity<>(body,headers),String.class).getBody();
        return response;

    }
    @GetMapping("/execute/**")
    public String execute(@RequestHeader String token, HttpServletRequest httpServletRequest) {
        return execute(token,"",httpServletRequest);
    }

}
