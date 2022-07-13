import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int version;
        System.out.println("Version: ");
        version = Integer.parseInt(General.scanner.nextLine());
        ArrayList<Workers> arrayWorkers = (version > 0) ? General.initialArray() : new ArrayList<>();
        General.general(arrayWorkers);
    }
}
