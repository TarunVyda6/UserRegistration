package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface ValidateUserInput
{
    boolean validate ( String input );
}

public class UserRegistration
{
    static String nameRegex = "^[A-Z]{1}[a-zA-Z]{2,17}$";
    static String passwordRegex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$";
    static String numberRegex = "^[0-9]{2,3} [0-9]{10}$";
    static String emailRegex = "^[a-zA-Z]{3,}[0-9]{0,}([-._+]{1}[a-zA-Z0-9]{3,})?@[a-zA-Z0-9]{1,}[.]{1}[a-zA-Z]{3}(.[a-zA-z]{2,4})?$";

    static ValidateUserInput validateUserName = input -> Pattern.matches ( nameRegex, input );
    static ValidateUserInput validatePassword = input -> Pattern.matches ( passwordRegex, input );
    static ValidateUserInput validateNumber = input -> Pattern.matches ( numberRegex, input );
    static ValidateUserInput validateEmail = input -> Pattern.matches ( emailRegex, input );


}
