package statki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Oskar
 * Klasa Flotta powstala z mysla o odwzorowaniu floty w realnym swiecie.
 * mamy w niej takie metody jak tworz flote, wybierz cel , usun statki , aktualny stan floty
 *
 */
public class Flota  {
	String NazwaFloty;
	String pliko[]=new String[14];
	String konw[][]=new String[14][2];
	int flota[]=new int[14];
	String nazwy[] = new String[14];
	String p;
	int sumastatkow=0;
	ArrayList<Statek> flotaa= new ArrayList<Statek>();
	
	
	public Flota(String plik,String Nazwa) {
		this.NazwaFloty=Nazwa;
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
			this.tworz_flote();
			
		}
 
		catch (FileNotFoundException e) {
			interfejs.drukuj("blad ");
		}
	}
		public Flota(String Nazwa, String mt, String dt, String lm, String cm, String kr, String ow, String sk, String re, String ss, String b, String n, String gs, String p  ) {
		this.NazwaFloty=Nazwa;
		flota[0]= Integer.parseInt(mt);
		flota[1]= Integer.parseInt(dt);
		flota[2]= Integer.parseInt(lm);
		flota[3] = Integer.parseInt(cm);
		flota[4] = Integer.parseInt(kr);
		flota[5] = Integer.parseInt(ow);
		flota[6] = Integer.parseInt(sk);
		flota[7] = Integer.parseInt(re);
		flota[8] = Integer.parseInt(ss);
		flota[9] = Integer.parseInt(b);
		flota[10] = Integer.parseInt(n);
		flota[11] = Integer.parseInt(gs);
		flota[12] = Integer.parseInt(p);
		this.tworz_flote();
	}
 
	
	
	public void tworz_flote() {
		for (int j=0;j<14;j++) {
			if (flota[j]>0) {
				for(int k=0;k<flota[j];k++) {
					flotaa.add(new Statek(DaneStatkow.skroty[j]));	
					
				}
				//System.out.println("W "+this.NazwaFloty+" jest :"+flota[j]+" "+DaneStatkow.nazwy[j]);
			}
		}	
	}
	public void usun_statki() {
		for (int i=0; i < flotaa.size();i++)
		{
			if(flotaa.get(i).sprawdz_czy_zniszcony()) {
				if(flotaa.size()!=0)flotaa.remove(i);
			}
		}
		
		
	}
	
	public void wybierz_cel(Flota obj) {
		int wielkoscObcejFloty= obj.flotaa.size();
		Random generator = new Random();
		int cel;
		for (Statek it : flotaa) {
		cel = generator.nextInt(wielkoscObcejFloty);
		interfejs.drukuj("\nStatek z : "+this.NazwaFloty+" "+it.nazwa+" Strzela do statku z floty"+obj.NazwaFloty+"\n do: "+obj.flotaa.get(cel).nazwa+"\n" );
			while(it.strzel(obj.flotaa.get(cel))) {			
				obj.flotaa.get(cel).trafiony(it);
			}
		}
	}
		
	
	/**
	 * Metoda zwraca aktualny stan floty ktory jest pozniej wykorzystywany chocby do wyswietlania stanow 
	 * @return Tablica intow, 
	 */
	public int[] aktualny_stan() {
		int[] wyjscie = new int[14];
		for (Statek it:flotaa) {
			wyjscie[it.typ]++;
			
		}
		//for(int l=0; l<14; l++ ) {
			//interfejs.drukuj("Flota ma :"+wyjscie[l]+"  "+DaneStatkow.nazwy[l]+ "\n");
		//}
		return wyjscie;
		
	}
	
	



	
}