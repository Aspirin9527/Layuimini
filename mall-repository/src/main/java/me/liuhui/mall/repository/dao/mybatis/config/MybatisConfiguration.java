package me.liuhui.mall.repository.dao.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2018/7/13 16:54
 * <p>
 * Description: []
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Configuration
@PropertySource("classpath:/application-dao.properties")
@MapperScan("me.liuhui.mall.repository.dao")
public class MybatisConfiguration {
}
