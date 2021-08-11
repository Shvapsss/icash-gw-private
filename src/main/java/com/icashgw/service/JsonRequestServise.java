package com.icashgw.service;

import com.icashgw.repo.JsonReqestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonRequestServise {
    @Autowired
    private JsonReqestRepository jsonReqestRepository;
}
