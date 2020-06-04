package com.stone.dao;

import com.stone.po.Tag;
import com.stone.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}
