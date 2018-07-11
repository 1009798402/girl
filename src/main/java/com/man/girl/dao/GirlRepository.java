package com.man.girl.dao;

import com.man.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * GirlRepository 对数据库增删改查
 *
 * @author keriezhang
 * @date 2016/10/31
 */

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过年龄查询Girls
     *
     * @param age Girl age
     * @return List<Girl>
     */
    List<Girl> findByAge(Integer age);
}
