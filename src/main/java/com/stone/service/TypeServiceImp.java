package com.stone.service;

import com.stone.NotFoundException;
import com.stone.dao.TypeRepository;
import com.stone.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImp implements TypeService {
    @Autowired
    private TypeRepository typeRepository;


    @Override
    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Type getType(Long id) {
        Type Type = typeRepository.getOne(id);
        if (Type == null) {
            throw new NotFoundException("该类型不存在");
        }
        return Type;
    }

    @Override
    public Type getTypeByname(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    @Transactional
    public Page<Type> typeList(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> typeList() {
        return typeRepository.findAll();
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);
        if (t == null) {
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        Type type = typeRepository.getOne(id);
        typeRepository.delete(type);
    }
}
