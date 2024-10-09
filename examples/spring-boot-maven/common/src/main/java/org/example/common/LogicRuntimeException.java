package org.example.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicRuntimeException extends RuntimeException {
    private int errCode;
    private String errMsg;

    public LogicRuntimeException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public <T> ApiResult<T> intoApiResult(Class<T> tClass) {
        return ApiResult.ofFailure(this.errCode, this.errMsg);
    }
}
