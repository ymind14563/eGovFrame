package com.easycompany.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easycompany.cmm.validator.DepartmentValidator;
import com.easycompany.service.Department;
import com.easycompany.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/departmentList.do")
	public String getDepartmentList(@RequestParam Map<String, String> commandMap, ModelMap model) {

		List<Department> departmentlist = departmentService.getDepartmentList(commandMap);
		model.addAttribute("departmentlist", departmentlist);
		return "departmentlist";
	}

	@RequestMapping("/subDepartmentList.do")
	public String getSubDepartmentList(@RequestParam Map<String, String> commandMap, ModelMap model) {

		List<Department> departmentlist = departmentService.getDepartmentList(commandMap);
		model.addAttribute("departmentlist", departmentlist);
		return "departmentsublist";
	}

	/**
	 * 상위부서리스트(selectbox)는 부서정보클래스에 없으므로 , 상위부서리스트 데이터를 DB에서 구해서 별도의 참조데이터로 구성한다. 
	 */
	@ModelAttribute("deptInfoOneDepthCategory")
	public Map<String, String> referenceData() {
		return departmentService.getDepartmentIdNameList("1");
	}

	/**
	 * 해당 부서번호의 부서정보 데이터를 불러와 입력폼을 채운다
	 */
	@RequestMapping(value = "/updateDepartment.do", method = RequestMethod.GET)
	public String formBackingObject(@RequestParam("deptid") String deptid, ModelMap model) {
		Department department = departmentService.getDepartmentInfoById(deptid);
		model.addAttribute("department", department); //form tag의 modelAttribute은 이 attribute name과 일치해야 한다. <form:form modelAttribute="department">.
		return "modifydepartment";
	}

	/**
	 * 사용자가 데이터 수정을 끝내고 submit하면 수정 데이터로 DB에 저장한다.
	 * 저장이 성공하면 부서리스트 페이지로 이동하고 에러가 있으면 다시 입력폼페이지로 이동한다.
	 * 
	 * @param department 부서정보
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/updateDepartment.do", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("department") Department department, BindingResult bindingResult) {

		//validation code
		new DepartmentValidator().validate(department, bindingResult);
		if (bindingResult.hasErrors()) {
			return "modifydepartment";
		}

		try {
			departmentService.updateDepartment(department);
			return "redirect:/departmentList.do?depth=1";
		} catch (Exception e) {
			e.printStackTrace();
			return "modifydepartment";
		}
	}
}
