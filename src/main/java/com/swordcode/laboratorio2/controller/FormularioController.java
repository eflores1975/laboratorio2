package com.swordcode.laboratorio2.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.swordcode.laboratorio2.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class FormularioController {
	private List<String>						countries;
	private static final String 				regex = "^(.+)@(.+)$";

	@RequestMapping({"/", "/formulario"})
	public String formulario(Model model) {
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userInfo", userInfo);
		return "formulario";
	}

	@PostMapping("/saveUserInfo")
	public String submitForm(@ModelAttribute("userInfo") UserInfo userInfo, BindingResult result, SessionStatus status) {
		boolean error = isNotValidField(userInfo.getName(), "name", "error.name", result);
		if (!error) error = isNotValidField(userInfo.getEmail(), "email", "error.email", result);
		if (!error) error = isNotValidField(userInfo.getId(), "id", "error.id", result);
		if (!error) error = isNotValidField(userInfo.getCompany(), "company", "error.company", result);
		if (!error) error = isNotValidField(userInfo.getGender(), "gender", "error.gender", result);
		if (!error) error = isNotValidField(userInfo.getFood(), "food", "error.food", result);
		if (!error) error = isNotValidField(userInfo.getPet(), "pet", "error.pet", result);
		if (!error) error = isNotValidField(userInfo.getProfession(), "profession", "error.profession", result);

		if (error) return "formulario";

		writeUserInfoToFile(userInfo);
		return "save_user_info_success";
	}

	private boolean isNotValidField(String value, String field, String errorCode, BindingResult result) {
		if (value == null || value.isEmpty()) {
			result.rejectValue(field, errorCode);
			return true;
		}

		if (field.equals("email")) {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
			if (!matcher.matches()) result.rejectValue(field, errorCode);
			return !matcher.matches();
		}

		return false;
	}

	@ModelAttribute("countries")
	public List<String> getCountries() {
		if (countries == null) countries = Arrays.asList( "Argentina", "Colombia", "España", "Estados Unidos", "Panamá", "Reino Unido");
		return countries;
	}

	private void writeUserInfoToFile(UserInfo ui) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(ui.getName());
			sb.append(";");
			sb.append(ui.getEmail());
			sb.append(";");
			sb.append(ui.getCountry());	
			sb.append(";");
			sb.append(ui.getId());
			sb.append(";");
			sb.append(ui.getCompany());
			sb.append(";");
			sb.append(ui.getGender());
			sb.append(";");
			sb.append(ui.getFood());
			sb.append(";");
			sb.append(ui.getPet());
			sb.append(";");
			sb.append(ui.getProfession());
			sb.append(";");
			sb.append(ui.getProfession());
			sb.append(";");
			sb.append(ui.getComment());
			sb.append("\r\n");
			File file = new File("/tmp/datafile-laboratorio2.txt");
			FileWriter fr = new FileWriter(file, true);
			fr.write(sb.toString());
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}