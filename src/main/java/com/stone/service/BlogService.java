package com.stone.service;

import com.stone.po.Blog;
import com.stone.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

        Blog getBlog(Long id);

        Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

        Blog saveBlog(Blog blog);

        Blog updateBlog(Long id, Blog blog);

        void deleteBlog(Long id);

}
