package com.sun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: SunQi
 * @Descriptions: SpringCloud:com.sun.springboot.entities
 * @Data: Created in 9:45 2021/5/24
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
