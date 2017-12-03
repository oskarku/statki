package statki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class gra {

	public static void main(String[] args) {
		Statek lolo[]= new Statek[4];
		DaneStatkow lol;
		lol = new DaneStatkow();
		lol.odczytajPlik();
		System.out.println(lol.podzial[1][0]);
		System.out.println(DaneStatkow.szybkie_dziala[0][0]);
		Statek s1, s2;
		s1= new Statek("kr");
		s2= new Statek("lm");
		s1.sprawdz_szybkiedziala(s2);
		Flota s4;
		s4= new Flota("flota_1.txt");
		//System.out.print(s4);
		

		s4.tworz_flote();
		System.out.println(s4.flotaa.get(2).nazwa);
		
		//System.out.println(s2.nazwa);
		//lolo[0].sprawdz_szybkiedziala(s1);
		//System.out.println(s4.flota[2]);
		//System.out.println(lol.nazwy[2]);
		
		
	}

}
