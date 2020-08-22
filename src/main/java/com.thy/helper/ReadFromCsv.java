package com.thy.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromCsv {
    public static String readFromCsv(String path, int value, int id) {
        String record;
        String filePath = path;
        File file = new File(filePath);
        String[] array = new String[100];
        try {
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNext()) {
                String data = input.nextLine(); // Gets the whole line
                String[] values = data.split(","); // Split the line by commas
                array[i] = values[value];
                i++;
            }

            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        record = array[id];
        return record;
    }


}
