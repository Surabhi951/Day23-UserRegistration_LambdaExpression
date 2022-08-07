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
}
