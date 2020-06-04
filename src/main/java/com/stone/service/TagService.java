package com.stone.service;

import com.stone.po.Tag;
import com.stone.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByname(String name);

    Page<Tag> tagList(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
