package com.easycompany.service;

import java.util.List;
import java.util.Map;


public interface EmployeeService {
	
	public Employee getEmployeeInfoById(String id);
	public List<Employee> getAllEmployees(Map<?, ?> param) throws Exception;
	public int getEmployeeCount(Map<?, ?> param);
    public int updateEmployee(Employee emp);
    public void deleteEmployee(String id);
    public int insertEmployee(Employee emp);
    public List<String> getNameListForSuggest(String namePrefix);
}
