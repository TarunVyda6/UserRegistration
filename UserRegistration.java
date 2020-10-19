package com.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		operatingMethod(scanner);
	}

	private static void operatingMethod(Scanner scanner)
	{
		System.out.println("please enter the first name");
		String firstName = scanner.nextLine();
		firstName = validateName(scanner, firstName);
		System.out.println("please enter the last name");
		String lastName = scanner.nextLine();
		lastName = validateName(scanner, lastName);
		System.out.println("please enter the email id");
		String email = scanner.nextLine();
		email = validateEmail(scanner, email);

		System.out.println("please enter the phone number");
		String phoneNumber = scanner.nextLine();
		phoneNumber = validatePhoneNumber(scanner, phoneNumber);

		System.out.println("please enter the password");
		String password = scanner.nextLine();
		password = validatePassword(scanner, password);

		System.out.println("first name is : " + firstName);
		System.out.println("last name is : " + lastName);
		System.out.println("email id is : " + email);
		System.out.println("phone number is : " + phoneNumber);
		System.out.println("password is : " + password);

	}

	private static String validatePassword(Scanner scanner, String password) 
	{
		String regex = "^(?=.*[0-9])(?=.*[A-Z]).{8,20}$";
		String type = "password";
		String status = validation(password, type, regex);

		if (status != "true")
		{
			System.out.println(status + "\nplease enter the password correctly");
			password = scanner.nextLine();
			password = validatePassword(scanner, password);
			return password;
		}
		return password;
	}

	private static String validatePhoneNumber(Scanner scanner, String phoneNumber)
	{
		String regex = "^[0-9]{2,3} [0-9]{10}$";
		String type = "phoneNumber";
		String status = validation(phoneNumber, type, regex);

		if (status != "true")
		{
			System.out.println(status + "\nplease enter the phone number correctly");
			phoneNumber = scanner.nextLine();
			phoneNumber = validatePhoneNumber(scanner, phoneNumber);
			return phoneNumber;
		}
		return phoneNumber;
	}

	private static String validateEmail(Scanner scanner, String email) 
{
		String regex = "^[a-zA-Z]{3,}[0-9]{0,}([-._+]{1}[a-zA-Z0-9]{3,})?@[a-zA-Z0-9]{1,}[.]{1}[a-zA-Z]{3}(.[a-zA-z]{2,4})?$";
		String type = "email";
		String status = validation(email, type, regex);

		if (status != "true")
		{
			System.out.println(status + "\nplease enter the email correctly");
			email = scanner.nextLine();
			email = validateEmail(scanner, email);
			return email;
		}
		return email;
	}

	private static String validateName(Scanner scanner, String name)
	{
		String regex = "^[A-Z]{1}[a-zA-Z]{2,17}$";
		String type = "name";
		String status = validation(name, type, regex);
		if (status != "true") 
		{
			System.out.println(status + "\nplease enter the name correctly");
			name = scanner.nextLine();
			name = validateName(scanner, name);
			return name;
		}
		return name;
	}

	private static String validation(String value, String type, String regex)
	{
		if (value == null) 
		{
			return "Empty input";
		}
		String errorMessage = "";
		if (type == "name") 
		{
			errorMessage = "First Name should be 3 to 20 characters and should start with a Capital letter.";
		} else if (type == "email")
		{
			errorMessage = "email should be abc.xyz@bridgelabz.co.in form where abc, bridgelabz and co are mandatory and the remaining are optional";
		}

		else if (type == "phoneNumber") 
		{
			errorMessage = "phone number should be country code followed by space and 10 digit number";
		}

		else if (type == "password") 
		{
			errorMessage = "password should be minimum 8 characters and atleast one capital letter";
		}

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches() ? "true" : errorMessage;

	}

}
