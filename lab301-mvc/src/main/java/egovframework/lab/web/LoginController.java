package egovframework.lab.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import egovframework.lab.com.authenticator.Authenticator;
import egovframework.lab.web.model.LoginCommand;
import egovframework.lab.web.model.LoginType;



//TODO [Step 1-3-2] LoginController.java 에 login 명의 객체에 대해  @SessionAttributes 설정 하기
//이 부분은 login 객체를 Session 객체에 저장하는 방법이다.
@Controller
@SessionAttributes("login") 
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("loginCommandValidator")
    private Validator loginCommandValidator;

    @Resource(name = "LoginAuthenticator")
    private Authenticator authenticator;
    

    
	private String formView = "login/loginForm";
	private String successView = "login/loginSuccess";

	private String getFormView() {
		return formView;
	}

	private String getSuccessView() {
		return successView;
	}

	public void setFormView(String formView) {
		this.formView = formView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}


	/*
	 * TODO [Step 1-2-4] @RequestMapping - method별 mapping 전략
	 * 웹을 통해 들어오는 url 은 loginProcess1.do 이며 Get/Post 형식으로 넘어온다. 
	 * 두가지를 다받는 메소드를 만들어보자.
	 */
	@RequestMapping(value = "/loginProcess1.do", method = RequestMethod.GET)
	public String loginFormSetUp() {
		return getFormView();
	}

	@RequestMapping(value = "/loginProcess1.do", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("login") LoginCommand loginCommand) {
		return getSuccessView();
	}
	/*
	 * TODO [Step 1-2-5] @ModelAttribute - 모델의 초기화
	 * ModelAttribute를 이용하여 loginTypes와 login 객체를 초기화 해주는 메소드를 만든다. 
	 */
	
	/*---선택하세요--- 부분*/
	/* LoginForm.jsp */
	@ModelAttribute("loginTypes")
	protected List<LoginType> referenceData() throws Exception {
		List<LoginType> loginTypes = new ArrayList<LoginType>();
		loginTypes.add(new LoginType("A", "개인회원"));
		loginTypes.add(new LoginType("B", "기업회원"));
		loginTypes.add(new LoginType("C", "관리자"));
		return loginTypes;
	}
	
	@ModelAttribute("login")
	protected Object referenceData4login() throws Exception {
		return new LoginCommand();
	}
	
	// 사용자 정보보기 mapping
	@RequestMapping(value = "/memberInfo.do")
	public ModelAndView memberInfo(HttpSession httpSession ) {
		ModelAndView mav = new ModelAndView("login/memberInfo");
		
		if(httpSession.getAttribute("login")!= null)
		mav.addObject("login",httpSession.getAttribute("login"));
		
		return mav;
	}
	public ModelAndView memberInfo() {
		ModelAndView mav = new ModelAndView("login/memberInfo");
		return mav;
	}

}
