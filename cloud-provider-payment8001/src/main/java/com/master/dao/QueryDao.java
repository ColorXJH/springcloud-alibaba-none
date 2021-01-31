package com.master.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/18 16:05
 */
public interface QueryDao {
    /**
     * @description:
     * @method: querySomeThing
     * @param: [id]
     * @return: java.util.List<java.util.Map>
     * @author: ColorXJH
     * @date: 2020/11/18 16:06
     */
    public List<Map> querySomeThing(String id);
}
