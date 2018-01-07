package statki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class gra implements ActionListener {
	static JTextArea tekst;
	JTextField text1,text2;
	JButton przyciskz, graj;
	JFrame ramka;

	public static void main(String[] args) {
		gra gui = new gra();
		gui.tworzGUI();
	
	}
	public void tworzGUI() {
		ramka = new JFrame();
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3,1));
		text1 =new JTextField("Wpisz nazwe 1 gracza");
		text2=new JTextField("Wpisz nazwe 2 gracza");
		panel1.add(text1);
		panel1.add(text2);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		przyciskz = new JButton("ZapiszGracza");
		przyciskz.addActionListener(this);
		panel1.add(przyciskz);
		ramka.add(panel1);
		ramka.setSize(500,500);
		ramka.setVisible(true);
		
	}
	
	public void okno2() {
		ramka.getContentPane().removeAll();
		JPanel panel = new JPanel();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tekst = new JTextArea(30,50);
		tekst.setLineWrap(true);
		tekst.setEditable(false);
		graj = new JButton("GRAJ");
		graj.addActionListener(this);
		JScrollPane przewijanie = new JScrollPane(tekst);
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(przewijanie);
		ramka.getContentPane().add(BorderLayout.CENTER, panel);
		ramka.getContentPane().add(BorderLayout.SOUTH, graj);
		ramka.setSize(600,600);
		ramka.setVisible(true);
	}
	
	public static void drukuj(String napis) {
		tekst.append(""+napis+"\n");
	}
	
	public void start() {
		DaneStatkow lol= new DaneStatkow();
		Flota s1, s2;
		s1 = new Flota("flota_1.txt",text1.getText());
		s2 = new Flota("flota_2.txt", text2.getText());
		
		for (int i=0; i<6; i++) {
			tekst.append(">>>>>> RUNDA NR "+(i+1)+" <<<<< \n");
			tekst.append("Ilosc statkow floty 1: "+s1.flotaa.size()+" ilosc statkow floty 2 : "+s2.flotaa.size()+"\n");
			if(!s1.flotaa.isEmpty() && !s2.flotaa.isEmpty()) {
				tekst.append(s1.NazwaFloty+ "wybiera cel z floty "+s2.NazwaFloty+"\n");
				s1.wybierz_cel(s2);
				if(!s2.flotaa.isEmpty())s2.usun_statki();
				
				tekst.append(s2.NazwaFloty+" wybiera cel z "+s1.NazwaFloty+"\n");
				s2.wybierz_cel(s1);
				if(!s1.flotaa.isEmpty())s1.usun_statki();
				}
		}
		tekst.append(">>>>>wygrala flota: ");
		if (s1.flotaa.size()>s2.flotaa.size()) {
			tekst.append(s1.NazwaFloty+"<<<<<\n");
		}
		else if (s2.flotaa.size()>s1.flotaa.size()) {
			tekst.append(s2.NazwaFloty+"<<<<<\n");

		}
		else System.out.println("jest remis");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == przyciskz )okno2();
		else if (e.getSource() == graj)start();
		
	}
	
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
			drukuj("\nStatek z : "+this.NazwaFloty+" "+it.nazwa+" Strzela do statku z floty"+obj.NazwaFloty+"\n do: "+obj.flotaa.get(cel).nazwa+"\n" );
				while(it.strzel(obj.flotaa.get(cel))) {			
					obj.flotaa.get(cel).trafiony(it);
				}
			}
		}
			
		
		public int[] aktualny_stan() {
			int[] wyjscie = new int[14];
			for (Statek it:flotaa) {
				wyjscie[it.typ]++;
				
			}
			for(int l=0; l<14; l++ ) {
				tekst.append("Flota ma :"+wyjscie[l]+"  "+DaneStatkow.nazwy[l]+ "\n");
			}
			return wyjscie;
			
		}
		
		



		
	}


}
