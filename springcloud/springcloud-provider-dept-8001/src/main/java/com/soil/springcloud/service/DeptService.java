package com.soil.springcloud.service;

import com.soil.springcloud.service.model.Dept;

import java.util.List;

public interface DeptService {

    boolean addDetp(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
