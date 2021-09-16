package com.icashgw.repo;

import com.icashgw.entity.JsonRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JsonReqestRepository extends CrudRepository<JsonRequest,String> {
    Optional<JsonRequest> findById(String str);
}
