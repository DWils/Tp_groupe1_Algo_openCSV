package evaluation;

public class Main {

	public static void main(String[] args) {
		
		int[] tab = {85,12,5,48,9,14};
		int[] tab2 = {8,1,5,4,98,14};
		int[][] matA = { { 1,2,3 } , { 1,2,3 } , { 1,2,3 } };
		int[][] matB = { { 3,2,1 } , { 3,2,1 } , { 3,2,1 } };
		int[] tab3 = {1,3,4,8,14};
		
		// Classe Outils pour formater
		Tools tools = new Tools();
		
		Exemples ex = new Exemples();
		System.out.println(ex.minNumber(tab)); // min = 5
		System.out.println(ex.minNumber(tab2)); // min = 1
		System.out.println("\n");
		System.out.println(ex.maxNumber(tab)); // max = 85
		System.out.println(ex.maxNumber(tab2)); // max = 98
		System.out.println("\n");
		System.out.println(ex.somme(5)); // somme = 15
		System.out.println(ex.somme2(5)); // somme = 15
		System.out.println("\n");
		int[][] matC = ex.additionMatrice(matA, matB);
		int[][] matC2 = ex.multiplicationMatrice(matA, matB);
		tools.readMatrix(matC);
		System.out.println("\n");
		tools.readMatrix(matC2);
		System.out.println("\n");
		System.out.println(ex.binarySearch(8,tab3));
		System.out.println("\n");
		System.out.println(ex.x_power_n(8, 2));
		System.out.println("\n");
		System.out.println(ex.factorielle(6));
		System.out.println("\n");
		LIFO lifo = new LIFO();
		lifo.exerciceLIFO();
	}
}

