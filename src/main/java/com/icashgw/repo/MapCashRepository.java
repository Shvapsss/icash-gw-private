package com.icashgw.repo;

import com.icashgw.entity.MapCashBox;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapCashRepository extends CrudRepository<MapCashBox,String> {
    List<MapCashBox> findByToken(String str);
}
