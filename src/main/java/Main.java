import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File file = new File("workers.bin");
        ArrayList<Workers> arrayWorkers = (file.length() == 0 ? new ArrayList<>() : General.initialArray());
        General.general(arrayWorkers);
    }
}
