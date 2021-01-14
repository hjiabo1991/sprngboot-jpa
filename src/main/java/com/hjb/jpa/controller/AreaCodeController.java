package com.hjb.jpa.controller;

import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.service.AreaCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class AreaCodeController {

    @Resource
    private AreaCodeService areaCodeService;

    @RequestMapping(value = "address/getAllBirthPlace", method = RequestMethod.GET)
    public ResponseEntity getAllAreaCode() {
        return areaCodeService.getAllAreaCode();
    }
}
