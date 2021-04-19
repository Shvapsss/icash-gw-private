package com.icashgw.icashgw.service;

import com.icashgw.icashgw.entity.MapCashBox;
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

//
        ArrayList arrayList = new ArrayList();
        arrayList.add("1/1");
        arrayList.add("1/2");
        arrayList.add("1/3");

        //arrayList.add(mapCashRepository.findById(token));
        MapCashBox mapCashBox = new MapCashBox();
        mapCashBox.setToken("132t");
        mapCashBox.setHost(arrayList);
        mapCashRepository.save(mapCashBox);

        //UUID.randomUUID();
        return mapCashRepository.findById(token).get().getHost();

    }

}
