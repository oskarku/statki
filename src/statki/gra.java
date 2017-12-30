package statki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class gra {

	public static void main(String[] args) {
		DaneStatkow lol= new DaneStatkow();
		Flota s1, s2;
		s1 = new Flota("flota_1.txt","Gracz nr 1");
		s2 = new Flota("flota_2.txt", "Gracz nr 2");
		
		for (int i=0; i<6; i++) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> RUNDA NR "+(i+1)+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,");
			System.out.println("Ilosc statkow floty 1: "+s1.flotaa.size()+" ilosc statkow floty 2 : "+s2.flotaa.size());
			if(!s1.flotaa.isEmpty() && !s2.flotaa.isEmpty()) {
				System.out.println(s1.NazwaFloty+ "wybiera cel z floty "+s2.NazwaFloty);
				s1.wybierz_cel(s2);
				if(!s2.flotaa.isEmpty())s2.usun_statki();
				//System.out.println("stan floty 2 "+s2.aktualny_stan());
				System.out.println(s2.NazwaFloty+" wybiera cel z "+s1.NazwaFloty);
				s2.wybierz_cel(s1);
				if(!s1.flotaa.isEmpty())s1.usun_statki();
				//System.out.println("Stan floty 1"+s1.aktualny_stan());
				}
			
		
		}
		if (s1.flotaa.size()>s2.flotaa.size()) {
			System.out.print("wygrala flota: "+s1.NazwaFloty);
			s1.aktualny_stan();
		}
		else if (s2.flotaa.size()>s1.flotaa.size()) {
			System.out.println("wygrala flota: "+s2.NazwaFloty);
			s2.aktualny_stan();
		}
		else System.out.println("jest remis");
		System.out.println("Aktualny stan floty1");
		s1.aktualny_stan();
		System.out.println("Aktualny stan floty2");
		s2.aktualny_stan();
		
		
		
		
		
	}

}
