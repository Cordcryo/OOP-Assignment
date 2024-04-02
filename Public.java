package IIMScollege;
import java.util.Scanner;
class Public {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome User");
            System.out.println("What would you like to view?");
            System.out.println("Enter 1 For Strategy");
            System.out.println("Enter 2 For Policy");
            System.out.println("Enter 3 For Planning");
            int a = scan.nextInt();
            if (a == 1) {
                System.out.println("Strategy");
            } else if (a == 2) {
                System.out.println("Policy");
            } else if (a == 3) {
                System.out.println("Planning");
        }
    }
}