import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class DateTimeApi {
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);

        LocalDate today = LocalDate.now(); 
        System.out.println("Date: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());

       
        System.out.print("Enter your birth date: ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        int age = Period.between(birthDate, today).getYears();
        System.out.println("You are " + age + " years old.");
        System.out.println();

    
        System.out.print("Enter your birthday: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());

        LocalDate nextBirthday = birthday.withYear(today.getYear());
        
        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long daysUntil = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until your next birthday: " + daysUntil);

        sc.close();




    }
    
}
