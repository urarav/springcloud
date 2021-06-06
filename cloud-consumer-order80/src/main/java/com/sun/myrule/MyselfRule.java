package com.sun.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.myrule
 * @Data: Created in 0:45 2021/5/31
 * @Modified By:
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
