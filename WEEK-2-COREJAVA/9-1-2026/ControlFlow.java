/*Write a Java program to evaluate a student's performance using if-else and else-if statements.

You are given the following:
An integer variable score = 75
A character variable grade = 'B’

Your task is to:
Use if-else to check if the student passed or failed.
A score of 50 or above is considered a pass.
Print "Passed" or "Failed" accordingly.
Use else-if conditions to assign and print a grade based on the score:
A for 90 and above
B for 75 to 89
C for 60 to 74
D for below 60
Use System.out.println() to clearly display the output.
 */
public class ControlFlow {
    public static void main(String[] args) {
        int score = 75;
        if (score >= 50){
            System.out.println("Pass");
        }
        else{
            System.out.println("failed");
        }

       if(score >= 90){
            System.out.println("Grade: A");
       } 
       else if(score >= 75 && score <= 89){
            System.out.println("Grade: B");
       }
       else if(score >= 60 && score <= 75){
            System.out.println("Grade: C");
       }
       else{
            System.out.println("Grade: D");
       }
    }
    
}
