package com.master.dao;

import com.master.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2021/1/31 2:24
 */
@Mapper
public interface OrderDao {
    void create (Order order);
    void  update (@Param("userId")Long userId, @Param("status") Integer status);
}
