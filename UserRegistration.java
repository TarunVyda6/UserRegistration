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
		String firstName=validateFirstName(scanner);
		System.out.println(firstName);
		
	}

	private static String validateFirstName(Scanner scanner) 
	{
		System.out.println("please enter the first name");
		String firstName = scanner.nextLine();
		String regex = "^[A-Z]{1}[a-zA-Z]{2,17}$";
		String status = validation(firstName,"firstNameType", regex);
		if( status != "true" ) 
		{
			System.out.println(status);
			firstName = validateFirstName(scanner);
			return firstName;
		}
		return firstName;
	}

	private static String validation(String value,String type, String regex)
	{
		  if (value == null) 
		  { 
	            return "Empty input"; 
	      }
		 String errorMessage="";
		 if( type == "firstNameType" )
		 {
			 errorMessage = "First Name should be 3 to 20 characters and should start with a Capital letter.";
		 }
		 
			Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(value); 
	        return matcher.matches()? "true" : errorMessage; 
		
	}

}
