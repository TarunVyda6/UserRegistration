package com.userregistration;

import org.junit.Assert;
import org.junit.Test;

public class UserValidation
{
    @Test
    public void testNameValidate () throws UserDetailsException
    {
        try {
            UserRegistration.validateName ( null );
        } catch (UserDetailsException exception) {
            Assert.assertEquals ( UserDetailsException.ExceptionType.NULL, exception.exceptionType );
        }

        // Valid names
        String[] validNames = {"Akram", "Joe"};
        for (String name : validNames)
            UserRegistration.validateName ( name );
        // Invalid names
        String[] invalidNames = {"kram", "bh"};
        for (String name : invalidNames) {
            try {
                UserRegistration.validateName ( name );
            } catch (UserDetailsException exception) {
                Assert.assertEquals ( UserDetailsException.ExceptionType.INVALID, exception.exceptionType );
            }
        }


    }

    @Test
    public void testEmailValidate () throws UserDetailsException
    {
        try {
            UserRegistration.validateName ( null );
        } catch (UserDetailsException exception) {
            Assert.assertEquals ( UserDetailsException.ExceptionType.NULL, exception.exceptionType );
        }

        // Valid email
        String[] validEmails = {"abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com",
                "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.co", "abc+100@gmail.com"};
        for (String email : validEmails)
            UserRegistration.validateEmail ( email );
        // Invalid email
        String[] invalidEmails = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
                ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com",
                "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"};
        for (String email : invalidEmails) {
            try {
                UserRegistration.validateEmail ( email );
            } catch (UserDetailsException exception) {
                Assert.assertEquals ( UserDetailsException.ExceptionType.INVALID, exception.exceptionType );
            }
        }
    }

    @Test
    public void testMobileValidate () throws UserDetailsException
    {
        // Null check
        try {
            UserRegistration.validatePhoneNumber ( null );
        } catch (UserDetailsException exception) {
            Assert.assertEquals ( UserDetailsException.ExceptionType.NULL, exception.exceptionType );
        }
        // Valid mobile numbers
        String[] validMobileNumbers = {"91 9851605588", "92 6584122568"};
        for (String mobileNumber : validMobileNumbers)
            UserRegistration.validatePhoneNumber ( mobileNumber );
        // Invalid mobile numbers
        String[] invalidEmails = {"9 9851256598", "91 67656415"};
        for (String mobileNumber : invalidEmails) {
            try {
                UserRegistration.validatePhoneNumber ( mobileNumber );
            } catch (UserDetailsException exception) {
                Assert.assertEquals ( UserDetailsException.ExceptionType.INVALID, exception.exceptionType );
            }
        }
    }

    @Test
    public void testPasswordValidate () throws UserDetailsException
    {
        // Null check
        try {
            UserRegistration.validatePassword ( null );
        } catch (UserDetailsException exception) {
            Assert.assertEquals ( UserDetailsException.ExceptionType.NULL, exception.exceptionType );
        }
        // Valid passwords
        String[] validPasswords = {"Akram@123*", "Akram@3Kabir"};
        for (String password : validPasswords)
            UserRegistration.validatePassword ( password );
        // Invalid passwords
        String[] invalidPasswords = {"Akrhg*98/", "AkramKabir!", "AkramKabir!", "AkramKabir!"};
        for (String password : invalidPasswords) {
            try {
                UserRegistration.validatePassword ( password );
            } catch (UserDetailsException exception) {
                Assert.assertEquals ( UserDetailsException.ExceptionType.INVALID, exception.exceptionType );
            }
        }
    }


}
