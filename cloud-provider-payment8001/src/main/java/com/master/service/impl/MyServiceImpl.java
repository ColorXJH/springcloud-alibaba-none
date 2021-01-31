package com.master.service.impl;

import com.master.dao.QueryDao;
import com.master.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/11/18 17:08
 */
@Service
public class MyServiceImpl  implements MyService {
    @Resource
    private QueryDao queryDao;

    @Override
    public List<Map> querySomeThing(String id) {
        return queryDao.querySomeThing(id);
    }
}
