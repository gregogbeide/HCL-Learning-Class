package org.example.virtualkey.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;


public class Directory {
      
    private String rootDirectory;

    public Directory(){
        rootDirectory = ".\\";
    }
    
    
    public String getRootDirectory(){
        return rootDirectory;
    }
    
    public void setRootDirectory(String value){
        rootDirectory=value;
    }
   
    public ArrayList<String> getFiles() {
        ArrayList<String> result = new ArrayList<>();
        java.io.File f = getRootDirectoryAsFile(); 
        File fileList[] = f.listFiles();       
        for(File file : fileList){
            result.add(file.getName());
        }
        Collections.sort(result);
        return result;
        
    }
    
    public File getRootDirectoryAsFile(){
        return new java.io.File(rootDirectory); 
    }

    
    public File searchFile(String filename) {
        File [] files = getRootDirectoryAsFile().listFiles(); 
        for (File f : files) {
            if (f.getName().equals(filename)) {
                return f;
            }
        }
        return null;
    }

    public boolean deleteFile(String filename) {
        int index = 0;
        boolean found = false;
        File [] files = getRootDirectoryAsFile().listFiles(); 
        for (File f : files) {            
            if (f.getName().equals(filename)) {
                found = true;
                break;
            }
            index++;
        }
        
        if(found){
            found = files[index].delete();
        }
        return found;
    }
    
    public boolean addFile(File file) {        
        File rootDir =  this.getRootDirectoryAsFile();
        boolean result = false;
        if(file.exists()){
            File newFile = new File(rootDir.getAbsolutePath() + File.separator + file.getName());
            try{
                this.copyFileUsingStream(file, newFile);
                result = true;
            }catch(IOException e){
                
            }
        }
        return result;
    }
    
    private  void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            if(is != null)
                is.close();
            if(os != null)
                os.close();
        }
    }
    

}