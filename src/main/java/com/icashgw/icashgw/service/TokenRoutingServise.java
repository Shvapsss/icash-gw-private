package com.icashgw.icashgw.service;

import com.icashgw.icashgw.repo.MapCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenRoutingServise {
    @Autowired
    private MapCashRepository mapCashRepository;

    public List<String> hosts(String token){
        return mapCashRepository.findById(token).get().getHost();
//
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("1/1");
//        arrayList.add("1/2");
//        arrayList.add("1/3");

        //arrayList.add(mapCashRepository.findById(token));
//        MapCash mapCash = new MapCash();
//        mapCash.setToken("132t");
//        mapCash.setHost(arrayList);
//        mapCashRepository.save(mapCash);

        //UUID.randomUUID();


    }

}
