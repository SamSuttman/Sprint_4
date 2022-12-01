package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    public FileManager() {
    }

    public String getTextFromFile(String pathname) throws FileNotFoundException {
        String text = "";
        Scanner s = new Scanner(new File(String.format("./src/resources/%s.txt",pathname)));
        while (s.hasNextLine()){
            text += s.nextLine() + "\n";
        }
        return text;
    }

    public void writeTextToFile(String outFileName, String text) throws IOException {
        String filePath = String.format("./src/resources/out/%s.txt",outFileName);
        System.out.println(filePath);
        File myObj = new File(filePath);
        FileWriter myWriter = new FileWriter(myObj.getPath());
        myWriter.write(text);
        myWriter.close();
    }
}

//    After the FormLetterService updates the template string to the final result,
//        your FileManager need to write that data exactly to the
//        output file path: src/resources/out/{filename}.txt.