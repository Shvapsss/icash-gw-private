package com.icashgw.service;

import com.icashgw.entity.HostCash;
import com.icashgw.entity.MapCashBox;
import com.icashgw.repo.MapCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenRoutingServise {
    @Autowired
    private MapCashRepository mapCashRepository;

    public List<HostCash> hosts(String token){
        return mapCashRepository.findByToken(token).getHost();
    }

}
