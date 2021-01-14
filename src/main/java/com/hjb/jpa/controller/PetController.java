package com.hjb.jpa.controller;

import com.hjb.jpa.base.ResponseEntity;
import com.hjb.jpa.service.PetService;
import com.hjb.jpa.tools.BeanHelperUtils;
import com.hjb.jpa.tools.ResponseState;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PetController {

    @Resource
    private PetService petService;

    /**
     * 查询所有pets
     * @return response entity
     */
    @RequestMapping(value = "query/allPets", method = RequestMethod.GET)
    public ResponseEntity findAllPets() {
        return petService.findAllPets();
    }

    /**
     * 根据color 查询 pets
     * @param color pet颜色
     * @return response entity
     */
    @GetMapping(value = "query/petColor")
    public ResponseEntity findPetsByColor(@Param(value = "color") String color) {
        if (BeanHelperUtils.isNullOrEmpty(color)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "请传递参数: color");
        }
        return petService.findByColor(color);
    }

    /**
     * 根据pname和color查询pets
     * @param pname pet name
     * @param color pet color
     * @return response entity
     */
    @RequestMapping(value = "query/findByPnameAndAndColor", method = RequestMethod.POST)
    public ResponseEntity findByPnameAndAndColor(@Param(value = "pname") String pname, @Param(value = "color") String color) {
        if (BeanHelperUtils.isNullOrEmpty(pname)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "请传递参数:pname");
        }
        if (BeanHelperUtils.isNullOrEmpty(color)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "请传递参数:color");
        }
        return petService.findByPnameAndAndColor(pname, color);
    }

    /**
     * 根据id范围查询pets
     * @param minId min id
     * @param maxId max id
     * @return response entity
     */
    @RequestMapping(value = "query/findByIdBetweenOrderById", method = RequestMethod.GET)
    public ResponseEntity findByIdBetweenOrderById(@Param(value = "minId") Integer minId, @Param(value = "maxId") Integer maxId) {
        if (BeanHelperUtils.isNullOrEmpty(minId)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "请传入参数:minId");
        }
        if (BeanHelperUtils.isNullOrEmpty(maxId)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "请传入参数maxId");
        }
        if (!BeanHelperUtils.isSmall(minId, maxId)) {
            return new ResponseEntity(ResponseState.PARAM_ERROR, "minId 不能大于 maxId");
        }
        return petService.findByIdBetweenOrderById(minId, maxId);
    }
}
