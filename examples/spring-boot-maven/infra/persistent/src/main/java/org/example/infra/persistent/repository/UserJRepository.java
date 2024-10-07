package org.example.infra.persistent.repository;

import org.babyfish.jimmer.spring.repository.JRepository;
import org.example.infra.persistent.entity.User;
import org.example.infra.persistent.entity.Tables;


public interface UserJRepository extends JRepository<User, String>, Tables {

}
