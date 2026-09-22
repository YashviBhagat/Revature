/*
Print age, height, and name

Declare and initialize the following variables:
An int variable named ’age’ with your age
A double variable named ’height’ with your height
A String variable named ’name’ with your name
Print the values in the exact following format:
Name: Alex, Age: 25, Height: 5.9
 */

public class PrintingOutput {
    public static void main(String[] args) {
        int age = 25;
        double height = 5.2;
        String name = "Yashvi";
        //System.out.println("Name: " + name + ", Age: " + age + ", Height: " + height);
        System.out.printf("Name:%s,Age:%d,Height:%.1f",name,age,height);
        
    }
}
