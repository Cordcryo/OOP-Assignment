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
            } else if (input.equals("login")) {
                login(scanner); // Pass Scanner object to the login method
            } else {
                System.out.println("Invalid input. Please try again");
            }
        }
        scanner.close();
    }

    private static void login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (authorization(username, password)) {
            System.out.println("Login Successful!");
            String role = getRole(username);
            System.out.println("You are logged in as " + role);
            if (role.equals("admin")) {
                Admin admin = new Admin(); // Initialize Admin class instance
                admin.runAdminFunctions(); // Call admin functions
            } else if (role.equals("user")){
                User user = new User();
                Admin admin = new Admin();
                user.start(admin); // Call userTask with Admin object
            }
        } else {
            System.out.println("Invalid username or password. Try again!");
        }
    }

    private static boolean authorization(String username, String password) {
        return (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD))
                || (username.equals(USER_USERNAME) && password.equals(USER_PASSWORD));
    }

    private static String getRole(String username) {
        return username.equals(ADMIN_USERNAME) ? "admin" : "user";
    }
}