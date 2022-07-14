import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTest {

    @Test
    void initialArray() {
        File file = new File("workers.bin");
        System.out.println(file.length());
    }
}