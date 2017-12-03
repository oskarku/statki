package statki;
import java.util.Arrays;
import java.util.Random;
public class Statek {
	int typ;
	String nazwa;
	double atak;
	double oslona;
	double punkty_strukturalne;
	
	public Statek (String sr) {
		DaneStatkow obj;
		obj= new DaneStatkow();
		if(sr=="mt") this.typ=0;
		if(sr=="dt") this.typ=1;
		if(sr=="lm") this.typ=2;
		if(sr=="cm") this.typ=3;
		if(sr=="kr") this.typ=4;
		if(sr=="ow") this.typ=5;
		if(sr=="sk") this.typ=6;
		if(sr=="re") this.typ=7;
		if(sr=="ss") this.typ=8;
		if(sr=="b") this.typ=9;
		if(sr=="n") this.typ=10;
		if(sr=="gs") this.typ=11;
		if(sr=="p") this.typ=12;
		this.atak=obj.atak[this.typ];
		this.oslona=obj.oslona[this.typ];
		this.punkty_strukturalne=obj.punkty_strukturalne[this.typ];
		this.nazwa=obj.nazwy[this.typ];
		}
		
	boolean sprawdz_czy_zniszcony() {
		if (this.punkty_strukturalne<=0.0)return false;
		return true;
	}
	boolean strzel(Statek obj) {
		if (1-1/sprawdz_szybkiedziala(obj)>0.0   ) {
			this.atak=atak-obj.oslona;
			return true;
			}
		if(atak< (1/100)*obj.oslona) {
		return false; }
		return true;
		
	}
	
	
	void trafiony(Statek obj) {
		this.punkty_strukturalne=punkty_strukturalne-obj.atak;
		double szansa_wybuchu;
		double prog = (70/100)*DaneStatkow.punkty_strukturalne[typ];
		if(obj.atak>oslona)oslona=0.0;
		oslona=oslona-obj.atak;
		if (punkty_strukturalne<prog) {
			szansa_wybuchu=1-(punkty_strukturalne/DaneStatkow.punkty_strukturalne[typ]);
			Random random = new Random();
			if(random.nextDouble()==szansa_wybuchu)punkty_strukturalne=0.0;
			
		}
			
	}
	void statystyki() {
		System.out.println(this.nazwa);
		System.out.println("Tyle mam punktow ataku: "+this.atak);
		System.out.println("Tyle mam punktow oslony: "+this.oslona);
		System.out.println("Tyle mam punktow struk."+this.punkty_strukturalne);
		
	}
	
	double sprawdz_szybkiedziala(Statek obj) {
		System.out.println(DaneStatkow.szybkie_dziala[typ][obj.typ]);
		return DaneStatkow.szybkie_dziala[typ][obj.typ];
	}

	
	

}
