package com.example.laurel.fortuneteller;

import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    private static final String FILENAME = "emails.txt";

    public static boolean tryWriteLine(String email, String name)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        boolean success = false;

        try {
            File file = new File(Environment.getExternalStorageDirectory(), FILENAME);

            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(name);
            bw.write(",");
            bw.write(email);
            bw.write("\n");

            success = true;

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
            return success;
        }
    }
}
