package org.example.core.model.base;

public enum CommonError {
    Success(0, ""), EntityNotFound(400001, "entity not found");

    private final int    code;
    private final String msg;

    CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
