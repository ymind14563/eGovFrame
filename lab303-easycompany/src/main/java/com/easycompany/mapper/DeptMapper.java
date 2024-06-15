package com.easycompany.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.service.Department;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("deptMapper")
public class DeptMapper extends EgovAbstractMapper{

	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentList(Map<?, ?> param) throws DataAccessException {
		return selectList("com.easycompany.mapper.DeptMapper.getDepartmentList", param);
	}

	public Department getDepartmentInfoById(String id) throws DataAccessException {
		return (Department) selectOne("com.easycompany.mapper.DeptMapper.getDepartmentInfoById", id);
	}

	public int updateDepartment(Department department) throws DataAccessException {
		return update("com.easycompany.mapper.DeptMapper.updateDepartment", department);
	}
	
}
