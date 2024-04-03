package IIMScollege;

import java.util.Scanner;
import java.util.List;

public class User {

    public void start(Admin admin) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome User");
        System.out.println("What would you like to view?");
        System.out.println("Enter 1 For Policy");
        System.out.println("Enter 2 For Strategies");
        System.out.println("Enter 3 For Planning");
        int a = scan.nextInt();

        switch (a) {
            case 1:
                displayPolicies(admin.getPolicies());
                break;
            case 2:
                displayStrategies(admin.getStrategies());
                break;
            case 3:
                displayPlans(admin.getPlans());
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private void displayPolicies(List<String> policies) {
        System.out.println("Current Policies:");
        for (int i = 0; i < policies.size(); i++) {
            System.out.println(i + ": " + policies.get(i));
        }
    }

    private void displayStrategies(List<String> strategies) {
        System.out.println("Current Strategies:");
        for (int i = 0; i < strategies.size(); i++) {
            System.out.println(i + ": " + strategies.get(i));
        }
    }

    private void displayPlans(List<String> plans) {
        System.out.println("Current Plans:");
        for (int i = 0; i < plans.size(); i++) {
            System.out.println(i + ": " + plans.get(i));
        }
    }
}