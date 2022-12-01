package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(String fileName,Employee employee) throws IOException {
        String template = fileManager.getTextFromFile("LetterTemplate");
        String templateWithCompanyName = template.replace("[company name]",employee.getCompany().getCompanyname());
        String templateWithFullName = templateWithCompanyName.replace("[fullname]",employee.getFirstname() +" "+ employee.getLastname());
        String templateWithStartDate = templateWithFullName.replace("[startdate]",employee.getStartdate());
        String templateWithStartingSalary = templateWithStartDate.replace("[startingsalary]",String.valueOf(employee.getSalary()));
        String templateWithCompanyStartTime = templateWithStartingSalary.replace("[company starttime]",employee.getCompany().getCompanyname());
       fileManager.writeTextToFile(fileName, templateWithCompanyStartTime);




//        This class has a single method generateWelcomeLetter which takes an Employee as input.
//        This method needs to request the template data from
//         LetterTemplate.txt in the resources directory, from the FileManager.
//        Then it should use the String .replace() method to
//         replace any []ed text with its correct value.
//        Finally, the finalized String should be
//         passed to the FileManagers writeTextToFile method.
//        Implement the writeTextToFile method
//        After the FormLetterService updates the template string to
//        the final result, your FileManager need to write that data exactly to the
//        output file path: src/resources/out/{filename}.txt.
//        TODO: Get template text from resources
//        TODO: Replace []ed text with correct info
//        TODO: Write finalized String to file
    }
}
