package com.easycompany.cmm.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.easycompany.cmm.view.AjaxXmlView;
import com.easycompany.service.Department;
import com.easycompany.service.DepartmentService;
import com.easycompany.service.EmployeeService;


@Controller
public class AjaxController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	//사원정보 리스트 페이지에서 검색입력창(사원이름)에 사용되는 자동완성기능
	@RequestMapping("/suggestName.do")
	protected ModelAndView suggestName(HttpServletRequest request)throws Exception{
		
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("jsonView");
    	
		String searchName = URLDecoder.decode(request.getParameter("searchName"),"utf-8");

		System.out.println("searchName: "+searchName);
		List<String> nameList = employeeService.getNameListForSuggest(searchName);

		modelAndView.addObject("nameList", nameList);
	
		return modelAndView;
	}
	
	//linked selectbox 처리 기능
	@RequestMapping("/autoSelectDept.do")
	protected ModelAndView getDeptInfoforSelectTag(HttpServletRequest request) throws Exception{
		
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("jsonView");
		
    	String superdeptid = URLDecoder.decode(request.getParameter("superdeptid"),"utf-8");
    	String depth = URLDecoder.decode(request.getParameter("depth"),"utf-8");
    	
		Map<String, String> param = new HashMap<String, String>();
		param.put("superdeptid",superdeptid);
		param.put("depth",depth);
		List<Department> deptList = departmentService.getDepartmentList(param);
		
		modelAndView.addObject("depthList", deptList);
		
		return modelAndView;
	}
}
