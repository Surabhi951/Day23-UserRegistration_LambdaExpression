package com.bridgelabz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationRegex {
    public static void main(String[] args) throws InvalidUserDetailsException {
        UserRegistrationRegex userRegistrationRegex = new UserRegistrationRegex();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        String firstName = sc.next();
        userRegistrationRegex.checkFirstName(firstName);

        System.out.println("Enter last name");
        String lastName = sc.next();
        userRegistrationRegex.checkLastName(lastName);

        System.out.println("Enter email");
        String email = sc.next();
        userRegistrationRegex.checkEmail(email);

        System.out.println("Enter mobile number");
        sc.nextLine();
        String mobileNo = sc.nextLine();
        userRegistrationRegex.checkMobileNo(mobileNo);

        System.out.println("Enter password minimum 8 character");
        String passwordRule1 = sc.next();
        userRegistrationRegex.checkPasswordRule1(passwordRule1);

        System.out.println("Enter atleast one uppercase letter in password");
        String passwordRule2 = sc.next();
        userRegistrationRegex.checkPasswordRule2(passwordRule2);

        System.out.println("Enter atleast one numeric number in password");
        String passwordRule3 = sc.next();
        userRegistrationRegex.checkPasswordRule3(passwordRule3);

        System.out.println("Enter exactly one special character in password");
        String passwordRule4 = sc.next();
        userRegistrationRegex.checkPasswordRule4(passwordRule4);
    }

    public boolean checkFirstName(String firstName) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        Matcher match = pattern.matcher(firstName);
        if (match.matches()) {
            System.out.println("First name is valid");
        }
        else{
            throw new InvalidUserDetailsException("First name is Invalid");
        }
        return match.matches();

    }
    public boolean checkLastName(String lastName) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        Matcher match = pattern.matcher(lastName);
        if (match.matches())
            System.out.println("Last name is Valid");
        else
            throw new InvalidUserDetailsException("Last name is InValid");
        return match.matches();
    }

    public boolean checkEmail(String email) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,4})([.][a-zA-Z]{2})*$");
        Matcher match = pattern.matcher(email);
        if (match.matches())
            System.out.println("Email is Valid");
        else
            throw new InvalidUserDetailsException("Email is InValid");
        return match.matches();
    }

    public boolean checkMobileNo(String mobileNo) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        Matcher match = pattern.matcher(mobileNo);
        if (match.matches())
            System.out.println("Mobile number is Valid");
        else
            throw new InvalidUserDetailsException("Mobile number is InValid");
        return match.matches();
    }

    public boolean checkPasswordRule1(String passwordRule1) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("[0-9a-zA-Z@!+_.-]{8,}");
        Matcher match = pattern.matcher(passwordRule1);
        if (match.matches())
            System.out.println("Valid");
        else
            throw new InvalidUserDetailsException("Password must have 8 character");
        return match.matches();
    }

    public boolean checkPasswordRule2(String passwordRule2) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("(?=.*[A-Z])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule2);
        if (match.matches())
            System.out.println("Valid");
        else
            throw new InvalidUserDetailsException("Password must have atleast one uppercase letter");
        return match.matches();
    }

    public boolean checkPasswordRule3(String passwordRule3) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("(?=.*[0-9])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule3);
        if (match.matches())
            System.out.println("Valid");
        else
            throw new InvalidUserDetailsException("Password must have atleast one numeric number");
        return match.matches();
    }

    public boolean checkPasswordRule4(String passwordRule4) throws InvalidUserDetailsException{
        Pattern pattern = Pattern.compile("(?=.*[+._@!-])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule4);
        if (match.matches())
            System.out.println("Valid");
        else
            throw new InvalidUserDetailsException("Password must has exactly one special character");
        return match.matches();
    }

}
