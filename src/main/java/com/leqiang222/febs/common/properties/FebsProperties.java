package com.leqiang222.febs.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LeQiang Li
 * @Date Created in 10:08 2019/7/8
 * @Description:
 * @Modified By:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "febs")
public class FebsProperties {
    private ShiroProperties shiro = new ShiroProperties();

    private boolean openAopLog = true;
}
