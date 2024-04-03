package IIMScollege;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    private List<String> strategies;
    private List<String> policies;
    private List<String> plans;

    public Admin() {
        // Initialize lists
        strategies = new ArrayList<>();
        policies = new ArrayList<>();
        plans = new ArrayList<>();

        // Add some default data for demonstration purposes
        strategies.add("Strategy 1");
        strategies.add("Strategy 2");
        strategies.add("Strategy 3");

        policies.add("SDG 13 Policy 1");
        policies.add("SDG 13 Policy 2");
        policies.add("SDG 13 Policy 3");

        plans.add("Plan 1");
        plans.add("Plan 2");
        plans.add("Plan 3");
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

    // Method to add a new policy
    public void addPolicy(String newPolicy) {
        policies.add(newPolicy);
        System.out.println("New policy added: " + newPolicy);
    }

    // Method to edit an existing policy
    public void editPolicy(int index, String updatedPolicy) {
        if (index >= 0 && index < policies.size()) {
            policies.set(index, updatedPolicy);
            System.out.println("Policy updated at index " + index + ": " + updatedPolicy);
        } else {
            System.out.println("Invalid index for editing policy");
        }
    }

    // Method to delete an existing policy
    public void deletePolicy(int index) {
        if (index >= 0 && index < policies.size()) {
            String deletedPolicy = policies.remove(index);
            System.out.println("Policy deleted at index " + index + ": " + deletedPolicy);
        } else {
            System.out.println("Invalid index for deleting policy");
        }
    }

    // Method to display all policies
    public void displayPolicies() {
        System.out.println("Current Policies:");
        for (int i = 0; i < policies.size(); i++) {
            System.out.println(i + ": " + policies.get(i));
        }
    }

    // Method to add a new plan
    public void addPlan(String newPlan) {
        plans.add(newPlan);
        System.out.println("New plan added: " + newPlan);
    }

    // Method to edit an existing plan
    public void editPlan(int index, String updatedPlan) {
        if (index >= 0 && index < plans.size()) {
            plans.set(index, updatedPlan);
            System.out.println("Plan updated at index " + index + ": " + updatedPlan);
        } else {
            System.out.println("Invalid index for editing plan");
        }
    }

    // Method to delete an existing plan
    public void deletePlan(int index) {
        if (index >= 0 && index < plans.size()) {
            String deletedPlan = plans.remove(index);
            System.out.println("Plan deleted at index " + index + ": " + deletedPlan);
        } else {
            System.out.println("Invalid index for deleting plan");
        }
    }

    // Method to display all plans
    public void displayPlans() {
        System.out.println("Current Plans:");
        for (int i = 0; i < plans.size(); i++) {
            System.out.println(i + ": " + plans.get(i));
        }
    }

    // Method to run admin functions
    public boolean runAdminFunctions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Read Strategy");
            System.out.println("2. Add Strategy");
            System.out.println("3. Edit Strategy");
            System.out.println("4. Delete Strategy");
            System.out.println("5. Read Policy");
            System.out.println("6. Add Policy");
            System.out.println("7. Edit Policy");
            System.out.println("8. Delete Policy");
            System.out.println("9. Read Plan");
            System.out.println("10. Add Plan");
            System.out.println("11. Edit Plan");
            System.out.println("12. Delete Plan");
            System.out.println("13. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid option number.");
                continue;
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
                case 5:
                    displayPolicies();
                    break;
                case 6:
                    System.out.println("Enter the new policy:");
                    String newPolicy = scanner.nextLine();
                    addPolicy(newPolicy);
                    break;
                case 7:
                    System.out.println("Enter the index of the policy to edit:");
                    int policyIndexToUpdate = getValidIndex(scanner);
                    if (policyIndexToUpdate != -1) {
                        System.out.println("Enter the updated policy:");
                        String updatedPolicy = scanner.nextLine();
                        editPolicy(policyIndexToUpdate, updatedPolicy);
                    }
                    break;
                case 8:
                    System.out.println("Enter the index of the policy to delete:");
                    int policyIndexToDelete = getValidIndex(scanner);
                    if (policyIndexToDelete != -1) {
                        deletePolicy(policyIndexToDelete);
                    }
                    break;
                case 9:
                    displayPlans();
                    break;
                case 10:
                    System.out.println("Enter the new plan:");
                    String newPlan = scanner.nextLine();
                    addPlan(newPlan);
                    break;
                case 11:
                    System.out.println("Enter the index of the plan to edit:");
                    int planIndexToUpdate = getValidIndex(scanner);
                    if (planIndexToUpdate != -1) {
                        System.out.println("Enter the updated plan:");
                        String updatedPlan = scanner.nextLine();
                        editPlan(planIndexToUpdate, updatedPlan);
                    }
                    break;
                case 12:
                    System.out.println("Enter the index of the plan to delete:");
                    int planIndexToDelete = getValidIndex(scanner);
                    if (planIndexToDelete != -1) {
                        deletePlan(planIndexToDelete);
                    }
                    break;
                case 13:
                    System.out.println("Exiting Admin functions.");
                    return true;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Method to get a valid index from the user
    private static int getValidIndex(Scanner scanner) {
        while (true) {
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 0) {
                    return index;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid index:");
            }
        }
    }

    public List<String> getStrategies() {
        return strategies;
    }

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.runAdminFunctions();
    }

    public void someAdminMethod() {

    }

    public List<String> getPlans() {
    return plans;
    }

    public List<String>getPolicies() {
    return policies;
    }
}