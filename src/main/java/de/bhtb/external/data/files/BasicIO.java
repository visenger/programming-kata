package de.bhtb.external.data.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by visenger on 26/03/17.
 */
public class BasicIO {

    public static void main(String... args) throws IOException {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("src/main/resources/sonne.txt");
            fos = new FileOutputStream("src/main/resources/output.txt");
            int c;

            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }
}
