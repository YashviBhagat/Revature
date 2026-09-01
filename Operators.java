/*Declare two integer variables a = 20 and b = 10.
Perform the following operations:
Add, subtract, multiply, and divide a and b
Compare if a is greater than b and store the result in a boolean variable
Check if a > b and b > 0 using a logical operator and store the result
Print the results of all operations using System.out.println() in the specified format.*/

public class Operators {
    public static void main(String[] args){
        int a = 20;
        int b = 10;
        System.out.println("Addition: " + ( a + b));
        System.out.println("Subtraction: " + ( a - b));
        System.out.println("Multiplication: " + ( a * b));
        System.out.println("Division: " + ( a / b));
        boolean c = a > b;
        System.out.println("Is a greater than b?:" +  c);
        boolean d = ((a>b) && (b>0));
        System.out.println("Is a > b and b > 0? " + d);

    }
}
