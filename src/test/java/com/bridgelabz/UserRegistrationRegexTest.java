package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationRegexTest {
    static UserRegistrationRegex userRegistration;

    @BeforeAll
    public static void initialize() {
        userRegistration = new UserRegistrationRegex();
    }

    @Test
    public void givenFirstName_WhenValid_ShouldReturnsTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.checkFirstName("Surabhi");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenInValid_ShouldThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class, ()-> userRegistration.checkFirstName("surabhi"));
    }

    @Test
    public void givenLastName_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.checkLastName("PQR");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class, ()-> userRegistration.checkLastName("pq"));
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkEmail("xyz123@gmail.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkEmail("Xyz.co.in"));
    }

    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkMobileNo("91 8695462369");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkMobileNo("8659421369"));
    }

    @Test
    public void givenPasswordRule1_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkPasswordRule1("abc@xyz123");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule1_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkPasswordRule1("abc@123"));
    }

    @Test
    public void givenPasswordRule2_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkPasswordRule2("Abc@1234");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule2_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkPasswordRule2("abc@1234"));
    }

    @Test
    public void givenPasswordRule3_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkPasswordRule3("xyz@abc1.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule3_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkPasswordRule3("xyz@abcd"));
    }

    @Test
    public void givenPasswordRule4_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.checkPasswordRule4("xyz@1234");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule4_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkPasswordRule4("xyz123ab"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@yahoo.com" ,"abc-100@yahoo.com" ,"abc.100@yahoo.com" , "abc111@abc.com" ,"abc-100@abc.net" , "abc.100@abc.com.au" , "abc@1.com"})
    public void givenEmail_WhenValid_ShouldReturnTrue(String email) throws InvalidUserDetailsException {
        Assertions.assertTrue(userRegistration.checkEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com",  "abc@gmail.com.1a"})
    public void givenEmail_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException(String email) {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.checkEmail(email));
    }
}
