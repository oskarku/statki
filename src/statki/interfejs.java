package statki;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * @author Oskar Kufel
 * Celem tego projektu bylo zaznajomic sie z podstawa swingiem oraz zeby ow projekt przynosil wiele radosci ,  
 * Autor zakladal ze wzniesie sie na wyrzyny lecz czas jak zwykle zabil jego wizje latania.
 */
public class interfejs  {
	
	//----------STREFA INICJALIZACJI----------
	static JTextArea tekst;
	JTextField []  polaTextowe = new JTextField[26];
	JButton przyciskz, graj, sFloty1, sFloty2, statystyki;
	JLabel [] etykiety = new JLabel[18];
	JFrame ramka;
	DaneStatkow lol= new DaneStatkow();
	Flota gracz1 ; 
	Flota gracz2 ;
	@SuppressWarnings("rawtypes")
	JList listaStatkow;
	String[] listaOpcji = {"Maly transportowiec", "Duzy Trasportowiec", "Lekki Mysliwiec", "Ciezki Mysliwiec", 
			"Krazownik", "Okret Wojenny", "Statek Kolonizacyjny", "Recykler", "Sonda Szpiegowska", "Bombowiec", "Niszczyciel", "Gwiazda Smierci",
			"Pancernik"};
	
	Statek statekZlisty;
	JLabel pAtaku, pStrukturalne, pOslony ;
	
	
// glowny watek main
	public static void main(String[] args) {
		interfejs gui = new interfejs();
		gui.tworzGUI();
		
		
	}
	
	public void tworzGUI() {
		//inicjalizacji ramki czyli nowego okna
		
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//inicjalizacja paneli oraz ich ustawien
		JPanel panelgracz1 = new JPanel();
		panelgracz1.setLayout(new BoxLayout(panelgracz1, BoxLayout.Y_AXIS));
		panelgracz1.setBackground(Color.lightGray);
		
		
		JPanel panelgracz2 = new JPanel();
		panelgracz2.setLayout(new BoxLayout(panelgracz2, BoxLayout.Y_AXIS));
		panelgracz2.setBackground(Color.lightGray);
		
		JPanel panelEtykiet = new JPanel();
		panelEtykiet.setLayout(new BoxLayout(panelEtykiet, BoxLayout.Y_AXIS));
		
		//inicjalizacja panelu w pione
		JPanel glowny = new JPanel();
		glowny.setLayout(new BoxLayout(glowny, BoxLayout.X_AXIS));
		
		
		//inicjalizzacja textfieldow
		
		for (int i=0; i<26; i++) {
			polaTextowe[i]= new JTextField(15);
		}
		// inicjalizacj etykiet poziom
		etykiety[0]= new JLabel("FLOTA");
		etykiety[1]= new JLabel("GRACZ 1");
		etykiety[2]= new JLabel("GRACZ 2");
		
		//inicjalizacja etykiet pion
		etykiety[3]= new JLabel("MALY TRANSPORTOWIEC");
		etykiety[4]= new JLabel("DUZY TRANSPORTOWIEC");
		etykiety[5]= new JLabel("LEKKI MYSLIWIEC ");
		etykiety[6]= new JLabel("CIEZKI MYSLIWIEC");
		etykiety[7]= new JLabel("KRAZOWNIK");
		etykiety[8]= new JLabel("OKRET WOJENNY");
		etykiety[9]= new JLabel("STATEK KOLONIZACYJNY");
		etykiety[10]= new JLabel("RECYKLER");
		etykiety[11]= new JLabel("SONDA SZPIEGOWSKA");
		etykiety[12]= new JLabel("BOMBOWIEC");
		etykiety[13]= new JLabel("NISZCZYCIEL");
		etykiety[14]= new JLabel("GWIAZDA_SMIERCI");
		etykiety[15]= new JLabel("PANCERNIK");
		
		
		//inicjalizacji gozikow
		przyciskz = new JButton("ZapiszGracza");
		przyciskz.addActionListener(new Przyciskk());
		
		//dodawanie do paneli 
		

		
		//dodawanie pol do gracza2
		panelgracz2.add(etykiety[2]);
		for(int y=13; y<26; y++) {
			panelgracz2.add(polaTextowe[y]);
		}
		
		//dodawanie etykiet do panelu etykiet 
		panelEtykiet.add(etykiety[0]);
		for(int zz=3; zz<16; zz++ ) {
			panelEtykiet.add(etykiety[zz], BorderLayout.LINE_START);
		}
		//dodanie pol od gracza 1
		panelgracz1.add(etykiety[1]);
		for(int z=0;z<13;z++) {
			panelgracz1.add(polaTextowe[z],BorderLayout.LINE_END );
		}
		
		//dodawanie do poziomego panelu 
		glowny.add(panelEtykiet);
		glowny.add(panelgracz1);
		glowny.add(panelgracz2);
		
		
		//parametry okna 
		ramka.getContentPane().add(BorderLayout.SOUTH, przyciskz);
		ramka.getContentPane().add(BorderLayout.CENTER, glowny);
		ramka.setSize(500,500);
		ramka.setVisible(true);
		
	}
	
	public class Przyciskk implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			gracz1 =new Flota("Gracz 1", polaTextowe[0].getText(), polaTextowe[1].getText(), polaTextowe[2].getText(), polaTextowe[3].getText(), polaTextowe[4].getText(), polaTextowe[5].getText(), polaTextowe[6].getText(), polaTextowe[7].getText(), polaTextowe[8].getText(), polaTextowe[9].getText(), polaTextowe[10].getText(), polaTextowe[11].getText(), polaTextowe[12].getText() );
			gracz2 = new Flota("Gracz 2", polaTextowe[13].getText(), polaTextowe[14].getText(), polaTextowe[15].getText(), polaTextowe[16].getText(), polaTextowe[17].getText(), polaTextowe[18].getText(), polaTextowe[19].getText(), polaTextowe[20].getText(), polaTextowe[21].getText(), polaTextowe[22].getText(), polaTextowe[23].getText(), polaTextowe[24].getText(), polaTextowe[25].getText());
			okno2();	
		}
		
	}
	
	public void okno2() {
		// Czyszczenie starej ramki 
		ramka.getContentPane().removeAll();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// inicjalizacja panelu 
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// inicjalizowanie text arei 
		
		tekst = new JTextArea(30,50);
		tekst.setLineWrap(true);
		tekst.setEditable(false);
		
		// inicjolizowanie przewijania 
		JScrollPane przewijanie = new JScrollPane(tekst);
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// inicjowanie guzikow
		graj = new JButton("GRAJ");
		graj.addActionListener(new Pgraj());
		sFloty1 = new JButton("Stan Floty1");
		sFloty1.addActionListener(new PsFloty1());
		sFloty2 = new JButton("Stan Floty2");
		sFloty2.addActionListener(new PsFloty2());
		statystyki = new JButton("Statystyki");
		statystyki.addActionListener(new Pstatystyki());
		
		//dodawanie do panelu
		panel.add(sFloty1);
		panel.add(statystyki);
		panel.add(sFloty2);
		
		
		
		//Dodawanie elementow do ramki
		ramka.getContentPane().add(BorderLayout.CENTER, przewijanie);
		ramka.getContentPane().add(BorderLayout.SOUTH, graj);
		ramka.getContentPane().add(BorderLayout.WEST, panel);
		ramka.setSize(600,600);
		ramka.setVisible(true);
	}
	
	
	
	//---------------------------------strefa inicjalizacji przycislkow--------------------------------
	/**
	 * @author Oskar
	 *  Metoda obslugajuca zadarzenia przycisku sFloty1
	 *
	 */
	public class PsFloty1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StanFlotyOkno(gracz1);	
		}
		
	}
	
	public class PsFloty2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			 StanFlotyOkno(gracz2);	
		}
		
	}
	
	public class Pstatystyki implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Statystykiokno();	
		}
		
	}
	
	public class Pgraj implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			start(gracz1, gracz2);
		}
		
	}
	
	
	
	
	
	//-----------------------------------Strefa tworzenia pozostalych okien---------------------------------
	
	/**
	 * metoda tworzaca okna stanu floty
	 */
	public void StanFlotyOkno(Flota obj) {
		
		ramka = new JFrame("Stan Floty "+obj.NazwaFloty);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//inicjalizacja paneli oraz ich ustawien
				JPanel panelFloty = new JPanel();
				panelFloty.setLayout(new BoxLayout(panelFloty, BoxLayout.Y_AXIS));
				panelFloty.setBackground(Color.lightGray);
				
				
				JPanel panelEtykiet = new JPanel();
				panelEtykiet.setLayout(new BoxLayout(panelEtykiet, BoxLayout.Y_AXIS));
				
				//inicjalizacja panelu w pione
				JPanel glowny = new JPanel();
				glowny.setLayout(new BoxLayout(glowny, BoxLayout.X_AXIS));
				
				//inicjalizowanie pol tekstowych
				
				JTextField[] Tstat;
				Tstat= new JTextField[13];
				for (int x=0; x<13 ; x++) {
					Tstat[x]= new JTextField(5);
					Tstat[x].setText(""+obj.aktualny_stan()[x]);
					Tstat[x].setEditable(false);
				}
				
				//dodawanie etykiet do panelu etykiet 
				//panelEtykiet.add(etykiety[0]);
				for(int zz=3; zz<16; zz++ ) {
					panelEtykiet.add(etykiety[zz]);
					panelFloty.add(Tstat[zz-3]);
				}
				glowny.add(panelEtykiet);
				glowny.add(panelFloty);
				ramka.getContentPane().add(BorderLayout.CENTER, glowny);
				ramka.setSize(500,500);
				ramka.setVisible(true);
	
	}
	
	
	public void Statystykiokno() {
		
		JPanel EtyketPane = new JPanel();
		EtyketPane.setLayout(new BoxLayout(EtyketPane, BoxLayout.PAGE_AXIS));
		//inicjalizacja okna
		ramka = new JFrame("Statystyki Statkoe ");
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//statekZlisty = new Statek("mt");
		
		
		//tworzenie  listy
		
		listaStatkow = new JList(listaOpcji);
		listaStatkow.addListSelectionListener(new LListaStatkow() );
		listaStatkow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//tworzenie  paska do przewijania
		JScrollPane scrollPane = new JScrollPane(listaStatkow);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//tworzenie etykiet 
		pAtaku = new JLabel("Punkty Ataku :");
		pStrukturalne = new JLabel (" Punkty strukturalne");
		pOslony = new JLabel (" Punkty oslony ");
		
		EtyketPane.add(pAtaku);
		EtyketPane.add(pStrukturalne);
		EtyketPane.add(pOslony);

		ObslugaStatystyk lol = new ObslugaStatystyk();
		Thread wotek2 = new Thread ( lol);
		
		//wotek2.start();
		

		//ustawienia koncowe ramki 
		ramka.getContentPane().add(BorderLayout.WEST, EtyketPane);
		ramka.getContentPane().add(BorderLayout.EAST, listaStatkow);
		ramka.setSize(500,500);
		ramka.setVisible(true);		
				

		
	}
	
	
	public class LListaStatkow implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub\
			//statekZlisty = new Statek("mt");
			if (!e.getValueIsAdjusting()) {
				String opcja = (String) listaStatkow.getSelectedValue();
				
		        if (opcja.equals(listaOpcji[0])) {statekZlisty = new Statek("mt");
		        infoStatki();
		 
		        
		        }
		        if (opcja.equals(listaOpcji[1])) {statekZlisty = new Statek("dt");
		        infoStatki();
		        
		        }
		        if (opcja.equals(listaOpcji[2])) {statekZlisty = new Statek("lm");
		        infoStatki();
		       
		        }
		        if (opcja.equals(listaOpcji[3])) {statekZlisty = new Statek("cm");
		        infoStatki();
		        
		        }
		        if (opcja.equals(listaOpcji[4])) {statekZlisty = new Statek("kr");
		      
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[5])) {statekZlisty = new Statek("ow");
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[6])) {statekZlisty = new Statek("sk");
		        
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[7])) {statekZlisty = new Statek("re");
		 
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[8])) {statekZlisty = new Statek("ss");
		    
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[9])) {statekZlisty = new Statek("b");
		      
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[10])) {statekZlisty = new Statek("n");
		       
		        infoStatki();
		        }
		        if (opcja.equals(listaOpcji[11])) {statekZlisty = new Statek("gs");
		        infoStatki();
		        }
		        
		        if (opcja.equals(listaOpcji[12])) {statekZlisty = new Statek("p");
		        infoStatki();
		        }
		       
		    }
	        
				
			}
			
			
		}
		


		
	
	public class ObslugaStatystyk implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				if (statekZlisty != null) {
					infoStatki();
					
				}
			}
			
		}
		
	}
	
	
	
	public class MojPanelGraficzny extends JPanel{
	public void paintComponent(Graphics g) {
		Image obrazek = new ImageIcon("lol.jpg").getImage();
		g.drawImage(obrazek, 3, 4, this);}
	}
	
	
	public void infoStatki() {
		
		pAtaku.setText(statekZlisty.statystyki()[1]);
		pStrukturalne.setText(statekZlisty.statystyki()[2]);
		pOslony.setText(statekZlisty.statystyki()[3]);
	
	}
	

	
	
	public static void drukuj(String napis) {
		tekst.append(""+napis+"\n");
	}
	
	

		public void start(Flota gracz1, Flota gracz2) {
		
			for (int i=0; i<6; i++) {
				interfejs.drukuj(">>>>>> RUNDA NR "+(i+1)+" <<<<< \n");
				interfejs.drukuj("Ilosc statkow floty 1: "+gracz1.flotaa.size()+" ilosc statkow floty 2 : "+gracz2.flotaa.size()+"\n");
				if(!gracz1.flotaa.isEmpty() && !gracz2.flotaa.isEmpty()) {
					interfejs.drukuj(gracz1.NazwaFloty+ "wybiera cel z floty "+gracz2.NazwaFloty+"\n");
					gracz1.wybierz_cel(gracz2);
					if(!gracz2.flotaa.isEmpty())gracz2.usun_statki();
					interfejs.drukuj(gracz2.NazwaFloty+" wybiera cel z "+gracz1.NazwaFloty+"\n");
					gracz2.wybierz_cel(gracz1);
					if(!gracz1.flotaa.isEmpty())gracz1.usun_statki();
					}
			}
			interfejs.drukuj(">>>>>wygrala flota: ");
			if (gracz1.flotaa.size()>gracz2.flotaa.size()) {
				interfejs.drukuj(gracz1.NazwaFloty+"<<<<<\n");
			}
			else if (gracz2.flotaa.size()>gracz1.flotaa.size()) {
				interfejs.drukuj(gracz2.NazwaFloty+"<<<<<\n");
			}
			else interfejs.drukuj("jest remis");

		}

	

}
