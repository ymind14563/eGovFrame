package egovframework.lab.ioc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.lab.ioc.service.EmpService;
import egovframework.lab.ioc.service.EmpVO;
// TODO [Step 2-3] AnnotationEmpServiceImpl 작성

@Service("annotationEmpService")
public class AnnotationEmpServiceImpl implements EmpService {

	@Resource(name = "annotationEmpDAO")
	private AnnotationEmpDAO empDAO;

	public void insertEmp(EmpVO empVO) throws Exception {
		empDAO.insertEmp(empVO);
	}

	public void updateEmp(EmpVO empVO) throws Exception {
		empDAO.updateEmp(empVO);
	}

	public void deleteEmp(EmpVO empVO) throws Exception {
		empDAO.deleteEmp(empVO);
	}

	public EmpVO selectEmp(EmpVO empVO) throws Exception {
		return empDAO.selectEmp(empVO);
	}

	public List<EmpVO> selectEmpList() throws Exception {
		return empDAO.selectEmpList();
	}

}