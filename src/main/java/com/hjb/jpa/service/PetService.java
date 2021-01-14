package com.hjb.jpa.service;

import com.hjb.jpa.base.ResponseEntity;

public interface PetService {
    /**
     * 查询所有 pets
     * @return
     */
    ResponseEntity findAllPets();

    /**
     * 根据color查询 pets
     * @param color pet color
     * @return response entity
     */
    ResponseEntity findByColor(String color);

    /**
     * 根据pname和color查询pets
     * @param pname pet name
     * @param color pet color
     * @return response entity
     */
    ResponseEntity findByPnameAndAndColor(String pname, String color);

    /**
     * 根据minId和maxId查询pets
     * @param minId min id
     * @param maxId max id
     * @return response entity
     */
    ResponseEntity findByIdBetweenOrderById(Integer minId, Integer maxId);
}
