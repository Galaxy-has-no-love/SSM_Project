package com.byh.biyesheji.service.impl;

import com.byh.biyesheji.dao.CategoryMapper;
import com.byh.biyesheji.pojo.Category;
import com.byh.biyesheji.service.ProductService;
import com.byh.biyesheji.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 22743
 */

//业务处理类  controller类调用它
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductService productService;

    @Override
    public List<Category> list() {
        List<Category> categoryList = categoryMapper.selectByExample(null);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }
//文件要放在web-inf下面才会被控制器controller控制,
    @Override
    public void del(int id) {
        boolean cunzai = productService.findProByCid(id);
        if(!cunzai){
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }


}
