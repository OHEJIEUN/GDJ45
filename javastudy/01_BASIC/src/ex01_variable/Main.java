package ex01_variable;

import java.io.File;
import java.util.Calendar;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String sep = Matcher.quoteReplacement(File.separator);
		File dir = new File("C:" + sep + "upload" + sep + year + sep + month + sep + day);
		if(dir.exists() == false) {
			dir.mkdirs();
		}

	}

}
