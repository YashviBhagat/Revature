/*
3. Word Analyzer
Ask the user to enter a word and output the following (example):
Characters: 17
Vowels: 5
Consonants: 10
Digits: 0
Spaces: 2 */

import java.util.Scanner;
public class WordAnalyzer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Text: ");
        String text = sc.nextLine();
        text = text.toLowerCase();

        
        int vowels = 0;
        int consonant = 0;
        int digit = 0;
        int space = 0;

        for (int i = 0; i < text.length(); i++ ){
            char ch = text.charAt(i);

            if (Character.isLetter(ch)){
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels += 1;
                }
                else{
                    consonant += 1;
                }

            }
            if(Character.isDigit(ch)){
                digit += 1;
            }
            if(Character.isWhitespace(ch)){
                space += 1;
            }   
        }
        System.out.println("Character: " + text.length());
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonant);
        System.out.println("Space: " + space);
        System.out.println("Digits: " + digit);



        sc.close();
    }
    
}
