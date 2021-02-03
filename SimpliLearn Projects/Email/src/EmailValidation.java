import java.util.Scanner;

public class EmailValidation {

    public static void main(String[] args) {
        //Reading String from user
        System.out.println("Enter email address: ");
        Scanner sc = new Scanner(System.in);
        String e_mail = sc.nextLine();
        //Regular expression
        String regex = "^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})?$";
        boolean result = e_mail.matches(regex);
        if(result) {
            System.out.println("Valid match");
        }else {
            System.out.println("Invalid match");
        }
    }
}