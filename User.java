package IIMScollege;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class User{
    private List<String> strategies;

    // Constructor to initialize with strategies from Admin
    public User(List<String> adminStrategies) {
        this.strategies = adminStrategies;
    }

    // Method to display all strategies
    public void displayStrategies() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Read Strategies");
            System.out.println("2. Exit");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Current Strategies:");
                    for (int i = 0; i < strategies.size(); i++) {
                        System.out.println(i + ": " + strategies.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Exiting User mode.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    scanner.close();
            }
        }
    }
}

class Admin {
    private List<String> strategies;

    public Admin() {
        // Initialize strategies list
        strategies = new ArrayList<>();
        // Add some default strategies for demonstration purposes
        strategies.add("Strategy 1");
        strategies.add("Strategy 2");
        strategies.add("Strategy 3");
    }

    // Method to add a new strategy
    public void addStrategy(String newStrategy) {
        strategies.add(newStrategy);
        System.out.println("New strategy added: " + newStrategy);
    }

    // Method to edit an existing strategy
    public void editStrategy(int index, String updatedStrategy) {
        if (index >= 0 && index < strategies.size()) {
            strategies.set(index, updatedStrategy);
            System.out.println("Strategy updated at index " + index + ": " + updatedStrategy);
        } else {
            System.out.println("Invalid index for editing strategy");
        }
    }

    // Method to delete an existing strategy
    public void deleteStrategy(int index) {
        if (index >= 0 && index < strategies.size()) {
            String deletedStrategy = strategies.remove(index);
            System.out.println("Strategy deleted at index " + index + ": " + deletedStrategy);
        } else {
            System.out.println("Invalid index for deleting strategy");
        }
    }

    // Method to display all strategies
    public void displayStrategies() {
        System.out.println("Current Strategies:");
        for (int i = 0; i < strategies.size(); i++) {
            System.out.println(i + ": " + strategies.get(i));
        }
    }

    public boolean runAdminFunctions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Read Strategy");
            System.out.println("2. Add Strategy");
            System.out.println("3. Edit Strategy");
            System.out.println("4. Delete Strategy");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) {
                System.out.println("Exiting Admin functions.");
                return true; // Return true to indicate exiting
            }

            switch (choice) {
                case 1:
                    displayStrategies();
                    break;
                case 2:
                    System.out.println("Enter the new strategy:");
                    String newStrategy = scanner.nextLine();
                    addStrategy(newStrategy);
                    break;
                case 3:
                    System.out.println("Enter the index of the strategy to edit:");
                    int indexToUpdate = getValidIndex(scanner);
                    if (indexToUpdate != -1) {
                        System.out.println("Enter the updated strategy:");
                        String updatedStrategy = scanner.nextLine();
                        editStrategy(indexToUpdate, updatedStrategy);
                    }
                    break;
                case 4:
                    System.out.println("Enter the index of the strategy to delete:");
                    int indexToDelete = getValidIndex(scanner);
                    if (indexToDelete != -1) {
                        deleteStrategy(indexToDelete);
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Method to get a valid index from the user
    private static int getValidIndex(Scanner scanner) {
        while (true) {
            try {
                int index = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return index;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid index:");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    public List<String> getStrategies() {
        return strategies;
    }
}

class Console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    boolean adminExited = admin.runAdminFunctions(); // Run Admin Functions
                    if (adminExited) {
                        break; // Exit admin interface and continue to main menu
                    }
                    break;
                case 2:
                    User user = new User(admin.getStrategies()); // Run user functions
                    user.displayStrategies();
                    break;
                case 3:
                    System.out.println("Exiting Console."); // Exit to console
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}