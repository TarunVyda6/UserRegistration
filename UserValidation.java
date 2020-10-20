package com.userregistration;

import org.junit.Assert;
import org.junit.Test;

public class UserValidation
{
    @Test
    public void whenGiven_ProperName_ShouldReturn_True ()
    {
        boolean result = UserRegistration.validateName ( "Rahul" );
        Assert.assertTrue ( result );
    }

    @Test
    public void whenGiven_ShortName_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validateName ( "Ra" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_Digit_Name_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validateName ( "1Rahul" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_SpecialCharacter_Name_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validateName ( "Rahul*" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_NotCapitalFirst_Name_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validateName ( "rahul" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_ProperEmail_ShouldReturn_True ()
    {
       boolean result = UserRegistration.validateEmail ( "Rahul.raja6@yahoo.com" );
        Assert.assertTrue ( result );
    }

    @Test
    public void whenGiven_ImProperEmail_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validateEmail ( "abc.@gmail.com" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_ProperMobileNumber_ShouldReturn_True ()
    {
        boolean result = UserRegistration.validatePhoneNumber ( "91 8989898989" );
        Assert.assertTrue ( result );
    }

    @Test
    public void whenGiven_LessDigitsNumber_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePhoneNumber ( "91 89874" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_ImproperCountryCode_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePhoneNumber ( "9165 8987488888" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_WithoutCountryCode_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePhoneNumber ( "8987488888" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_MoreThanTenDigits_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePhoneNumber ( "91 898748888888" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_ProperPassword_ShouldReturn_True ()
    {
        boolean result = UserRegistration.validatePassword ( "India@2020" );
        Assert.assertTrue ( result );
    }

    @Test
    public void whenGiven_PasswordLessThanEightCharacters_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePassword ( "India@6" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_PasswordWithoutCapitalLetter_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePassword ( "india@2020" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_PasswordWithoutNumber_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePassword ( "India@oooo" );
        Assert.assertFalse ( result );
    }

    @Test
    public void whenGiven_PasswordWithoutSpecialCharater_ShouldReturn_False ()
    {
        boolean result = UserRegistration.validatePassword ( "India2020" );
        Assert.assertFalse ( result );
    }

}
