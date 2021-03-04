package org.example.virtualkey.screens;


import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;


public class FileOptionsScreen implements Screen {

    private final ArrayList<String> options = new ArrayList<>();



    public FileOptionsScreen() {
        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Main Menu");
        options.add("5. Quit");

    }

    @Override
    public void Show(){
        
        System.out.println("\nFile Menu Options");

        for (String s : options)  {
            System.out.println(s);
        }
        System.out.println("\nEnter your choice: ");
        GetUserInput();
    }

    @Override
    public void GetUserInput(){
       int selectedOption = this.getOption();
       this.NavigateOption(selectedOption);  
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Add File
                this.AddFile();
                this.Show();
                break;
            case 2: // delete File
                this.deleteFile();
                this.Show();
                break;
            case 3: // search File
                this.searchFile();
                this.Show();
                break;
            case 4: // welcome screen
                ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
                ScreenService.getCurrentScreen().Show();                
                break;
            case 5: // close application
                closeApp();
                break;
            default:
                System.out.println("Invalid Option");
                 this.Show();
                break;

        }

    }
    
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
        System.exit(0);
    }

    public void AddFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("You are adding a file named: " + fileName);        
        boolean result = DirectoryService.addFile(fileName);
        if(result)
            System.out.println("File " + fileName + " added.");
        
    }
    
    public void deleteFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("\nYou are deleting a file named: " + fileName);        
        boolean result = DirectoryService.deleteFile(fileName);
        if(result)
            System.out.println("File " + fileName + " deleted.\n");
        else
            System.out.println("File " + fileName + " not deleted.\n");
    }
    
     public void searchFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("\nYou are searching for a file named: " + fileName);        
        File result = DirectoryService.searchFile(fileName);
        if(result != null)
            System.out.println("File " + fileName + " found.\n");
        else
            System.out.println("File " + fileName + " not found.\n");
    }

    private String getInputString(){

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption(){
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }

}