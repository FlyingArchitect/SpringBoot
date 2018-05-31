package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
/*jpa使用接口*/
import com.springboot.bean.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
