package com.man.girl.properties;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Author: jc
 * @Date: 2018/6/28/028 16:39
 * @Description:
 */
@Component
@NoArgsConstructor
@ConfigurationProperties(prefix = "girl")
public class GirlPropertie {

    private String name;

    private Integer age;

    private String cupSize;
}
