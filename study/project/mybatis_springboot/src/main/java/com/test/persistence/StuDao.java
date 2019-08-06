package com.test.persistence;


import org.apache.ibatis.annotations.Mapper;

import com.test.model.Stu;

@Mapper
public interface StuDao {

	public void addStu(Stu stu);
}
