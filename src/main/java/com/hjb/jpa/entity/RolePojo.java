package com.hjb.jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class RolePojo {

    // 角色编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    // 角色名
    @Column(name = "role_name")
    private String roleName;
    // 角色标志,1:管理员2:审批员3:用户
    @Column(name = "role_sign")
    private String roleSign;
    // 创建时间
    @Column(name = "create_time")
    private String createTime;
    // 更新时间
    @Column(name = "update_time")
    private String updateTime;
    // 创建用户编号
    @Column(name = "create_user_id")
    private Long createUserId;
    // 更新用户编号
    @Column(name = "update_user_id")
    private Long updateUserId;

}
