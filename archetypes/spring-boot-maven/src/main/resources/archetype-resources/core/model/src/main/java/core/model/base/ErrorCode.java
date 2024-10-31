#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core.model.base;

import lombok.Getter;

@Getter
public enum ErrorCode {
    InvalidRequest(1, "invalid request"), GenericRuntimeExceptionError(998,
                                                                       "generic runtime exception"), GenericExceptionError(
                                                                                                                           999,
                                                                                                                           "generic exception");

    private final int    code;
    private final String msg;

    private ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
