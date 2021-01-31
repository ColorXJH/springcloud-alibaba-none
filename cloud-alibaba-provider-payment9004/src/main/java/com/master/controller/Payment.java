package com.master.controller;

import lombok.Data;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:16
 */
@Data
public class Payment {
    private String name;
    private int age;

    public Payment(String name, int age){
        this.name=name;
        this.age=age;
    }
}
