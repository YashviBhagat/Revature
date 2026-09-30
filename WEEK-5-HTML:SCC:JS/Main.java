import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine().toLowerCase().replaceAll("\\s","");
        //char[] t1 = text.toCharArray();
        boolean isPangram = true;
        for(char c = 'a';c<='z';c++){
            if (! text.contains(String.valueOf(c))){
                isPangram = false;
                break;
            }
            
        }
        System.out.print(isPangram);
        sc.close();
    }
    
}
