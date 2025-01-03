package com.ess.expenses.core.resp;

public class ApiResponse {


    //private boolean success;
    private String message;
    private Object data;

    public ApiResponse( String message, Object data) {
       // this.success = success;(boolean success
        this.message = message;
        this.data = data;
    }

}
