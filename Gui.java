package IIMScollege;

import java.util.Scanner;

public class Gui {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Welcome to the Climate Change Application!");
            System.out.println("Enter 'login' to access the application or 'exit' to quit:");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("exit")) {
                break;
            }else{
            login(scanner); // Pass Scanner object to the login method
                input = scanner.nextLine().toLowerCase();
            }}
        scanner.close();
    }

    // Modify the login method to accept Scanner object
    private static void login(Scanner sc) {
        System.out.print(" Enter username");
        String username = sc.next();
        System.out.print(" Enter password");
        String password = sc.next();

        if (authorization(username, password)) {
            System.out.println("Login Successful!");
            String role = getRole(username);
            System.out.println("You are logged in as " + role);
            if (role.equals("admin")) {
                // Added Admin class instance
                Admin admin = new Admin(); // Initialize Admin class instance
                adminTask(admin); // Call adminTask with Admin and Scanner objects
            } else {
                userTask(); // Call userTask with Scanner object
            }
        } else {
            System.out.println("Invalid username or password. Try again!");
        }
    }

    private static void adminTask(Admin admin) {
        System.out.println("Welcome Admin");
        admin.someAdminMethod();
    }


    private static void userTask() {
        System.out.println("Welcome User");
        // Add the logic to handle user tasks

        // Example: Display a simple message
        System.out.println("You are in the user area.");
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
}