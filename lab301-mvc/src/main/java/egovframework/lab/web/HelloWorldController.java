package egovframework.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    private String viewName = "hello/helloworld";

    public String getViewName() {
        return this.viewName;
    }

    /*
     * TODO [Step 1-1-2] @RequestMapping - 요청 URL과 View 연결하기
     * http://localhost:8080/lab301-mvc/hello.do 로 요청이 들어오는 경우 실행되는 핸들러를 만들어 보자.
     * 반환은 String 이고 getViewName() 메소드를 이용한다.
     */
    
	// context-servlet.xml 설정
    // /WEB-INF/jsp/ + hello/helloworld + .jsp
    // /WEB-INF/jsp/hello/helloworld.jsp
    
    @RequestMapping(value = "/hello.do")
    public String helloworld() {
    	return getViewName();
    }
}
