package statki;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.String;
import java.lang.Double;

 
public class DaneStatkow {
	String pliko = "dane_statkow.txt";
	String plik2= "szybkie_dziala.txt";
	String skrót;
	String[] tablica;
	String[] tab2;
	String[][] podzial2 = new String[14][14];
	String[][] podzial = new String[14][5];
	static String skroty[]=new String[14];
	static String nazwy[]=new String[14];
	static double atak[]=new double[14];
	static double punkty_strukturalne[]=new double[14];
	static double oslona[]=new double[14];
	static double szybkie_dziala[][]= new double[14][14];
	
	
static double dane[];
	



	  public void odczytajPlik() {
		  File szybkied= new File(this.plik2);
	        File plikDane = new File(this.pliko);
	        this.tablica = new String[14];
	        this.tab2=new String[14];
	        try {
	            Scanner skaner2 = new Scanner(szybkied);
	            Scanner skaner = new Scanner(plikDane);
	           
	            for (int  i=0;i<14;i++) {
	            	this.tab2[i]=skaner2.nextLine();
	                this.podzial2[i]=this.tab2[i].split(" ");
	                
	                this.tablica[i] = skaner.nextLine();
	                this.podzial[i]=this.tablica[i].split(" ");
	            }
	            for(int k=1;k<14;k++) {    
	            	for (int o=1;o<14;o++) {
	            
	                		DaneStatkow.szybkie_dziala[k-1][o-1]=Double.parseDouble(this.podzial2[k][o]);
	             
	                	}
	            }
	            
	         
	            skaner.close();
	            skaner2.close();
	            
	            for (int j=1;j<14;j++) {
	            	
	                DaneStatkow.skroty[j-1]=this.podzial[j][0];
	                DaneStatkow.atak[j-1]=Double.parseDouble(this.podzial[j][4]);
	                DaneStatkow.oslona[j-1]=Double.parseDouble(this.podzial[j][3]);
	                DaneStatkow.nazwy[j-1]=this.podzial[j][1];
	                DaneStatkow.punkty_strukturalne[j-1]=Double.parseDouble(this.podzial[j][2]);
	                 
	            }
	     
	        
	        } catch (FileNotFoundException e) {
	            System.out.println("Brak Pliku do odczytania!");
	        }
	    }
	  


	  
	
	  

	
	
}