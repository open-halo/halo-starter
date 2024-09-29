package org.example.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.persistent.entity.Tables;
import org.example.persistent.entity.User;



public interface UserJRepository extends JRepository<User, String>, Tables {

}
