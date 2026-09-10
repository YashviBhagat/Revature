/*Welcome to my REPL App!
> help
Available commands:
  add
  subtract
  multiply
  divide
  random
  reverse
  quit
> add
First number: 10
Second number: 25
Result: 35
> reverse
Enter text: hello world
dlrow olleh
> random
Minimum: 1
Maximum: 100
Random number: 73
> quit
Goodbye! */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class REPLAPP{
  public static void main (String[] args){
    System.out.println("Welcome to my REPL App!");
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;
    while(isRunning){
      System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Division\n5.random\n6. Reverse String\n7. Quit");
      System.out.println("Press Number: ");
      int n = sc.nextInt();
      /*if (n == 1 || n == 2 || n == 3 || n == 4){
        System.out.println("First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Second number: ");
        int num2 = sc.nextInt();

      }*/
      // option 1 
      if (n == 1){
        System.out.println("First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Second number: ");
        int num2 = sc.nextInt();
        int add = num1 + num2;
        System.out.println("ADD: " + add);
      }
      //  option 2
      else if (n == 2){
        System.out.println("First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Second number: ");
        int num2 = sc.nextInt();
        int sub = num1 - num2;
        System.out.println("Subtraction: " + sub);

      }
      //option 3
      else if (n == 3){
        System.out.println("First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Second number: ");
        int num2 = sc.nextInt();
        int mul = num1 * num2;
        System.out.println("Multiplication: " + mul);

      }
      // option 4
      else if (n == 4){
        System.out.println("First Number: ");
        int num1 = sc.nextInt();
        System.out.println("Second number: ");
        int num2 = sc.nextInt();
        if (num2 == 0){
          System.out.println("Zero division not possible!!");
        }
        else{
        int div = num1 / num2;
        System.out.println("Division: " + div);
        }
      }
      // Option 5
      else if (n == 5){
        System.out.println("Minimum Number: ");
        int min = sc.nextInt();
        System.out.println("Maximum Number: ");
        int max = sc.nextInt();
        
        int randomNum = ThreadLocalRandom.current().nextInt(min,max + 1);
        System.out.println("Random number: " + randomNum);

      }
      // Option 6:
      else if (n == 6){
        System.out.println("Enter the string: ");
        sc.nextLine();
        String str = sc.nextLine();
        String rev = "";
        for(int i = str.length() - 1;i >= 0; i--){
          rev =  rev + str.charAt(i);
        }
        System.out.println("Reversed String: " + rev);

      }
      // option 7
      else if(n == 7){
        System.out.println("Goodbye!");
        isRunning = false;
        }
      else {
        System.out.println("Invalid option. Please choose 1-7.");
        }
      }
    
    

    
  sc.close();
  }

}
