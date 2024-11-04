package org.example.infra.persistent.gateway;

import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.model.base.ApiResult;
import org.example.core.model.base.PagedResult;
import org.example.core.model.base.PagedRequest;
import org.example.core.gateway.repository.IUserRepository;
import org.example.infra.persistent.entity.Users;
import org.example.infra.persistent.repository.UserJRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;
import java.util.Optional;

@Slf4j
@Named
@AllArgsConstructor
public class UserRepository implements IUserRepository {

    private UserJRepository userJRepository;

    @Mapper
    interface UserRepositoryMapper {
        UserRepositoryMapper INSTANCE = Mappers.getMapper(UserRepositoryMapper.class);
        Users domainToEntity(org.example.core.model.User user);
        org.example.core.model.User entityToModel(Users userEntity);
        default Optional<org.example.core.model.User> optionalEntityToModel(Optional<Users> userEntity) {
            if (userEntity.isEmpty()) {
                return Optional.empty();
            } else {
                org.example.core.model.User user = entityToModel(userEntity.get());
                return Optional.of(user);
            }
        }

        List<org.example.core.model.User> entitiesToDomains(List<Users> userList);
    }

    @Override
    public ApiResult<Void> create(org.example.core.model.User user) {
        return null;
    }

    @Override
    public ApiResult<Void> delete(long userId) {
        return null;
    }

    @Override
    public ApiResult<Void> update(org.example.core.model.User user) {
        return null;
    }

    @Override
    public ApiResult<org.example.core.model.User> select(long userId) {
        log.info("select({})", userId);
        Optional<Users> userEntity = userJRepository.findById(userId);
        Optional<org.example.core.model.User> userModelOpt = UserRepositoryMapper.INSTANCE.optionalEntityToModel(userEntity);
        return ApiResult.ofOptional(userModelOpt);
    }

    @Override
    public ApiResult<org.example.core.model.User> selectByEmail(String email) {
        return null;
    }

    @Override
    public ApiResult<PagedResult<org.example.core.model.User>> searchByName(PagedRequest<String> searchByNameRequest) {
        return null;
    }


    public ApiResult<Void> save(org.example.core.model.User user) {
        Users userEntity = UserRepositoryMapper.INSTANCE.domainToEntity(user);
        userJRepository.save(userEntity);
        return ApiResult.ofSuccess();
    }


    public ApiResult<List<org.example.core.model.User>> findAllUsers() {
        List<Users> userList = userJRepository.findAll();
        List<org.example.core.model.User> domains = UserRepositoryMapper.INSTANCE.entitiesToDomains(userList);
        return ApiResult.ofSuccessList(domains);
    }
}
