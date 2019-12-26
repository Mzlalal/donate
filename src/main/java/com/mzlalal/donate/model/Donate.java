package com.mzlalal.donate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 捐献金额实体类
 * @author: Mzlalal
 * @date: 2019/12/26 16:52
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
public class Donate implements Serializable {

    private static final long serialVersionUID = 1265919726316100396L;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空! 您输入的将进入爱心人士名单留在爱心墙上!")
    @Length(min = 2, max = 15, message = "姓名长度必须在2-15之间")
    private String name;
    /**
     * 捐献账户金额
     */
    @Min(value = 0, message = "捐献金额不能为负数!")
    private BigDecimal moneyAmount;
}
