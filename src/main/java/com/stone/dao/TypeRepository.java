package com.stone.dao;

import com.stone.po.Type;
import com.stone.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
