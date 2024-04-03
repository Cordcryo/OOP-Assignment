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
        System.out.println("Welcome User");
        // Add the logic to handle user tasks

        // Example: Display a simple message
        System.out.println("You are in the user area.");
    }

    // Add getter and setter for Admin class instance
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    // Add authorization method
    private static boolean authorization(String username, String password) {
        return (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD))
                || (username.equals(USER_USERNAME) && password.equals(USER_PASSWORD));
    }

    // Add method to getRole
    private static String getRole(String username) {
        return username.equals(ADMIN_USERNAME) ? "admin" : "user";
    }