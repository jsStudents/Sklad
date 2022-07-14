import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.Fidelity;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTest {

    @Test
    void initialArray() {
        File file = new File("workers.bin");
        int i = 0;
        while (file.canWrite()) {
            System.out.println(i);
            i++;
        }
    }
}