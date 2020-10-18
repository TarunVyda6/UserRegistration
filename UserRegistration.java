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
		firstName = validateName(scanner,firstName);
		System.out.println("please enter the last name");
		String lastName = scanner.nextLine();
		lastName = validateName(scanner,lastName);
		System.out.println("first name is : " + firstName);
		System.out.println("last name is : " + lastName);
	}

	private static String validateName(Scanner scanner, String name) 
	{
		String regex = "^[A-Z]{1}[a-zA-Z]{2,17}$";
		String type = "name";
		String status = validation(name, type, regex);
		if( status != "true" ) 
		{
			System.out.println(status+"\nplease enter the name");
			name = scanner.nextLine();
			name = validateName(scanner, name);
			return name;
		}
		return name;
	}

	private static String validation(String value,String type, String regex)
	{
		  if ( value == null ) 
		  { 
	            return "Empty input"; 
	      }
		 String errorMessage="";
		 if ( type == "name" )
		 {
			 errorMessage = "First Name should be 3 to 20 characters and should start with a Capital letter.";
		 }
		 
			Pattern pattern = Pattern.compile(regex);  
	        Matcher matcher = pattern.matcher(value); 
	        return matcher.matches()? "true" : errorMessage; 
		
	}

}
