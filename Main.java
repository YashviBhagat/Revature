// // Definition of the Person class
// class Person {
//     String name;
// }

// // The main class that houses the execution logic
// public class Main {
//     public static void main(String[] args) {
        
//         // 1. Reference Copy Example
//         Person a = new Person();
//         a.name = "Alice";

//         Person b = a; 
//         System.out.println(a == b); // Prints true (both variables point to the exact same object)

//         // 2. Separate Objects Example
//         Person c = new Person(); 
//         Person d = new Person(); 
        
//         System.out.println(c == d);       // Prints false (they point to different memory addresses)
//         System.out.println(c.equals(d)); // Prints false (default .equals() behaves like ==)
//     }
// }

public class Main{
    public static void main(String[] args) {
        byte b = 127;
        int a  = 2555;
        b = (byte) a; 
        System.out.println(b);
        
    }
}