package com.soil.springcloud.dao;

import com.soil.springcloud.service.model.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    boolean addDetp(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
