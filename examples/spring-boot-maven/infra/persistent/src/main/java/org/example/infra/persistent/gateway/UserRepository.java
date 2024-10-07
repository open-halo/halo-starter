package org.example.infra.persistent.gateway;

import lombok.AllArgsConstructor;
import org.example.common.LogicReply;
import org.example.common.PagedReply;
import org.example.common.PagedRequest;
import org.example.core.domian.User;
import org.example.core.gateway.repository.IUserRepository;
import org.example.infra.persistent.repository.UserJRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository {

    private UserJRepository jRepository;

    @Mapper
    interface UserRepositoryMapper {
        UserRepositoryMapper INSTANCE = Mappers.getMapper(UserRepositoryMapper.class);
        org.example.infra.persistent.entity.User domainToEntity(User user);
        User entityToDomain(org.example.infra.persistent.entity.User userEntity);

        List<User> entitiesToDomains(List<org.example.infra.persistent.entity.User> userList);
    }

    @Override
    public LogicReply<Void> create(User user) {
        return null;
    }

    @Override
    public LogicReply<Void> delete(long userId) {
        return null;
    }

    @Override
    public LogicReply<Void> update(User user) {
        return null;
    }

    @Override
    public LogicReply<User> select(long userId) {
        return null;
    }

    @Override
    public LogicReply<User> selectOne(String email) {
        return null;
    }

    @Override
    public LogicReply<PagedReply<User>> searchByName(PagedRequest<String> searchByNameRequest) {
        return null;
    }


    public LogicReply<Void> save(User user) {
        org.example.infra.persistent.entity.User userEntity = UserRepositoryMapper.INSTANCE.domainToEntity(user);
        jRepository.save(userEntity);
        return LogicReply.ofSuccess();
    }


    public LogicReply<List<User>> findAllUsers() {
        List<org.example.infra.persistent.entity.User> userList = jRepository.findAll();
        List<User> domains = UserRepositoryMapper.INSTANCE.entitiesToDomains(userList);
        return LogicReply.ofSuccessList(domains);
    }
}
