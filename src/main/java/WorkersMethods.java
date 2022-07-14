import java.util.ArrayList;
import java.util.Scanner;

public class WorkersMethods {
    static Scanner scanner = new Scanner(System.in);
    static void createWorker(ArrayList<Workers> array) {
        System.out.println("Input the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Input the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Input the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Input the position: ");
        String position = scanner.nextLine();
        System.out.println("Input salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Workers worker = new Workers(firstName, lastName, phoneNumber, position, salary);
        array.add(worker);
        General.saveChanges(array);
    }

    static void deleteWorker(ArrayList<Workers> array) {
        System.out.println("Who do you want to remove: ");
        General.printToId(array);
        System.out.println("Input the id to remove worker: ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        array.removeIf(nextWorker -> array.indexOf(nextWorker) == deleteId - 1);
        General.saveChanges(array);
    }

    static void changeWorker(ArrayList<Workers> array) {
        System.out.println("Who do you want to change");
        General.printToId(array);
        System.out.println("Input the id to change worker");
        int changeWorker = Integer.parseInt(scanner.nextLine());
        Workers worker = array.get(changeWorker - 1);
        int choose = 999;
        while (choose != 0) {
            System.out.println("Choose the value to change:");
            System.out.printf("""
                            Input 0 to exit
                            1 - First name (%s)
                            2 - Last name (%s)
                            3 - Phone number (%s)
                            4 - Position (%s)
                            5 - Salary (%d)
                            """,            worker.getFirstName(),
                    worker.getLastName(),
                    worker.getPhoneNumber(),
                    worker.getPosition(),
                    worker.getSalary());
            System.out.print(">>> ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("New value for first name: ");
                    String value = scanner.nextLine();
                    worker.setFirstName(value);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("New value for last name: ");
                    String value = scanner.nextLine();
                    worker.setLastName(value);
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("New value for phone number: ");
                    String value = scanner.nextLine();
                    worker.setPhoneNumber(value);
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("New value for position: ");
                    String value = scanner.nextLine();
                    worker.setPosition(value);
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("New value for salary: ");
                    int value = Integer.parseInt(scanner.nextLine());
                    worker.setSalary(value);
                    System.out.println();
                }
            }
        }
        General.saveChanges(array);
    }

    static void printWorkers(ArrayList<Workers> array) {
        for (Workers worker : array) {
            System.out.println(worker);
        }
    }
}
