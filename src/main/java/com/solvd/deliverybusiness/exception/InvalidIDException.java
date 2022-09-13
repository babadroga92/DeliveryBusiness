package com.solvd.deliverybusiness.exception;

public class InvalidIDException extends Exception{
    private String msg;

    public InvalidIDException(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
