
// Abstraction

/*abstract class Shape{
    String color;

    //abstract methods
    abstract double area();
    public abstract String toString();

    //Constructor
    public Shape(String color){
        System.out.println("Shape Constructor called");
        this.color = color;
    }

    //this is a concrete method
    public String getColor(){
        return color;
    }

 }

class Circle extends Shape{
    double radius;
    public Circle(String color, double radius){
        //calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;

    }
    @Override
    double area(){
        return Math.PI * Math.pow(radius, 2);
        
    }
    @Override
    public String toString(){
        return "circle color is" + super.getColor() + "and area is:" + area();

    }
}

class Rectangle extends Shape{
    double length;
    double width;
    public Rectangle(String color, double length, double width){
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }
    @Override
    double area(){
        return length * width;
        
    }
    @Override
    public String toString(){
        return "Rectangle  color is" + super.getColor() + "and area is:" + area();
}
}

class Triangle extends Shape{
    double height;
    double base;
    public Triangle(String color, double height, double base){
        super(color);
        System.out.println("Triangle constructor called");
        this.height = height;
        this.base = base;
    }
    @Override
    double area(){
        return 0.5 * height * base;
        
    }
    @Override
    public String toString(){
        return "Triangle  color is " + super.getColor() + "and area is: " + area();
}
}


public interface Oops {
    public static void main(String[] args){
        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow",2,4);
        Shape s3 = new Triangle("Blue",2,6);


        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());

    }
    
}*/

// Encapsulation

class EmployeeCount{
    private int numOfEmployees = 0;
    public void setNumberOfEmployees(int count){
        numOfEmployees = count;
    }
    public int getNumberOfEmployees()
    {
        return numOfEmployees;
    }
    public int Payroll(int AverageSalary){
        return numOfEmployees * AverageSalary; 
    }
}

/*Add a public method called Payroll that:

Takes as input an int called AverageSalary.
Returns an int value TotalPayroll calculated as numOfEmployees multiplied by AverageSalary. */


public class Oops{
    public static void main(String[] args){
        EmployeeCount obj = new EmployeeCount();
        int averageSalary = 56000;
        obj.setNumberOfEmployees(786);
       
        System.out.println("Number of Employees:" + obj.getNumberOfEmployees());
        System.out.println("Total Payroll: " + obj.Payroll(averageSalary));
    }
}
