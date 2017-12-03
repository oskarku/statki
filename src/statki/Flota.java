package statki;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Flota  {
	String pliko[]=new String[14];
	String konw[][]=new String[14][2];
	int flota[]=new int[14];
	String nazwy[] = new String[14];
	String p;
	Statek[] folotaa = {};
	int sumastatkow=0;
	List<Statek> flotaa = new ArrayList<Statek>();
	
	
	Flota(String plik) {
		p=plik;
    
		try {
			File flota1= new File(p); 
			Scanner skanf1 = new Scanner(flota1);
	 
			for (int i=0; i<14; i++) {
				pliko[i]=skanf1.nextLine();
				konw[i]=pliko[i].split(" ");
			}	 
			for (int j=1; j<14; j++) {
				nazwy[j-1]=konw[j][0];
				flota[j-1]=Integer.parseInt(konw[j][1]);
			}
			skanf1.close();
			for(int x : flota) {
				sumastatkow=sumastatkow+x;
			}
			
		}
 
		catch (FileNotFoundException e) {
			System.out.println("Brak Pliku do odczytania! /n podaj nowy plik :");  }
 
	
	}
	public void tworz_flote() {
		int nazwa=0 ;
		for (int j=0;j<14;j++) {
			if (flota[j]>0) {
				System.out.println(j);
				System.out.println(nazwy[j]);
				System.out.println(flota[j]);
				//nazwa=nazwa+j;
				for(int k=0;k<flota[j];k++) {
					//System.out.println(nazwy[j]);
					flotaa.add(new Statek(nazwy[j]));	
				}
			}
		}	
	}
	public void usun_statki() {
		
		
	}
	
	




}

    

