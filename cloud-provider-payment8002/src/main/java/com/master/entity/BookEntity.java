package com.master.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/18 16:09
 */
@Data
public class BookEntity {
    private int id;
    private String name;
    private String cover;
    private String author;
    private BigDecimal price;
    private int is_delete;
}
