package com.mzlalal.donate.controller;

import com.mzlalal.donate.model.Donate;
import com.mzlalal.donate.model.QRCode.QRCode;
import com.mzlalal.donate.utils.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/12/26 16:54
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/QRCode")
public class DonateController {

    @Value("${qrCode.callback.url}")
    private String callbackUrl;

    /**
     * 生成捐款图片二维码
     * @param donate 姓名 金额
     * @return
     */
    @RequestMapping("/scan/generateDonate")
    public QRCode generateDonateQRCode(@Valid Donate donate) {
        // 生成请求ID
        String token = UUID.randomUUID().toString();

        return QRCode.builder()
                .baseImage(QrCodeUtil.toBase64(callbackUrl + "?token=" + token, 300, 300))
                .token(token)
                .build();
    }
}
