/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<editor-fold defaultstate="collapsed" desc="/*comment*/">
package hw7n;
//</editor-fold>

/**
 *
 * @author Tarık
 */
import java.security.InvalidParameterException;
import javafx.util.Pair;

/**
 *
 * @author Tarık
 */
public class Hw7n{
	
    /**
     *
     * @param args
     */
    @SuppressWarnings("unchecked")
	public static void main(String... args)
	{
		System.out.println("SET CLASSI ELEMAN EKLEME , EKRANA YAZDIRMA(ITERATOR), EXCEPTION TEST");
		System.out.println("---------------------------------------------------------------------");
		
		GTUSet<String> s1 = new GTUSet<>();
		GTUSet<String> s2 = new GTUSet<>();
		GTUSet<String> interSec = new GTUSet<>();
		String ad = "Tarik",soyad = "Kilic", ders = "C++", status = "FAIL";
		
		try {
			s1.insert(ad);
			s1.insert(soyad);
			s1.insert(ders);
			s1.insert(status);
			s1.insert(ad);
		}
		catch(InvalidParameterException InvalidParameterException) {
			System.err.println("AYNI ELEMAN EKLEYEMEZSINIZ");
		}
		
		GTUSet<String>.GTUIterator it = s1.new GTUIterator();
		
		while(it.hasNext())
		{
			System.out.print(it.next() + " \n");
		}
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("SET INTERSECTION FONKSIYON");
		
		s2.insert(ad);
		s2.insert(soyad);
		s2.insert(ders);
		interSec = (GTUSet<String>)s1.intersection(s2);
		GTUSet<String>.GTUIterator its = interSec.new GTUIterator();
		while(its.hasNext())
		{
			System.out.print(its.next() + " \n");
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("SET CLASSI BOYUT");
		System.out.print(s1.size() + "\n");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("SET CLASSI ELEMAN KONTROL");
		if(s1.count("Tarik") == 1)
			System.out.println("Tarik Var");
		if(s1.count("Ahmet") != 1)
			System.out.println("Ahmet Yok");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("ELEMAN SILME");
		s1.erase("Tarik");
		if(s1.count("Tarik") != 1)
			System.out.println("Tarik Yok");
		
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("CLEAR FONK. VE SONRA BOYUT KONTROLU");
		s1.clear();
		System.out.print(s1.size() + " \n");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println(" SET EMPTY FONK KONTROL");
		if(s1.empty()) {
			System.out.println("ICI BOS");
		}
		
		System.out.println("---------------------------------------------------------------------");
		
		
		
		
		
		
		System.out.println("MAP CLASSI ELEMAN EKLEME ve EKRANA YAZDIRMA(ITERATOR)");
		System.out.println("---------------------------------------------------------------------");
		GTUMap<String,Integer> obje = new GTUMap<>();
		GTUMap<String,Integer> obje2 = new GTUMap<>();
		GTUMap<String,Integer> interS = new GTUMap<>();
		
		try {
			obje.insert(new Pair<>("tarik",4));
			obje.insert(new Pair<>("kilic",6));
			obje.insert(new Pair<>("asd",8));
			obje.insert(new Pair<>("qwe",2));
			obje.insert(new Pair<>("hjk",5));
			obje.insert(new Pair<>("bnm",7));
			obje.insert(new Pair<>("poi",7));
			obje.insert(new Pair<>("mn",87));
			obje.insert(new Pair<>("mn",87));
			obje.insert(new Pair<>("y",56));	
		}
		catch(InvalidParameterException InvalidParameterException) {
			System.err.println("AYNI ELEMAN EKLEYEMEZSINIZ");
		}
		

		GTUMap<String,Integer>.GTUIterator ita = obje.new GTUIterator();
		while(ita.hasNext())
			System.out.print(ita.next() + " \n");
		
		
		System.out.println(" MAP EMPTY FONK KONTROL");
		if(!obje.empty()) {
			System.out.println("ICI DOLU");
		}
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("MAP CLASSI BOYUT");
		System.out.print(obje.size() + " \n");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("Map CLASSI ELEMAN KONTROL");
		if(obje.count(new Pair<>("tarik",4)) == 1)//HATA
			System.out.println("Tarik Var");
		if(obje.count(new Pair<>("ahmet",4)) != 1)
			System.out.println("Ahmet Yok");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("ELEMAN SILME");
                obje.erase(new Pair<>("tarik",4));
		if(obje.count(new Pair<>("tarik",4)) != 1)
			System.out.println("Tarik Yok");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("BEGIN FONKSIYONU");
		ita = obje.begin();
		while(ita.hasNext())
			System.out.print(ita.next() + " \n");
	
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("AT FONKSIYONU");
		System.out.print(obje.at("asd") + " \n");
		
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("FIND FONKSIYONU");
		ita = obje.find(new Pair<>("qwe",2));
		System.out.print(ita.next() + " \n");
	}
}
