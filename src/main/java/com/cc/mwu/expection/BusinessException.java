package com.cc.mwu.expection;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}