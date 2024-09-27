#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common;

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

    public <T> LogicReply<T> intoLogicReply(Class<T> tClass) {
        return LogicReply.ofFailure(this.errCode, this.errMsg);
    }
}
