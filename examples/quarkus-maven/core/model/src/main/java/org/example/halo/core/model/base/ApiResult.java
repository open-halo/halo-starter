package org.example.halo.core.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

import static org.example.halo.core.model.base.CommonError.EntityNotFound;
import static org.example.halo.core.model.base.CommonError.Success;

@Data
@AllArgsConstructor
public class ApiResult<T> {

    boolean success;
    T       data;
    int     errCode;
    String  errMsg;

    // 因为经常需要写 !response.isSuccess()
    // 而这个写法是比较容易混淆！符号，漏掉是常有的事情，failure语义更加明确
    // 如果用isFailure，会导致序列化的时候多一个字段
    public boolean failure() {
        return !success;
    }

    public void expectSuccess() throws LogicRuntimeException {
        if (!success) {
            throw new LogicRuntimeException(errCode, errMsg);
        }
    }

    public T unwrap() throws LogicRuntimeException {
        if (success) {
            return data;
        } else {
            throw new LogicRuntimeException(errCode, errMsg);
        }
    }

    public <N> ApiResult<N> intoFailure() {
        return ApiResult.ofFailure(errCode, errMsg);
    }

    public static <T> ApiResult<T> ofSuccess() {
        return new ApiResult<>(true, null, 0, null);
    }

    // 为什么不考虑Optional<T>，因为Java默认是一个nullable的语言
    // 所以其实等价于所有对象都是一个Optional<T>
    public static <T> ApiResult<T> ofSuccess(T data) {
        return new ApiResult<>(true, data, 0, null);
    }

    public static <T> ApiResult<List<T>> ofSuccessList(List<T> data) {
        return new ApiResult<>(true, data, 0, null);
    }

    public static <T> ApiResult<T> ofFailure(int errCode, String errMsg) {
        return new ApiResult<>(false, null, errCode, errMsg);
    }

    public static <T> ApiResult<T> ofOptional(Optional<T> data) {
        return data.map(t -> new ApiResult<>(true, t, Success.code(), Success.msg()))
                .orElseGet(() -> new ApiResult<>(false, null, EntityNotFound.code(), EntityNotFound.msg()));
    }

    public static <T> ApiResult<T> ofEmptyEntity() {
        return new ApiResult<>(false, null, 1, "entity not found");
    }

    public static <T> ApiResult<PagedResult<T>> ofEmptyList() {
        return new ApiResult<PagedResult<T>>(false, null, 1, "entity not found");
    }

}
