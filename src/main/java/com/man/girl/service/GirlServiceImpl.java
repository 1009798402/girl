package com.man.girl.service;

import com.man.girl.domain.Girl;
import com.man.girl.dao.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Girl的事务控制注解演示
 *
 * @author c
 * @date 2016/10/31
 */
@Service
public class GirlServiceImpl {

    @Autowired
    private GirlRepository girlRepository;

    public void saveTwoGirls(){
        Girl girl = new Girl();
        girl.setId(33);
        girl.setName("小花");
        girl.setCupSize("C");
        girl.setAge(17);
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setId(44);
        girl2.setName("小白");
        girl2.setCupSize("B");
        girl2.setAge(18);
        girlRepository.save(girl2);
    }
}
