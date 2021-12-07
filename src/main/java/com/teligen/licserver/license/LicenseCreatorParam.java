package com.teligen.licserver.license;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Tianzy
 */
@Data
@Component
public class LicenseCreatorParam {
    /**
     * 项目的唯一识别码
     */
    private String subject;

    /**
     * 密钥别称
     */
    @Value("${license.privateAlias}")
    private String privateAlias;

    /**
     * 生成密钥对的密码
     */
    @Value("${license.keyPwd}")
    private String keyPwd;

    /**
     * 访问密钥库的密码
     */
    @Value("${license.storePwd}")
    private String storePwd;

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    @Value("${license.privateKeysStorePath}")
    private String privateKeysStorePath;

    /**
     * 证书生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date issuedTime = new Date();

    /**
     * 证书失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiryTime;

    /**
     * 用户类型
     */
    @Value("${license.consumerType}")
    private String consumerType;

    /**
     * 用户数量
     */
    @Value("${license.consumerAmount}")
    private Integer consumerAmount;

    /**
     * 描述信息
     */
    private String description = "";

    /**
     * 额外的服务器硬件校验信息
     */
    private Hardware hardware;
}
