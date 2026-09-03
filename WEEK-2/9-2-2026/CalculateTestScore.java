/*Ask for 5 test scores and calculate:
Total
Average
Highest Score
Lowest Score

Then assign a letter grade.

Expected Output:
If the 5 test scores entered are: 100, 90, 60, 75, 20

Then:

Total: 345
Average: 69
Highest: 100
Lowest: 20

Your values were:
100 – A
90 – A
60 – D
75 – C
20 - d
 */
import java.util.Scanner;
public class CalculateTestScore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 test Score: ");

        int[] score = new int[5];

        for(int i=0; i < score.length ;i++){
            score[i]=sc.nextInt();

        }
         // Total
        int total = 0;
        for(int i=0; i < score.length ;i++)
        {
            total = total + score[i];
        }
        System.out.println("Total: " + total);
         
        // Average
        System.out.println("Average: " + (total/5));

        // Highest Score
        int highest = score[0];
        for(int i=0; i < score.length ;i++){
            if (highest < score[i]){
                highest = score[i];
            }
        }
        System.out.println("Highest Score: " + highest);

        // Lowest Score
        int low = score[0];
        for(int i=0; i < score.length ;i++){
            if (low >  score[i]){
                low = score[i];
            }
        }
        System.out.println("lowest Score: " + low);

        System.out.println("Your values are");
        for(int i=0; i < score.length ;i++){
            if (score[i]>=90){
                System.out.println(score[i] + " -  A ");
            }
            else if(score[i] >= 75 && score[i] <= 89){
                System.out.println(score[i] + " - B ");
            }
            else if(score[i] >= 60 && score[i] <= 74){
                System.out.println(score[i] + " - C");
            }
            else{
                System.out.println(score[i] + " - D");
                } 
           }
        sc.close();
    }
    
}
