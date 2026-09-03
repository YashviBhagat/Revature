/*
Password Validator
Ask the user to create a password.
The password must:
Be at least 8 characters
Contain at least one uppercase letter
Contain at least one lowercase letter
Contain at least one number
Output:
Password accepted!
OR (based on failed requirements)
Password rejected:
- Must contain an uppercase letter
- Must contain a number */

import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        // user Enter password
        System.out.println("Enter Password: ");
        String pass = sc.nextLine();
        int countUpper = 0;
        int countLower = 0;
        int countNum = 0;
        
        for (int i=0; i < pass.length();i++){
                if (Character.isUpperCase(pass.charAt(i))) countUpper++;
                if (Character.isLowerCase(pass.charAt(i))) countLower++;
                if (Character.isDigit(pass.charAt(i)))     countNum++;


                
        }


        if (pass.length() >= 8 && countUpper >= 1 && countLower >= 1 && countNum >= 1){
            System.out.println("Password Approved!!");

        }
        else{
            System.out.println("Password Rejected!!");
            if(pass.length() < 8){
                System.out.println("- Must be at least 8 characters");
            }
            if(countUpper == 0){
                System.out.println("Must Contain Uppercase Letter");
            }
            if(countLower == 0){
                System.out.println("Must Contain Lowercase Letter");
            }
            if(countNum == 0){
                System.out.println("Must Contain Numbers");

            }

        }
        
        sc.close();


    }
    
}
