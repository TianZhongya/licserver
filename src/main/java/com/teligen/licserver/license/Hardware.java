package com.teligen.licserver.license;

import lombok.Data;

import java.util.List;

/**
 * @author: Tianzy
 */
@Data
public class Hardware {
    /**
     * 可被允许的IP地址
     */
    private List<String> ipAddress;

    /**
     * 可被允许的MAC地址
     */
    private List<String> macAddress;

    /**
     * 可被允许的CPU序列号
     */
    private String cpuSerial;

    /**
     * 可被允许的主板序列号
     */
    private String mainBoardSerial;
}
