package unisex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UnisexBathroom bathroom = new UnisexBathroom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter gender (M/F) or 'exit' to quit: QT ");
            String gender = scanner.nextLine();

            if ("QT".equalsIgnoreCase(gender)) {
                break;
            }

            System.out.print("Enter action (enter E/exit Q): ");
            String action = scanner.nextLine();

            if ("E".equalsIgnoreCase(action)) {
                bathroom.enterBathroom(gender);
            } else if ("Q".equalsIgnoreCase(action)) {
                bathroom.exitBathroom(gender);
            } else {
                System.out.println("Invalid action.");
            }
        }

        scanner.close();
    }
}