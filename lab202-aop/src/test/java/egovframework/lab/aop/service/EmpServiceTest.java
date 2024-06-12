package egovframework.lab.aop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.lab.aop.common.BizException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath*:META-INF/spring/context-common.xml",
	"classpath*:META-INF/spring/context-emp.xml",
	"classpath*:META-INF/spring/context-advice-xml.xml"})
public class EmpServiceTest {

	// TODO [Step 1-8, 2-8] EmpServiceTest 작성

	// xml 형식으로 bean 설정한 경우 - 주석을 변경해 가며 xml,
	// annotation 에 대해 테스트 할것
	@Resource(name = "xmlEmpService")
	EmpService empService;

	// annotation 형식으로 bean 설정한 경우
	// @Resource(name = "annotationEmpService")
	// EmpService empService;

	public EmpVO makeVO() {
		// DAO 확인 - static 하게 관리하는 100 개 기본 데이터 있음
		return makeVO(101);
	}

	public EmpVO makeVO(int empNo) {
		EmpVO vo = new EmpVO();
		vo.setEmpNo(empNo);
		vo.setEmpName("홍길동" + empNo);
		vo.setJob("개발자");
		return vo;
	}

	public void checkResult(EmpVO vo, EmpVO resultVO) {
		assertNotNull(resultVO);
		assertEquals(vo.getEmpNo(), resultVO.getEmpNo());
		assertEquals(vo.getEmpName(), resultVO.getEmpName());
		assertEquals(vo.getJob(), resultVO.getJob());
	}

	@Test
	public void testInsertEmp() throws Exception {
		EmpVO vo = makeVO();

		// insert
		empService.insertEmp(vo);

		// select
		EmpVO resultVO = empService.selectEmp(vo);

		// check
		checkResult(vo, resultVO);
	}

	@Test
	public void testUpdateEmp() throws Exception {
		EmpVO vo = makeVO(102);

		// insert
		empService.insertEmp(vo);

		// data change
		vo.setEmpName("홍길순");
		vo.setJob("설계자");

		// update
		empService.updateEmp(vo);

		// select
		EmpVO resultVO = empService.selectEmp(vo);

		// check
		checkResult(vo, resultVO);
	}

	@Test
	public void testDeleteEmp() throws Exception {
		EmpVO vo = makeVO(103);

		// insert
		empService.insertEmp(vo);

		// delete
		empService.deleteEmp(vo);

		// select
		try {
			@SuppressWarnings("unused")
			EmpVO resultVO = empService.selectEmp(vo);
			fail("Biz Exception 이 발생해야 합니다.");
		} catch (Exception e) {
			assertNotNull(e);
			// aop 를 적용하여 after-throwing 에서 가공한 BizException 으로 넘어올 것임.
			// cf.) ServiceImpl 원본에서는 그냥 Exception 이었음.
			assertTrue(e instanceof BizException);
			assertEquals("에러가 발생했습니다.", e.getMessage());
			assertEquals("no data found!", e.getCause().getMessage());
		}
	}

	@Test
	public void testSelectEmpList() throws Exception {

		// select list
		List<EmpVO> resultList = empService.selectEmpList();

		// check
		int firstListSize = resultList.size();
		// DAO 에서 Emp 데이터를 관리할 때 항상 sorted 된 상태임
		assertEquals(1, resultList.get(0).getEmpNo());

		// delete first data
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo(1);

		empService.deleteEmp(empVO);

		// select List again
		resultList = empService.selectEmpList();

		assertEquals(firstListSize - 1, resultList.size());
		// DAO 에서 Emp 데이터를 관리할 때 항상 sorted 된 상태임
		assertEquals(2, resultList.get(0).getEmpNo());
		assertEquals("EmpName 2", resultList.get(0).getEmpName());
		assertEquals("SALESMAN", resultList.get(0).getJob());

	}

}