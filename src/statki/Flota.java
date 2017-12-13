package statki;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Flota  {
	String NazwaFloty;
	String pliko[]=new String[14];
	String konw[][]=new String[14][2];
	int flota[]=new int[14];
	String nazwy[] = new String[14];
	String p;
	int sumastatkow=0;
	ArrayList<Statek> flotaa= new ArrayList<Statek>();
	
	
	public Flota(String plik, String Nazwa) {
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
			System.out.println("Brak Pliku do odczytania! /n podaj nowy plik :");  }
 
	
	}
	public void tworz_flote() {
		for (int j=0;j<14;j++) {
			if (flota[j]>0) {
				for(int k=0;k<flota[j];k++) {
					flotaa.add(new Statek(nazwy[j]));	
					
				}
				System.out.println("W "+this.NazwaFloty+" jest :"+flota[j]+" "+DaneStatkow.nazwy[j]);
			}
		}	
	}
	public void usun_statki() {
		for (int i=0; i < flotaa.size();i++)
		{
			if(flotaa.get(i).sprawdz_czy_zniszcony()) {
				System.out.println("wlasnie usunolem statek ");
				if(flotaa.size()!=0)flotaa.remove(i);
				else this.flotaa= new ArrayList<Statek>();
				System.out.println("Zobacz na rozmiar:"+ flotaa.size());
			}
		}
		
		
	}
	
	public void wybierz_cel(Flota obj) {
		int wielkoscObcejFloty= obj.flotaa.size();
		Random generator = new Random();
		int cel;
		
		for (Statek it : flotaa) {
		cel = generator.nextInt(wielkoscObcejFloty);
		System.out.println("Jestem statkiem z "+this.NazwaFloty+"o typie : "+ it.nazwa+"i strzelam do "+obj.NazwaFloty+" ich statek to : "+obj.flotaa.get(cel).nazwa);
		System.out.println("To sa szybkie dziala dla  "+it.nazwa+"  preciwko  "+ obj.flotaa.get(cel).nazwa+": " +it.sprawdz_szybkiedziala(obj.flotaa.get(cel)));
			while(it.strzel(obj.flotaa.get(cel))) {			
				System.out.println("Wlasnie strzelilem"+obj.flotaa.get(cel).nazwa);
				obj.flotaa.get(cel).trafiony(it);
				obj.flotaa.get(cel).statystyki();
			}
		System.out.println("Statek z "+this.NazwaFloty+"o typie : "+ it.nazwa+" zakonczyl strzelanie do "+obj.NazwaFloty+" a konkretnie do statku  : "+obj.flotaa.get(cel).nazwa);
		
		}
	}
		
	
	public int[] aktualny_stan() {
		int[] wyjscie = new int[14];
		for (Statek it:flotaa) {
			wyjscie[it.typ]++;
			
		}
		for(int l : wyjscie ) {
			System.out.println("Flota ma :"+wyjscie[l]+"  "+DaneStatkow.nazwy[l]);
		}
		return wyjscie;
		
	}
	
	



	
}

    

