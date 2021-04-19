package com.icashgw.icashgw;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    public User findByUsername(String username);
}
