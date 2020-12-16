package evaluation;

public class Exemples {
	// Ex 1 Cherche le minimum d'une table
	public int minNumber(int[] tab) {
		int result = tab[0];
		for(int i=0 ; i < tab.length ; i++ ) {
			if(result > tab[i]) {
				result = tab[i];
			}
		}
		return result;
	}
	
	// Ex 2 Cherche le maximum d'une table
	public int maxNumber(int[] tab) {
		int result = tab[0];
		for(int i=0 ; i < tab.length ; i++) {
			if(result < tab[i]) {
				result = tab[i];
			}
		}
		return result;
	}
	
	// Ex 3.2 Faire une somme (m�thode simple)
	public int somme(int n) {
		int result = 0;
		for(int i=0 ; i <= n ; i++) {
			result = result + i;
		}
		return result;
	}
	
	// Ex 3.4 Faire une somme (m�thode diviser pour regner)
	public int somme2(int n) {
		int result = 0;
		int s_imp = 0;
		if (n == 0 || n ==1) {
			result = n;
		}
		else if (n%2 == 0) {
			s_imp = somme_impairs(n);
			result = 2*s_imp + n/2;
		}
		else {
			s_imp = somme_impairs(n);
			result = 2*s_imp + (n-1)/2 + n;
		}
		return result;
	}

	// Somme des impaires
	public int somme_impairs(int n) {
		int result = 0;
		int end = 0;
		if (n%2 == 0) {
			end = (n-2)/2;
		}
		else {
			end = (n-3)/2;
		}
		
		for(int i=0 ; i<= end ; i++) {

			result = result + (2*i + 1);
		}
		return result;
	}
	
	// Ex4.1 Addition matrice
	public int[][] additionMatrice( int[][] matriceA ,int[][] matriceB ) {
		int[][] matriceC = { { 0,0,0 } , { 0,0,0 } , { 0,0,0 } };
		for(int i=0; i<= matriceA.length-1 ;i++) {
			for(int j=0; j<= matriceA.length-1 ;j++) {
				matriceC[i][j] = matriceA[i][j] + matriceB[i][j];
			}
		}
		return matriceC;
	}
	
	// Ex4.2 Multiplication de matrice
	public int[][] multiplicationMatrice( int[][] matriceA ,int[][] matriceB ) {
		int[][] matriceC = { { 0,0,0 } , { 0,0,0 } , { 0,0,0 } };
		for(int i=0; i<= matriceA.length-1 ;i++) {
			for(int j=0; j<= matriceA.length-1 ;j++) {
				for(int k=0 ; k<= matriceA.length-1 ;k++)
				{
					matriceC[i][j] = matriceC[i][j] + matriceA[i][k] * matriceB[k][j];
				}
			}
		}
		return matriceC;
	}
	
	// Ex5 Binary Search 
	// /!\ Sorted table
	public String binarySearch(int val , int[] tab) {
		String result = "";
		boolean find = false;
		int start = 0;
		int end = tab.length - 1 ;
		int i = (start + end)/2;
		
		while((!find) && (start < end)) {
			
			if(val == tab[i]) {
				find = true;
			} else if(val < tab[i]) {
				end = --i;
			}else {
				start = ++i;
			}
		}
		if(find) {
			result ="Found at position "+ i;
		}else {
			result = "Not Found";
		}
		return result;
	}
	
	//Exemple 6 : x puissance n
	public int x_power_n(int x , int n) {
		for(int i=0; i < n-1 ; i++) {
			x = x * x;
		}
		return x;
	}
	
	//Exemple 7 : Factiorielle
	public int factorielle(int x) {
		int result = 1;
		for(int i=1; i <= x ; i++) {
			result = result * i;
		}
		return result;
	}
	
	
	
	
	
}

