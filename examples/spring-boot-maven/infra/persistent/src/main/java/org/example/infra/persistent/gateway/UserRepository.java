package org.example.infra.persistent.gateway;

import lombok.AllArgsConstructor;
import org.example.common.ApiResult;
import org.example.common.PagedResult;
import org.example.common.PagedRequest;
import org.example.core.model.User;
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
    public ApiResult<Void> create(User user) {
        return null;
    }

    @Override
    public ApiResult<Void> delete(long userId) {
        return null;
    }

    @Override
    public ApiResult<Void> update(User user) {
        return null;
    }

    @Override
    public ApiResult<User> select(long userId) {
        return null;
    }

    @Override
    public ApiResult<User> selectByEmail(String email) {
        return null;
    }

    @Override
    public ApiResult<PagedResult<User>> searchByName(PagedRequest<String> searchByNameRequest) {
        return null;
    }


    public ApiResult<Void> save(User user) {
        org.example.infra.persistent.entity.User userEntity = UserRepositoryMapper.INSTANCE.domainToEntity(user);
        jRepository.save(userEntity);
        return ApiResult.ofSuccess();
    }


    public ApiResult<List<User>> findAllUsers() {
        List<org.example.infra.persistent.entity.User> userList = jRepository.findAll();
        List<User> domains = UserRepositoryMapper.INSTANCE.entitiesToDomains(userList);
        return ApiResult.ofSuccessList(domains);
    }
}
