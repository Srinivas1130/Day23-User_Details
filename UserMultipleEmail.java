package com.bridgelabz.day23;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserMultipleEmail {
	private static void multipleEmailValidation() throws UserException {
		//UC9 Should clear all email samples
		ArrayList<String> eMails = new ArrayList<String>();
		eMails.add("abc@yahoo.com");
		eMails.add("abc-100@yahoo.com");
		eMails.add("abc.100@yahoo.com");
		eMails.add("abc111@abc.com");
		eMails.add("abc-100@abc.net");
		eMails.add("abc.100@abc.com.au");
		eMails.add("abc@1.com");
		eMails.add("abc@gmail.com");
		eMails.add("abc+100@gmail.com");
		eMails.add("abc");
		String multipleEmailePattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9]+)*@" + "(?:[a-zA-Z0-9]+\\.)+[a-zA-Z]{2,7}$";
		UserInterface validatingMultipleEmail = (multipleemail) -> {
			if (multipleemail.isEmpty()) {
				throw new UserException("Multiple Email should not be empty");
			}
			Pattern pattern = Pattern.compile(multipleEmailePattern);
		//for (String eMail: eMails) {
			Matcher matcher = pattern.matcher((CharSequence) eMails);
			//System.out.println(eMails + " --> " + matcher.matches());
			boolean result5 = matcher.matches();
				if(result5 == true)
					System.out.println("Password is Valid");
				else
					System.out.println("Password is Invalid");
				return result5;
		};
	   System.out.println(validatingMultipleEmail.validate(eMails));
	}

		public static void main(String[] args) throws UserException {
			System.out.println("Welcome to User Registration program");
			multipleEmailValidation();
		}
		

}
