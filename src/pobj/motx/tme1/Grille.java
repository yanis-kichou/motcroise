package pobj.motx.tme1;

public class Grille {

	/**
	 * grille : tableau  de case 
	 * hauteur et largeur coordonnée  taille de la matrice 
	 */
	private Case[][] grille;
	private int hauteur,largeur;
	
	/**
	 * constructeur qui permet de cree une grille 
	 * @param hauteur nombre  de ligne de la grille
	 * @param largeur nombre de colonne de la grille 
	 */
	public Grille(int hauteur, int largeur){
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.grille=new Case[hauteur][largeur];
		
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				grille[i][j]=new Case(i, j, ' ');
			}
		}
	}
	
	
	/**
	 * recuperation d'un case de la grille 
	 * @param lig indice de la ligne de la grille
	 * @param col indice de la colonne de la grille 
	 * @return la case au coordonée lig,col
	 */
	public Case getCase(int lig, int col) {
		if(grille[lig][col].getLig()==lig && grille[lig][col].getCol()==col)
			return grille[lig][col];
		return null;
	}
	
	/**
	 * recupere le nombre de ligne
	 * @return le nombre de ligne de la grille
	 */
	public int nbLig() {
		return this.hauteur;
	}
	
	/**
	 * recupere le nombre de colonne de la grille 
	 * @return la valeur de la variable largueur
	 */
	public int nbCol() {
		return this.largeur;
	}

	@Override
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	/**
	 * fonction qui permet de d'avoir une copy de la grille 
	 * @return une nouvelle instance qui la copie de la grille acutel 
	 */
	public Grille copy() {
		Grille copy=new Grille(hauteur, largeur);
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				copy.grille[i][j]=new Case(i,j,this.grille[i][j].getChar());
			}
		}
		return copy;
	}

}
