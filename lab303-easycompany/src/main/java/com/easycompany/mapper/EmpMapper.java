package com.easycompany.mapper;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.service.Employee;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("empMapper")
public class EmpMapper extends EgovAbstractMapper{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpMapper.class);
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(Map<?, ?> param) throws DataAccessException {
		return selectList("com.easycompany.mapper.EmpMapper.getAllEmployees", param);
	}

	public Employee getEmployeeInfoById(String id) throws DataAccessException {
		return (Employee)selectOne("com.easycompany.mapper.EmpMapper.getEmployeeInfoById", id);
	}

	public void deleteEmployee(String id) {
		deleteEmployee(id);
	}

	public int insertEmployee(Employee emp) {

	    int result = -1;
	    
        try {
            // TODO [Step 4-5-02] insertEmployee 메소드는 EgovAbstractMapper에서 제공되는  insert()를 이용하여 
            // com.easycompany.mapper.EmpMapper.insertEmployee ID 를 가진 sql문을 실행한다.
        	insert("com.easycompany.mapper.EmpMapper.insertEmployee", emp);
        	result = 1;

        } catch (Exception e) {
        	LOGGER.debug("EmployeeManageDaoImpl DAO Exception: {}", e);
            e.printStackTrace();
        }

		return result;
	}

	public int updateEmployee(Employee emp) {
		return update("com.easycompany.mapper.EmpMapper.updateEmployee", emp);
	}

	@SuppressWarnings("unchecked")
	public List<String> getNameListForSuggest(String namePrefix) {
		return selectList("com.easycompany.mapper.EmpMapper.getNameListForSuggest", namePrefix);
	}

	public int getEmployeeCount(Map<?, ?> param) {
		return (Integer)selectOne("com.easycompany.mapper.EmpMapper.getEmployeeCount", param);
	}

}
