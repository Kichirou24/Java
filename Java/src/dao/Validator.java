package dao;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public boolean isValidDate(String date) {
		Pattern pt = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
		Matcher mc = pt.matcher(date);
		
		if (mc.find() == false)
			return false;
		
		try {
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public boolean isValidPhone(String phone) {
		Pattern pt = Pattern.compile("(0|\\+84)\\d{9,10}$");
		Matcher mc = pt.matcher(phone);
		return mc.find();
	}
	
	public boolean isValidEmail(String email) {
		Pattern pt = Pattern.compile("(\\w+)@(\\w+.)(\\w+.){2,}");
		Matcher mc = pt.matcher(email);
		return mc.find();
	}
	
	public boolean isValidId(String id) {
		Pattern pt = Pattern.compile("^[a-zA-Z]");
		// Pattern pt = Pattern.compile("^(nv)\\d+.{2,}$");
		// Pattern pt = Pattern.compile("^(gv)\\d+.{2,}$");
		Matcher mc = pt.matcher(id);
		return mc.find();
	}
}
