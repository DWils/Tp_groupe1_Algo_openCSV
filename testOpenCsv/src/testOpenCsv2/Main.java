package testOpenCsv2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class Main {

	public static void main(String[] args) throws IOException, CsvException {
		TestCSV test = new TestCSV();	
		//test.writeCSV();
		Personne p1 = new Personne(1,"Patrick","Dupont","0123456789");
		Personne p2 = new Personne(2,"Marie","Dupond","0123458789");
		Personne p3 = new Personne(3,"Bruce","Lee","0623478789");
		Personne p4 = new Personne(4,"Lucie","Landier","0523456789");
		Personne p5 = new Personne(5,"Maggie","Laval","0758967851");
		
		List<Personne> lp = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
		
		test.writePersonnesToCSV(lp);
			
		test.readCSV();
		System.out.println("\n");
		System.out.println("Contact recherché :");
		test.findPersonneFromPhoneNum(p4.getPhonenumber());
		System.out.println("\n");
		// ancien n° ==> nouveau n°
		System.out.println("Contact mis à jour :");
		test.updatePhoneNum("0123458789","0714141414"); 
		System.out.println("\n");
		test.deletePersonne("0523456789");

	}

}
