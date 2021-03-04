package org.example.virtualkey.screens;

import org.example.virtualkey.services.DirectoryService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.example.virtualkey.services.ScreenService;

public class WelcomeScreen implements Screen {

    private final String welcomeText = "Welcome to VirtualKey!";
    private final String developerText = "Developer: Greg Ogbeide";
    private final ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    @Override
    public void Show(){
        System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("Directory Location: " + DirectoryService.getFileDirectory().getRootDirectoryAsFile().getAbsolutePath());
        System.out.println("\n");
        
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
    public void NavigateOption(int option){
        
        switch(option) {

            case 1: // Show Files
                this.ShowFiles();
                this.Show();
                break;
            case 2: // Show Submenu

                ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                break;
             case 3: // close application
                closeApp();
                break;
            default:
                System.out.println("Invalid Option. Please try again\n");
                this.Show();
                break;

        }

    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
        System.out.println("\nDirectory Listing");
        DirectoryService.PrintFiles();
        System.out.println("\n");
    }
    
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
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