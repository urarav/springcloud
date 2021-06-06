package com.sun.springcloud.mapper;

import com.sun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot.mapper
 * @Data: Created in 9:50 2021/5/24
 * @Modified By:
 */
@Mapper
public interface PaymentMapper {
    public abstract Payment queryByID(@Param("id") Long id);
    public int create(Payment payment);
}
