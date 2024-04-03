package IIMScollege;
import java.util.Scanner;
import java.util.ArrayList;

public class Gui {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";
    private Admin admin; // Added Admin class instance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Welcome to the Climate Change Application!");
            System.out.println("Enter 'login' to access the application or 'exit' to quit:");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("exit")) {
                break;
            }
            login(scanner); // Pass Scanner object to the login method
        }
        scanner.close();
    }

    // Modify the login method to accept Scanner object
    private static void login(Scanner sc) {
        String username = sc.next();
        String password = sc.next();

        if (authorization(username, password)) {
            System.out.println("Login Successful!");
            String role = getRole(username);
            System.out.println("You are logged in as " + role);

            if (role.equals("admin")) {
                admin = new Admin(); // Initialize Admin class instance
                adminTask(admin, sc); // Call adminTask with Admin and Scanner objects
            } else {
                userTask(sc); // Call userTask with Scanner object
            }
        } else {
            System.out.println("Invalid username or password. Try again!");
        }
    }

    // Add adminTask method
    private static void adminTask(Admin admin, Scanner sc) {
        System.out.println("Welcome Admin");
        // Add the logic to handle admin tasks

        // Example: Calling a method from the Admin class
        admin.someAdminMethod();
    }

    // Modify userTask method to accept Scanner object
    private static void userTask(Scanner sc) {
        // ...
    }

    private static void userTask() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome User");
        System.out.println("What would you like to view?");
        System.out.println("Enter 1 For Policy");
        System.out.println("Enter 2 For Strategies");
        System.out.println("Enter 3 For Planning");
        int a = scan.nextInt();
        if (a == 1) {
            // Display policy content
        } else if (a == 2) {
            // Display strategy content
        } else if (a == 3) {
            // Display planning content
        }
    }

    // Add getter and setter for Admin class instance
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}