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
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                array.add((Workers) ois.readObject());
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
                        2 - Delete worker.
                        3 - Change worker.
                        8 - Print workers.
                        9 - Save changes.""");
            userChoice = commandInput();
            switch (userChoice) {
                case 1 -> WorkersMethods.createWorker(array);
                case 2 -> WorkersMethods.deleteWorker(array);
                case 3 -> WorkersMethods.changeWorker(array);
                case 8 -> WorkersMethods.printWorkers(array);
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

    static void printToId(ArrayList<Workers> array) {
        for (Workers worker : array) {
            System.out.printf("Id - %d, Last name - %s\n", array.indexOf(worker) + 1, worker.getLastName());
        }
    }

    static void saveChanges(ArrayList<Workers> array) {
        try {
            FileOutputStream fos = new FileOutputStream("workers.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(array.size());
            for (Workers worker : array) {
                oos.writeObject(worker);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

