package com.man.girl.controller;

import com.man.girl.aspect.GirlAspect;
import com.man.girl.domain.Girl;
import com.man.girl.dao.GirlRepository;
import com.man.girl.service.GirlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlAspect.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlServiceImpl girlService;

    /**
     * 查询所有女生
     */
    @GetMapping(value = "/girls")
    public List<Girl> showGirls() {
        List<Girl> girls = girlRepository.findAll();
        logger.info("girls={}",girls);
        return girls;
    }

    /**
     * 添加女生
     */
    @PostMapping(value = "/girls")
    public Girl addGirl(@Valid Girl girl,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    /**
     * 根据id查询女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl selectOneGirl(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /**
     * 根据id更新女生
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable Integer id, @RequestParam String name, @RequestParam String cupSize) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 根据id删除女生
     */
    @DeleteMapping(value = "/girls/{id}")
    public String delGirl(@PathVariable Integer id) {
        girlRepository.deleteById(id);
        return "SUCCESS";
    }

    /**
     * 根据年龄查询女生
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 同时插入两个女生数据(测试事务)
     */
    @GetMapping(value = "/girlss")
    public void saveTwoGirls() {
        girlService.saveTwoGirls();
    }
}
