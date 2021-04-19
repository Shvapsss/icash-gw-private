package com.icashgw.icashgw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TokenRoutingServise {
    @Autowired
    private MapCashRepository mapCashRepository;

    public List<String> hosts(String token){

        ArrayList arrayList = new ArrayList();
        arrayList.add("1/1");
        arrayList.add("1/2");
        arrayList.add("1/3");

        //arrayList.add(mapCashRepository.findById(token));
        MapCash mapCash = new MapCash();
        mapCash.setToken("132t");
        mapCash.setHost(arrayList);
        mapCashRepository.save(mapCash);
        return mapCashRepository.findById(token).get().getHost();


        //UUID.randomUUID();
    }

}
