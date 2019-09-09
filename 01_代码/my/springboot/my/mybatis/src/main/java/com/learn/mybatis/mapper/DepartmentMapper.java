package com.learn.mybatis.mapper;

import com.learn.mybatis.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentname = #{departmentName} where id = #{id}")
    int updateDept(Department department);

    @Delete("delete from department where id = #{id}")
    int deletDept(Integer id);


}
