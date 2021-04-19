package com.icashgw.icashgw.repo;

import com.icashgw.icashgw.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    public User findByUsername(String username);
}
