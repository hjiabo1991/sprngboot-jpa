package com.hjb.jpa.dao;

import com.hjb.jpa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 增删改查
 * JpaRepository<T, Integer> 提供了基本的常用操作
 * T:指定具体的操作类
 * ID: 实体类中带有@ID属性的字段类型
 */
public interface PetDao extends JpaRepository<Pet, Integer> {

    // 自定义查询(当JpaRepository提供的默认方法不满足时自定义)

    /**
     * 方法命名规范：findBy开头,后面跟一个属性名
     */
    /**
     * 根据名称查
     * @param pName
     * @return
     */
    List<Pet> findByPname(String pName);

    /**
     * 根据颜色差
     * @param color
     * @return
     */
    List<Pet> findByColor(String color);

    /**
     * 根据pname和color联合查询
     * @param pname
     * @param color
     * @return
     */
    List<Pet> findByPnameAndAndColor(String pname, String color);

    List<Pet> findByIdBetweenOrderById(Integer minId, Integer maxId);

    /**
     * JPQL查询: 操作java实体类对象,所以sql中的字段应该用实体类属性
     * ps:不能出现表名，不能出现select *
     * select attribute1,... from entityTypeName
     */
    List<Pet> findAll();

    /**
     * 查询一列
     */
    @Query(nativeQuery = true, value = "select pname from t_pet")
    List<Object[]> getPname();

}
