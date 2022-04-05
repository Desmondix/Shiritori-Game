package it.ale.games;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Readfile {
	
	
	
  public static String parola;
  
  public Readfile(String data) {
	  
	  this.parola=data;
	  
  }
	  
  public static boolean CheckDic(String parola) {
	  
	
	  
	
    try {
      File myObj = new File("resources/660000_parole_italiane.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.equalsIgnoreCase(parola)) {
        	return true;
        } 
      
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return false;
  }
  

}