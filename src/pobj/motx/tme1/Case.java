package pobj.motx.tme1;

public class Case {
	/**
	 * lig abscisse  de la case
	 * col coordonnées de la case
	 */
	private int lig,col;
	private char c;

	/**
	 * Constructeur Qui permet de crée une case 
	 * @param lig abscisse de la casse
	 * @param col cordonée  de la case 
	 * @param c le caractere stocker dans la case 
	 */
	public Case(int lig, int col, char c) {
		this.lig=lig;
		this.col=col;
		this.c=c;
	}
	
	/**
	 * getter qui permet d'aceder a l'abscisse de la case 
	 * @return l'abscisse de la case 
	 */
	public int getLig() {
		return lig;
	}
	
	/**
	 * getter qui permet de recupere la l'ordonnée de la case 
	 * @return l'ordonnée de la case 
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * gettr qui permet de recupere le caractere stocker dans la case 
	 * @return le caractere contenu dans la case 
	 */
	public char getChar() {
		return c;
	}

	/**
	 * accesseur permettant de modifier le caractere stocker dans la case 
	 * @param c avec qui l'ont modifie la le caractere char de la case 
	 */
	public void setChar(char c) {
		this.c=c;
	}
	 /**
	  * verfication que la case est vide 
	  * @return true si elle est vide et false sinon 
	  */
	public boolean isVide() {
		return c==' ';
	}
	
	/**
	 * verfication si la case est pleine (comporte *) 
	 * @return true si elle est pleine false sinon 
	 */
	public boolean isPleine() {
		return c=='*';
	}
	
	@Override
	public String toString() {
		return "( "+lig+" , "+col+" ) ";
	}
}
