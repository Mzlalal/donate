package com.mzlalal.donate.model.QRCode;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 二维码实体类
 * @author: Mzlalal
 * @date: 2019/12/26 17:10
 * @version: 1.0
 */
@Data
@Builder
public class QRCode implements Serializable {

    private static final long serialVersionUID = -7338692408222483605L;
    /**
     * 基础二维码 base64位编码
     */
    private String baseImage;

    /**
     * token : 标识是否过期
     */
    private String token;
}
