package com.byh.biyesheji.dao;

import com.byh.biyesheji.pojo.Category;
import com.byh.biyesheji.pojo.CategoryExample;

import java.util.List;
//interface接口  extends继承：  子类CategoryMapper继承父类CrudDao<Category>
public interface CategoryMapper extends CrudDao<Category>{

     List<Category> selectByExample(CategoryExample example);

}