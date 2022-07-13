import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class General {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Workers> initialArray() {
        ArrayList<Workers> array = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("workers.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int workersCount = ois.readInt();
            for (int i = 0; i < workersCount; i++) {
                Workers worker = (Workers) ois.readObject();
                array.add(worker);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }

    static void general(ArrayList<Workers> array) {
        int userChoice = 999;
        while (userChoice != 0) {
            System.out.println("""
                    Input command:
                        0 - exit.
                        1 - Create worker.
                        8 - Print workers.
                        9 - Save changes.""");
            userChoice = commandInput();
            switch (userChoice) {
                case 1 -> createWorker(array);
                case 8 -> printWorkers(array);
                case 9 -> saveChanges(array);
            }
        }
    }

    static int commandInput() {
        int result;
        while (true) {
            try {
                System.out.print(">>> ");
                String userInput = scanner.nextLine();
                result = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
        return result;
    }

    static void createWorker(ArrayList<Workers> array) {
        System.out.println("Input the id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Input the name: ");
        String name = scanner.nextLine();
        System.out.println("Input the position: ");
        String position = scanner.nextLine();
        System.out.println("Input salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Workers worker = new Workers(id, name, position, salary);
        array.add(worker);
        System.out.println(worker);
    }

    static void printWorkers(ArrayList<Workers> array) {
        for (Workers worker : array) {
            System.out.println(worker);
        }
    }

    static void saveChanges(ArrayList<Workers> array) {
        try {
            FileOutputStream fos = new FileOutputStream("workers.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(array.size());
            for(Workers worker : array) {
                oos.writeObject(worker);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

