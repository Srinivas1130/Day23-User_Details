package com.bridgelabz.day23;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserInterface {
	boolean validate(String str) throws UserException;
}
public class UserDetails {

	private static void validatingUserFirstName() throws UserException {

		String firstNamePattern = "[A-Z]{1}[a-z]{2,}";
		UserInterface validatingFirstName = (firstName) -> {
			if (firstName.isEmpty()) {
				throw new UserException("First Name should not be empty");
			}
			Pattern pattern = Pattern.compile(firstNamePattern);
			Matcher matcher = pattern.matcher(firstName);
			boolean result = matcher.matches();

			if(result == true)
				UserDetails.validatingUserLastName();
			else
				System.out.println("First Name is Invalid");
			return result;
		};
		System.out.println(validatingFirstName.validate("Srinivas"));	
	}

	private static void validatingUserLastName() throws UserException {
		String lastNamePattern = "[A-Z]{1}[a-z]{2,}";
		UserInterface validatingLastName = (lastName) -> {
			if (lastName.isEmpty()) {
				throw new UserException("Last Name should not be empty");
			}
			Pattern pattern = Pattern.compile(lastNamePattern);
			Matcher matcher = pattern.matcher(lastName);
			boolean result1 = matcher.matches();

			if(result1 == true)
				UserDetails.validatingUserEmail();
			else
				System.out.println("Last Name is Invalid");
			return result1;
		};
		System.out.println(validatingLastName.validate("Achar"));
	}

	private static void validatingUserEmail() throws UserException {
		String emailPattern = "[A-Za-z0-9.+-]+@[a-z0-9]*+[.][a-z]*";
		UserInterface validatingUserEmail = (email) -> {
			if (email.isEmpty()) {
				throw new UserException("Email should not be empty");
			}
			Pattern pattern = Pattern.compile(emailPattern);
			Matcher matcher = pattern.matcher(email);
			boolean result2 = matcher.matches();

			if(result2 == true)
				UserDetails.validatingUserMobileNumber();
			else
				System.out.println("Email is Invalid");
			return result2;
		};
		System.out.println(validatingUserEmail.validate("srinivas@gmail.com"));
	}

	private static void validatingUserMobileNumber() throws UserException {

		String mobileNoPattern = "(91-)?[6-9][0-9]{9}";
		UserInterface validatingMobileNo = (mobileno) -> {
			if (mobileno.isEmpty()) {
				throw new UserException("MobileNo should not be empty");
			}
			Pattern pattern = Pattern.compile(mobileNoPattern);
			Matcher matcher = pattern.matcher(mobileno);
			boolean result3 = matcher.matches();

			if(result3 == true)
				UserDetails.validatingUserPasswordRule1234();
			else
				System.out.println("MobileNo is Invalid");
			return result3;
		};
		System.out.println(validatingMobileNo.validate("91-7204185787"));
	}

	private static void validatingUserPasswordRule1234() throws UserException {

		String passwordPaternRule1234 = "([0-9a-zA-Z]*[~!@#$]){1}[0-9a-zA-Z~!@#$]*";
		UserInterface validatingPassword = (password) -> {
			if (password.isEmpty()) {
				throw new UserException("Password should not be empty");
			}
			Pattern pattern = Pattern.compile(passwordPaternRule1234);
			Matcher matcher = pattern.matcher(password);
			boolean result4 = matcher.matches();

			if(result4 == true)
				System.out.println("Password is Valid");
			else
				System.out.println("Password is Invalid");
			return result4;
		};
		System.out.println(validatingPassword.validate("Seena@720S"));
	}

	public static void main(String[] args) throws UserException {
		System.out.println("welcome User registration");
		UserDetails.validatingUserFirstName();
	}
}
