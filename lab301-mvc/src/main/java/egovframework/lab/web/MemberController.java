package egovframework.lab.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.lab.web.model.Address;
import egovframework.lab.web.model.Code;
import egovframework.lab.web.model.MemberInfo;

@Controller
public class MemberController {
	
	private String formView = "member/memberForm";
	private String successView = "member/memberSuccess";
	
	@ModelAttribute("jobCodes")
	protected List<Code> getJobCodes() {
		List<Code> jobCodes = new ArrayList<Code>();
		jobCodes.add(new Code("1", "하나"));
		jobCodes.add(new Code("2", "UI둘"));
		jobCodes.add(new Code("3", "셋"));
		jobCodes.add(new Code("3", "넷"));
		return jobCodes;
	}

	@ModelAttribute("favoritesOsNames")
	protected String[] getFavoritesOsNames() {
		String[] favoritesOsNames = { "WIN2000", "WINXP", "OK", "SS", "A" };
		return favoritesOsNames;
	}

	@ModelAttribute("tools")
	protected String[] getTools() {
		String[] tools = { "Eclipse", "IntelliJ", "NetBeans" };
		return tools;
	}

	@ModelAttribute("memberInfo")
	protected Object formBackingObject() {
		MemberInfo member = new MemberInfo();
		member.setAddress(new Address());
		return member;
	}

	@RequestMapping(value = "/member.do", method=RequestMethod.GET)
	protected String defaultMember(){
		return formView;
	}
	
	@RequestMapping(value = "/member.do", method=RequestMethod.POST)
	protected String regist(@ModelAttribute("memberInfo") MemberInfo command, BindingResult errors)
	        throws Exception {

		checkDuplicateId(command.getId(), errors);
		if (errors.hasErrors()) {
			return formView;
		}
		return successView;
	}

	private void checkDuplicateId(String userId, BindingResult errors) {
		if (userId.equals("egovframe")) {
			errors.rejectValue("id", "duplicate");
		}
	}

}
