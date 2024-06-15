package egovframework.lab.com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import egovframework.lab.web.model.LoginCommand;

@Component("loginCommandValidator")
public class LoginCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		if (LoginCommand.class.isAssignableFrom(clazz))
			return true;
		return false;
	}

	@SuppressWarnings("unused")
	public void validate(Object target, Errors errors) {
		LoginCommand command = (LoginCommand) target;

		//TODO [Step 1-4-2] LoginCommandValidator.java 에서 validate 메소드 완성하기.
		ValidationUtils.rejectIfEmpty(errors, "id", "required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

		ValidationUtils.rejectIfEmpty(errors, "loginType", "required");


	}

}
