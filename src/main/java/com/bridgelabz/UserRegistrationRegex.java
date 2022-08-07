package com.bridgelabz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationRegex {
    public static void main(String[] args) {
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
    }

    public void checkFirstName(String firstName) {
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        Matcher match = pattern.matcher(firstName);
        if (match.matches())
            System.out.println("First name is Valid");
        else
            System.out.println("First name is InValid");
    }

    public void checkLastName(String lastName) {
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        Matcher match = pattern.matcher(lastName);
        if (match.matches())
            System.out.println("Last name is Valid");
        else
            System.out.println("Last name is InValid");
    }

    public void checkEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.][a-zA-Z]{2,4})([.][a-zA-Z]{2})*$");
        Matcher match = pattern.matcher(email);
        if (match.matches())
            System.out.println("Email is Valid");
        else
            System.out.println("Email is InValid");
    }

    public void checkMobileNo(String mobileNo) {
        Pattern pattern = Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        Matcher match = pattern.matcher(mobileNo);
        if (match.matches())
            System.out.println("Mobile number is Valid");
        else
            System.out.println("Mobile number is InValid");
    }

    public void checkPasswordRule1(String passwordRule1) {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z@!+_.-]{8,}");
        Matcher match = pattern.matcher(passwordRule1);
        if (match.matches())
            System.out.println("Valid");
        else
            System.out.println("Password must have 8 character");
    }

    public void checkPasswordRule2(String passwordRule2) {
        Pattern pattern = Pattern.compile("(?=.*[A-Z])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule2);
        if (match.matches())
            System.out.println("Valid");
        else
            System.out.println("Password must have atleast one uppercase letter");
    }

    public void checkPasswordRule3(String passwordRule3) {
        Pattern pattern = Pattern.compile("(?=.*[0-9])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule3);
        if (match.matches())
            System.out.println("Valid");
        else
            System.out.println("Password must have atleast one numeric number");
    }
}
