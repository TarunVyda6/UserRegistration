package com.userregistration;

public class UserDetailsException extends Exception
{
    enum ExceptionType
    {
        NULL, INVALID;
    }

    ExceptionType exceptionType;

    public UserDetailsException ( ExceptionType exceptionType, String message )
    {
        super ( message );
        this.exceptionType = exceptionType;
    }
}
