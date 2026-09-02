/*Write a Java program that prints the numbers from 1 to 5 using three different loop types:
for loop
while loop
do-while loop
Each loop should run independently and print its result on a single line, clearly labeled. Numbers should be printed with spaces between them and no trailing space at the end.
 */
public class Loops {
    public static void main(String[] args) {
        // FOR LOOP
        System.out.print("For loop: ");
        for(int i=1; i <= 5; i++){
            System.out.print(i + " ");
        }
        // MOVE TO NEXT LINE
        System.out.println();

        // WHILE LOOP
        int j = 1;
        System.out.print("While Loop: ");
        while(j <= 5){
            System.out.print(j + " ");
            j++;

        }
        // MOVE TO NEXT LINE DO WHILE LOOP
        System.out.println();

        //DO WHILE LOOP
        int k = 0;
        System.out.print("Do While loop: ");
        do{
            k++;
            System.out.print(k + " ");
        }
        while(k < 5);
    }
    
}
