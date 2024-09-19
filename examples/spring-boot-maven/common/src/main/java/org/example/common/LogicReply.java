package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LogicReply<T> {

    boolean success;
    T data;
    int errCode;
    String errMsg;

    // 因为经常需要写 !response.isSuccess()
    // 而这个写法是比较容易混淆！符号，漏掉是常有的事情，isFailure语义更加明确
    public boolean isFailure() {
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

    public <N> LogicReply<N> intoFailure() {
        return LogicReply.ofFailure(errCode, errMsg);
    }

    public static <T> LogicReply<T> ofSuccess() {
        return new LogicReply<>(true, null, 0, null);
    }

    // 为什么不考虑Optional<T>，因为Java默认是一个nullable的语言
    // 所以其实等价于所有对象都是一个Optional<T>
    public static <T> LogicReply<T> ofSuccess(T data) {
        return new LogicReply<>(true, data, 0, null);
    }

    public static <T> LogicReply<List<T>> ofSuccessList(List<T> data) {
        return new LogicReply<>(true, data, 0, null);
    }

    public static <T> LogicReply<T> ofFailure(int errCode, String errMsg) {
        return new LogicReply<>(false, null, errCode, errMsg);
    }

    public static <T> LogicReply<T> ofEmptyEntity() {
        return new LogicReply<>(false, null, 1, "entity not found");
    }

    public static <T> LogicReply<PagedList<T>> ofEmptyList() {
        return new LogicReply<PagedList<T>>(false, null, 1, "entity not found");
    }

}

