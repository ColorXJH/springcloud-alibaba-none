package com.master.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/21 11:21
 */
public class CustomerBlockHandler {

    public static String handlerException1(BlockException exception){
        return "客户自定义exception1--------";
    }

    public static String handlerException2(BlockException exception){
        return "客户自定义exception2--------";
    }

}
