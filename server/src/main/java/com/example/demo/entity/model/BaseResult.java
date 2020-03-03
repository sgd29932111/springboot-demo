package com.example.demo.entity.model;

import lombok.Data;

@Data
public class BaseResult<T> {
    private String message;
    private boolean success;
    private T data;

    public BaseResult() {
    }

    public BaseResult(String message, boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public void construct(String message, boolean success, T data){
        this.message = message;
        this.success = success;
        this.data = data;
    }
    public void construct(String message, boolean success){
        this.message = message;
        this.success = success;
    }

}
