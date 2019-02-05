package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {

	/**
	 * lettres liste de Case contenu dans l'emplacement  
	 */
	private List <Case> lettres;
	public Emplacement() {
		lettres= new ArrayList<Case>();
	}
	
	@Override
	public String toString() {
		String s="";
		for(Case c:lettres) {
			s+=c.getChar();
		}
		return s;
	}

	/**
	 * fonction permettant d'ajouter une case dans une meplacement 
	 * @param s la case a ajouter dans l'emplacement 
	 */
	public void addCase(Case s) {
		lettres.add(s);
	}
	
	/**
	 * recupere une case de l'emplacmeent 
	 * @param i l'indice de la case a recupere
	 * @return la case a l'indice i de l'emplacement  
	 */
	public Case getCase(int i) {
		return lettres.get(i);
	}
	
	/**
	 * retourn la taille de l'emplacement 
	 * @return la taille de l'emplacement 
	 */
	public int size() {
		return lettres.size();
	}
	
	public boolean hasCaseVide() {
		for(Case c:lettres) {
			if(c.isVide())
				return true;
		}
		return false;
	}
}
