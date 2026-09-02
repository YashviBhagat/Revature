/* Create a minimal console-style calculator in Java that uses predefined values instead of reading input from the user.
Initialize two numbers (e.g., double num1 = 7;, double num2 = 3;) and an operator (e.g., char operator = '+').
Use a while loop controlled by String again = "y". Inside the loop, perform exactly one calculation and then set again = "n" so the loop ends after the first run.
Use if-else statements to handle the operator: +, -, *, /.
For division, if num2 is 0, print Cannot divide by zero. and do not perform the division.
Print the result using the exact format:Result: <value>
After the loop ends, print a closing message:Thank you for using the calculator.
 */
public class Calculator {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 3;
        double answer = 0;
        char operator = '+';

        String again = "y";
        while (again.equals("y")){
            if (operator == '+'){
                answer = num1 + num2;
                System.out.println("Result: " + answer);
            }
            else if (operator == '-'){
                answer = num1 - num2;
                System.out.println("Result: " + answer);
            }
            else if (operator == '*'){
                answer = num1 * num2;
                System.out.println("Result: " + answer);
            }
            else if(operator == '/'){
                if (num2 == 0){
                    System.err.println("Cannot divide by zero");
                }
                else{
                    answer = num1 / num2;
                    System.out.println("Result: " + answer);
                }
            }
            again = "n"; 
        }

        System.out.println("Thank you for using the calculator.");

        
    }
    
}
