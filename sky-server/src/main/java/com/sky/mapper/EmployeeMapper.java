package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     *
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入新员工
     *
     * @param employee
     */
    @Insert("insert into employee(name, username, password, phone, sex, id_number, status, create_time, update_time, create_user, update_user)" +
            "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);


    /**
     * 通过名字分页查询用户
     *
     * @param name
     * @return
     */
    Page<Employee> pageQuery(String name);


    /**
     * 根据用户查询是否禁言
     *
     * @param employee
     * @return
     */
    void update(Employee employee);

    /**
     * 根据用户id查询员工
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM employee where id = #{id}")
    Employee getById(Long id);
}
