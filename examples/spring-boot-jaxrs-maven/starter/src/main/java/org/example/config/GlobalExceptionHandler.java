package org.example.config;

import jakarta.validation.ConstraintViolationException;
import org.example.core.model.base.ApiResult;
import org.example.core.model.base.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import cn.hutool.json.JSONUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApiResult<Void> onConstraintValidationException(ConstraintViolationException e) {
        String violationsContent = JSONUtil.toJsonStr(e.getConstraintViolations());
        return ApiResult.ofFailure(ErrorCode.InvalidRequest.getCode(), violationsContent);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApiResult<Void> genericRuntimeExceptionHandler(Exception e) {
        return ApiResult.ofFailure(ErrorCode.InvalidRequest.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ApiResult<Void> genericExceptionHandler(Exception e) {
        return ApiResult.ofFailure(ErrorCode.InvalidRequest.getCode(), e.getMessage());
    }
}
