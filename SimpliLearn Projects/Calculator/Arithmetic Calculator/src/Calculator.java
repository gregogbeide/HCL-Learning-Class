import java.util.Scanner;

public class Calculator {

public static void main (String [] args ) {

    Scanner sc = new Scanner(System.in);
    System.out.println("please input an operation");
    String operation = sc.next();
    System.out.println("please input your first number");
    double x = sc.nextDouble();
    System.out.println("please input your second number");
    double y = sc.nextDouble();

    switch (operation) {
        case "add":
            System.out.println(x + " + " + y + " = " + add(x, y));
            break;
        case "subtract":
            System.out.println(x + " - " + y + " = " + subtract(x, y));
            break;
        case "multiply":
            System.out.println(x + " * " + y + " = " + multiply(x, y));
            break;
        case "divide":
            System.out.println(x + " / " + y + " = " + divide(x, y));
            break;
    }

}

    public static double add(double x, double y){
        return x+y; }

    public static double subtract(double x, double y){
        return x-y; }

    public static double multiply(double x, double y){
        return x*y; }

    public static double divide(double x, double y){
        return x/y; }

}



