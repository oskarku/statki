package statki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class gra {

	public static void main(String[] args) {
		DaneStatkow lol;
		lol= new DaneStatkow();
		Flota s1, s2;
		s1 = new Flota("flota_1.txt","Flota gracza nr 1");
		s2 = new Flota("flota_2.txt", "Flota gracza nr 2");
		/*s1.flotaa.get(0).statystyki();
		s2.flotaa.get(0).statystyki();
		s2.flotaa.get(0).strzel(s1.flotaa.get(0));
		s1.flotaa.get(0).trafiony(s2.flotaa.get(0));
		System.out.println(" Po walce");
		s1.flotaa.get(0).statystyki();
		s2.flotaa.get(0).statystyki();*/
		//s1.wybierz_cel(s2);
		//s2.wybierz_cel(s1);
		
		for (int i=0; i<6; i++) {
			System.out.println(s1.flotaa.size()+" "+s2.flotaa.size());
			if(s1.flotaa.size()>0 && s2.flotaa.size()>0) {
			s1.wybierz_cel(s2);
			if(!s2.flotaa.isEmpty())s2.usun_statki();
			s2.wybierz_cel(s1);
			if(!s1.flotaa.isEmpty())s1.usun_statki();}
			break;
		}
		if (s1.flotaa.size()>s2.flotaa.size())System.out.print("wygrala flota: "+s1.NazwaFloty);
		else if (s2.flotaa.size()>s1.flotaa.size())System.out.println("wygrala flota: "+s2.NazwaFloty);
		else System.out.println("jest remis");
		
		
		
		
		
	}

}
