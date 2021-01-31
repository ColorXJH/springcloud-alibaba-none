package com.master.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/28 10:54
 */
@Data
@ToString
public class Payment {
    private String name;
    private int age;
    public Payment(){};
    public Payment (String name,int age){
        this.name=name;
        this.age=age;
    }

}
