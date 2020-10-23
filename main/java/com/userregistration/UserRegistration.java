package com.userregistration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration
{
    public static boolean validatePassword ( String password ) throws UserDetailsException
    {
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$";
        return validation ( password, regex );
    }

    public static boolean validatePhoneNumber ( String phoneNumber ) throws UserDetailsException
    {
        String regex = "^[0-9]{2,3} [0-9]{10}$";
        return validation ( phoneNumber, regex );
    }

    public static boolean validateEmail ( String email ) throws UserDetailsException
    {
        String regex = "^[a-zA-Z]{3,}[0-9]{0,}([-._+]{1}[a-zA-Z0-9]{3,})?@[a-zA-Z0-9]{1,}[.]{1}[a-zA-Z]{3}(.[a-zA-z]{2,4})?$";
        return validation ( email, regex );
    }

    public static boolean validateName ( String name ) throws UserDetailsException
    {

        String regex = "^[A-Z]{1}[a-zA-Z]{2,17}$";
        return validation ( name, regex );

    }

    public static boolean validation ( String value, String regex ) throws UserDetailsException
    {
        try {
            Pattern pattern = Pattern.compile ( regex );

            Matcher matcher = pattern.matcher ( value );

            if (matcher.matches ()) {
                return true;
            } else {
                throw new UserDetailsException ( UserDetailsException.ExceptionType.INVALID, "invalid input" );
            }

        } catch (NullPointerException exception) {
            throw new UserDetailsException ( UserDetailsException.ExceptionType.NULL, "null input" );
        }
    }

}
