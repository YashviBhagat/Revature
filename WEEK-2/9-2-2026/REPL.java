/* Create a small REPL application where a user can:
Check account balance (start at 0)
Deposit into their account
Withdraw from their account
Exit

You don’t need actual account functionality or to keep anything in persistence, just the basic commands
 */


import java.util.Scanner;
public class REPL {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int bal = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Press Number: ");
            int num = sc.nextInt();

            if (num == 1) {
                System.out.println("Your Account Balance: $" + bal);
            }
            else if (num == 2) {
                System.out.print("Enter the amount of deposit: ");
                int dep = sc.nextInt();
                bal = bal + dep;
                System.out.println("Your current Balance is: $" + bal);
            }
            else if (num == 3) {
                System.out.print("Enter the amount of withdraw: ");
                int withdraw = sc.nextInt();
                if (withdraw > bal) {
                    System.out.println("Insufficient funds. Your balance is: $" + bal);
                }
                else {
                    bal = bal - withdraw;
                    System.out.println("Your current Balance is: $" + bal);
                }
            }
            else if (num == 4) {
                System.out.println("Goodbye!");
                running = false;
            }
            else {
                System.out.println("Invalid option. Please choose 1-4.");
            }
        }

        sc.close();
    }
}
