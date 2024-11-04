#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infra.persistent.gateway;

import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ${package}.core.model.base.ApiResult;
import ${package}.core.model.base.PagedResult;
import ${package}.core.model.base.PagedRequest;
import ${package}.core.gateway.repository.IUserRepository;
import ${package}.infra.persistent.entity.Users;
import ${package}.infra.persistent.repository.UserJRepository;
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
        Users domainToEntity(${package}.core.model.User user);
        ${package}.core.model.User entityToModel(Users userEntity);
        default Optional<${package}.core.model.User> optionalEntityToModel(Optional<Users> userEntity) {
            if (userEntity.isEmpty()) {
                return Optional.empty();
            } else {
                ${package}.core.model.User user = entityToModel(userEntity.get());
                return Optional.of(user);
            }
        }

        List<${package}.core.model.User> entitiesToDomains(List<Users> userList);
    }

    @Override
    public ApiResult<Void> create(${package}.core.model.User user) {
        return null;
    }

    @Override
    public ApiResult<Void> delete(long userId) {
        return null;
    }

    @Override
    public ApiResult<Void> update(${package}.core.model.User user) {
        return null;
    }

    @Override
    public ApiResult<${package}.core.model.User> select(long userId) {
        log.info("select({})", userId);
        Optional<Users> userEntity = userJRepository.findById(userId);
        Optional<${package}.core.model.User> userModelOpt = UserRepositoryMapper.INSTANCE.optionalEntityToModel(userEntity);
        return ApiResult.ofOptional(userModelOpt);
    }

    @Override
    public ApiResult<${package}.core.model.User> selectByEmail(String email) {
        return null;
    }

    @Override
    public ApiResult<PagedResult<${package}.core.model.User>> searchByName(PagedRequest<String> searchByNameRequest) {
        return null;
    }


    public ApiResult<Void> save(${package}.core.model.User user) {
        Users userEntity = UserRepositoryMapper.INSTANCE.domainToEntity(user);
        userJRepository.save(userEntity);
        return ApiResult.ofSuccess();
    }


    public ApiResult<List<${package}.core.model.User>> findAllUsers() {
        List<Users> userList = userJRepository.findAll();
        List<${package}.core.model.User> domains = UserRepositoryMapper.INSTANCE.entitiesToDomains(userList);
        return ApiResult.ofSuccessList(domains);
    }
}
