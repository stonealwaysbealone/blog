package com.stone.service;

import com.stone.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByname(String name);

    Page<Type> typeList(Pageable pageable);

    List<Type> typeList();

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
