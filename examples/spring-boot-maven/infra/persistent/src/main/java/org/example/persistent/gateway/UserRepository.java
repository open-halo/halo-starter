package org.example.persistent.gateway;

import org.example.common.LogicReply;
import org.example.core.domian.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.persistent.repository.UserJRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private UserJRepository jRepository;

    @Mapper
    interface UserRepositoryMapper {
        UserRepositoryMapper INSTANCE = Mappers.getMapper(UserRepositoryMapper.class);
        org.example.persistent.entity.User domainToEntity(User user);
        User entityToDomain(org.example.persistent.entity.User userEntity);

        List<User> entitiesToDomains(List<org.example.persistent.entity.User> userList);
    }

    @Override
    public LogicReply<Void> save(User user) {
        org.example.persistent.entity.User userEntity = UserRepositoryMapper.INSTANCE.domainToEntity(user);
        jRepository.save(userEntity);
        return LogicReply.ofSuccess();
    }

    @Override
    public LogicReply<List<User>> findAllUsers() {
        List<org.example.persistent.entity.User> userList = jRepository.findAll();
        List<User> domains = UserRepositoryMapper.INSTANCE.entitiesToDomains(userList);
        return LogicReply.ofSuccessList(domains);
    }
}
