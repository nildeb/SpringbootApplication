package com.springboot.application.springbootApp.response;

import java.util.List;

public class Response <T>{

    private T result;
    private List<T> results;


    public T getResult(){ return result;}

    public void setResult(T result){
        this.result =result;
    }
    public List<T> getResults(){ return results;}

    public void setResult(List<T> result){
        this.results =results;
    }

}
