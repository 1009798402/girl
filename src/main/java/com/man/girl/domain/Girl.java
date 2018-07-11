package com.man.girl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @Author: jc
 * @Date: 2018/6/28/028 17:50
 * @Description:
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 18, message = "未成年少女")
    private Integer age;

    private String cupSize;

}
