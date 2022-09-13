package com.solvd.deliverybusiness.exception;

public class DatabaseException extends Exception {
    private String msg;

    public DatabaseException(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
