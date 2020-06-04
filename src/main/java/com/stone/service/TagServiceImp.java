package com.stone.service;

import com.stone.NotFoundException;
import com.stone.dao.TagRepository;
import com.stone.po.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagRepository tagRepository;


    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        Tag tag = tagRepository.getOne(id);
        if (tag == null) {
            throw new NotFoundException("该类型不存在");
        }
        return tag;
    }

    @Override
    public Tag getTagByname(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    @Transactional
    public Page<Tag> tagList(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.getOne(id);
        if (t == null) {
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        Tag tag = tagRepository.getOne(id);
        tagRepository.delete(tag);
    }
}
