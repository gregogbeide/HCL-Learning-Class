package org.example.virtualkey.services;

import java.io.File;
import org.example.virtualkey.entities.Directory;

public class DirectoryService {

    private static Directory fileDirectory = new Directory();

 
    public static void PrintFiles() {

        for (String file : DirectoryService.getFileDirectory().getFiles()){
            System.out.println(file);
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryService.fileDirectory = fileDirectory;
    }
    
    public static boolean addFile(String fileName){
        File newFile = new File(fileName);
        boolean result = false;
        if(fileDirectory.searchFile(newFile.getName()) != null)
            System.out.println("The File already exist in the current Directory.\n");
        else if(newFile.exists()){
            result = fileDirectory.addFile(newFile);
        }else{
            System.out.println("File not Found.\n");
        }
        return result;
    }
    
    public static boolean deleteFile(String fileName){
        return fileDirectory.deleteFile(fileName);
    }
    
    public static File searchFile(String fileName){
        return fileDirectory.searchFile(fileName);
    }
    


}