package com.teligen.licserver.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.teligen.licserver.license.LicenseCreator;
import com.teligen.licserver.license.LicenseCreatorParam;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Tianzy
 */
@RestController
@RequestMapping("/license")
@Api(tags = "生成证书")
public class LicenseCreatorController {

    @Autowired
    private LicenseCreatorParam param;

    @PostMapping(value = "/generateLicense")
    public Map<String,Object> generateLicense(@RequestBody(required = true)LicenseCreatorParam sourceParam) {
        Map<String,Object> resultMap = new HashMap<>(2);
        BeanUtil.copyProperties(sourceParam, param,
                true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        LicenseCreator licenseCreator = new LicenseCreator(param);
        boolean result = licenseCreator.generateLicense();

        if(result){
            resultMap.put("result","ok");
            resultMap.put("msg",param);
        }else{
            resultMap.put("result","error");
            resultMap.put("msg","证书文件生成失败！");
        }

        return resultMap;
    }
}
