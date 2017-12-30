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
		if(sr.equals("mt")) this.typ=0;
		if(sr.equals("dt")) this.typ=1;
		if(sr.equals("lm")) this.typ=2;
		if(sr.equals("cm")) this.typ=3;
		if(sr.equals("kr")) this.typ=4;
		if(sr.equals("ow")) this.typ=5;
		if(sr.equals("sk")) this.typ=6;
		if(sr.equals("re")) this.typ=7;
		if(sr.equals("ss")) this.typ=8;
		if(sr.equals("b")) this.typ=9;
		if(sr.equals("n")) this.typ=10;
		if(sr.equals("gs")) this.typ=11;
		if(sr.equals("p")) this.typ=12;
		this.atak=obj.atak[this.typ];
		this.oslona=obj.oslona[this.typ];
		this.punkty_strukturalne=obj.punkty_strukturalne[this.typ];
		this.nazwa=obj.nazwy[this.typ];
		}
		
	boolean sprawdz_czy_zniszcony() {
		if (this.punkty_strukturalne<=0.0)return true;
		return false;
	}
	boolean strzel(Statek obj) {
		Random random = new Random();
		double szansa= 1-1/sprawdz_szybkiedziala(obj);
		double gszans=random.nextDouble();
		//System.out.println("Wspuczynnik pecha jest "+(gszans-szansa)+" od szansy normalnej"+szansa);
		if (gszans<=szansa && szansa>0.0 && (this.atak > (1/100)*obj.oslona)  ) {
			this.atak=this.atak-obj.oslona;
			return true;
			}
		else return false; }
		
	
	
	void trafiony(Statek obj) {
		double szansa_wybuchu;
		double prog = (70/100)*DaneStatkow.punkty_strukturalne[typ];
		Random random = new Random();
		this.punkty_strukturalne=this.punkty_strukturalne-obj.atak;
		this.oslona=this.oslona-obj.atak;
		if(obj.atak>this.oslona)this.oslona=0.0;
		if (this.punkty_strukturalne<prog) {
			szansa_wybuchu=1-(this.punkty_strukturalne/DaneStatkow.punkty_strukturalne[this.typ]);
			if(random.nextDouble()==szansa_wybuchu)this.punkty_strukturalne=0.0;
			
		}
			
	}
	void statystyki() {
		System.out.println(this.nazwa);
		System.out.println("Tyle mam punktow ataku: "+this.atak);
		System.out.println("Tyle mam punktow oslony: "+this.oslona);
		System.out.println("Tyle mam punktow struk."+this.punkty_strukturalne);
		
	}
	
	double sprawdz_szybkiedziala(Statek obj) {
		return DaneStatkow.szybkie_dziala[typ][obj.typ];
	}

	
	

}
