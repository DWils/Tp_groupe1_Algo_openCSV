package evaluation;

public class Tools {
	public void readMatrix(int[][] matrice) {
		String affichageTableau = "|";
		int count = 0;
		
		for(int i=0; i< matrice.length ;i++) {
			for(int j=0; j< matrice.length ;j++) {
				affichageTableau = affichageTableau + matrice[i][j] + "|";
				count++;
				if(count == matrice.length) {
					System.out.println(affichageTableau);
					affichageTableau = "|";
					count = 0;
				}
			}
		}
	}

}
