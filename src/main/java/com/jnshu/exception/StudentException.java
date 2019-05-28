package com.jnshu.exception;
//学生异常信息
public class StudentException extends Exception {

    private String message;

    public StudentException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
