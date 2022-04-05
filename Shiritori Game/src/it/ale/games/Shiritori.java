package it.ale.games;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Shiritori {
	
	private static ArrayList<String> words = new ArrayList<String>();
	
	public static boolean game_over;
	
	/*public Shiritori(ArrayList<String> words, boolean game_over) {
		this.words = words;
		this.game_over = game_over;
		
	}*/
	public static int lifes;

	
	
	
	
	
	
	public void play(String word){
		
		if(words.size()==0) {
			words.add(word);
			System.out.println(words);
			lifes = 2;
			return;
		}
		
		for(String parola : words)
		    if(word.equals(parola)) {
		    	if(lifes==2) {
		    		System.out.println("Parola già presente! Ma ti rimane una vita!");
		    		lifes=1;
		    		return;
		    	}
		    	if (lifes == 1)
		    	System.out.println("Parola già presente, hai perso!");
		    	game_over=true;
		    	return;
		    }
		
		char last = words.get(words.size()-1)
					.charAt(words.get(words.size()-1).length() - 1);
		
		char first = word.charAt(0);
	
		
		if(!Readfile.CheckDic(word)) {
			if(lifes==2) {
			System.out.println("La parola non esiste! Ma hai ancora una vita!");
			lifes=1;
			return;
			}
			if(lifes==1) {
			System.out.println("La parola non esiste!, e hai perso!");
			game_over=true;
			return;
			}
		}
		
		if(last==first) {
			words.add(word);
			System.out.println(words);
			

		}else {
			if(lifes==2) {
			System.out.println("Non va bene! Ma hai anora una vita!");
			lifes=1;
			return;
			}else if (lifes==1) {
				System.out.println("Noooo, hai perso!!!");
			game_over=true;
			}
		}
		
		
		
		
	}
	
	public void restart() {
		if(game_over==true) {
			words.clear();
			game_over=false;
			System.out.println("game restarted");
		} else {
			System.out.println("you can't restart!");
		}
	}
	
	public static void getWords() {
		System.out.println(words);
	}
	
	
	
	
	

	public static void main(String[] args) {
		
		Shiritori gioco1 = new Shiritori();
		
		while(game_over==false) {
		Scanner parolainput = new Scanner(System.in);  
	    System.out.println("Inserisci parola:");
	    String parola = parolainput.nextLine();
		
		gioco1.play(parola);
		}
		
		
		
		
		

	}
	

}


