package com.hjb.jpa.dao;

import com.hjb.jpa.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserDao extends JpaRepository<UserPojo, Long> {



    @Query(nativeQuery = true, value = "select * from t_user where user_name = :userName")
    UserPojo findByUserName(String userName);

    @Query(nativeQuery = true, value = "select * from t_user where user_name = :userName and password = :password")
    UserPojo findByUserNameAndPassword(String userName, String password);

    @Query(nativeQuery = true, value = "select a.user_id, b.role_name, b.role_sign from user_role a left join t_role b on a.role_id = b.role_id where a.user_id = ?1")
    List<Map> selectUserRole(long userId);
}
