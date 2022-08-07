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
    }

    public void checkFirstName(String firstName) {
        Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}");
        Matcher match = pattern.matcher(firstName);
        if (match.matches())
            System.out.println("First name is Valid");
        else
            System.out.println("First name is InValid");
    }
}
