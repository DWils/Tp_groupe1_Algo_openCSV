package testOpenCsv2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class TestCSV {

	private String csvPath = "repertoire.csv";
	private String path = System.getProperty("user.home") + "/eclipse-workspace1/testOpenCsv/" + csvPath;
	private CSVWriter writer;
	private CSVReader reader;

	public void writeCSV() throws IOException, CsvValidationException {
		writer = new CSVWriter(new FileWriter(csvPath));
		List<String[]> rows = new ArrayList<>();

		// test si fichier vide
		reader = new CSVReader(new FileReader(path));
		// Si Vide on ajoute le header
		if (reader.readNext() == null) {
			rows.add(addHeader());
		}

		String[] row1 = new String[] { "1", "Patrick", "Dupont", "0123456789" };
		String[] row2 = new String[] { "2", "Marie", "Dupond", "0123458789" };
		String[] row3 = new String[] { "3", "Bruce", "Lee", "0623478789" };
		String[] row4 = new String[] { "4", "Lucie", "Landier", "0523456789" };
		rows.add(row1);
		rows.add(row2);
		rows.add(row3);
		rows.add(row4);

		writer.writeAll(rows);
		writer.flush();
		System.out.println("Saved");
		writer.close();
	}

	public void readCSV() throws IOException {
		try {
			reader = new CSVReader(new FileReader(path));
			String[] nextline;
			while ((nextline = reader.readNext()) != null) {
				if (nextline != null) {
					System.out.println(Arrays.toString(nextline));
				}
			}
			System.out.println("CSV Read complete");
		}

		catch (Exception e) {
			System.out.println(e);
		}
		reader.close();
	}

	public void writePersonnesToCSV(List<Personne> lp) throws IOException, CsvValidationException {

		writer = new CSVWriter(new FileWriter(csvPath, false));
		List<String[]> rows = new ArrayList<>();
		// test si fichier vide
		reader = new CSVReader(new FileReader(path));
		// Si Vide on ajoute le header
		if (reader.readNext() == null) {
			rows.add(addHeader());
		}
		lp.forEach(p -> rows.add(p.personneToString(p)));
		writer.writeAll(rows);
		writer.flush();
		System.out.println(" New Contact Saved ");
		writer.close();

	}

	public String[] addHeader() {
		String[] header = new String[] { "id", "firstname", "lastname", "phonenumber" };
		return header;
	}

	public int findPersonneFromPhoneNum(String phoneNumber) throws IOException, CsvException {
		reader = new CSVReader(new FileReader(path));
		List<String[]> repertoire = reader.readAll();
		String[] nextline = repertoire.get(0);
		for (int i = 1; i < 6; i++) {
			nextline = repertoire.get(i);
			if (nextline[3].equals(phoneNumber)) {
				System.out.println(Arrays.toString(nextline));
				return i;
			}
		}
		return 0;
	}

	public void updatePhoneNum(String oldPhoneNumber, String newPhoneNumber) throws IOException, CsvException {
		int index = findPersonneFromPhoneNum(oldPhoneNumber);
		if (index > 0) {
			reader = new CSVReader(new FileReader(path));
			List<String[]> repertoire = reader.readAll();
			String[] line = repertoire.get(index);
			line[3] = newPhoneNumber;
			repertoire.set(index, line);
			System.out.println(Arrays.toString(line));
			System.out.println("\n");
			writer = new CSVWriter(new FileWriter(csvPath, false));
			writer.writeAll(repertoire);
			writer.flush();
			readCSV();
		}else {
			System.out.println("Not Found");
		}

	}

	public void deletePersonne(String phoneNumber) throws IOException, CsvException {
		System.out.println("Contact retiré :");

		int index = findPersonneFromPhoneNum(phoneNumber);
		if (index > 0) {
			reader = new CSVReader(new FileReader(path));
			List<String[]> repertoire = reader.readAll();
			repertoire.remove(index);
			System.out.println("\n");
			writer = new CSVWriter(new FileWriter(csvPath, false));
			writer.writeAll(repertoire);
			writer.flush();
			readCSV();
		}else {
			System.out.println("Not Found");
		}
	}

}
