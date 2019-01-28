package pobj.motx.tme1;

import java.util.Iterator;

public class Grille {

	private Case[][] grille;
	private int hauteur,largeur;
	
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
	
	
	public Case getCase(int lig, int col) {
		if(grille[lig][col].getLig()==lig && grille[lig][col].getCol()==col)
			return grille[lig][col];
		return null;
	}
	
	
	public int nbLig() {
		return this.hauteur;
	}
	
	
	public int nbCol() {
		return this.largeur;
	}


	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
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
