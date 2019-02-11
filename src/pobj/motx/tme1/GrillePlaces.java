package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {

	private Grille grille;
	private List<Emplacement> places;
	private int horizontal;

	/**
	 * construire une grillePlaces remplie
	 * recupere les mot se situant dans la grille (Horizental et vertical)
	 * @param gr la grille remplie de mot 
	 */
	public GrillePlaces(Grille gr) {

		this.grille = gr;
		places = new ArrayList<>();
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		horizontal = places.size();
		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlaces(getCol(i));
		}
	}

	/**
	 * recuperation de tout les mots constituant la grille
	 * @return la liste des emplacement des mots 
	 */
	public List<Emplacement> getPlaces() {
		return places;
	}

	/**
	 * recupere une ligne de la grille
	 * @param lig qui indique la ligne a recupere
	 * @return la liste des cases constituant la ligne lig de la grille 
	 */
	private List<Case> getLig(int lig) {

		List<Case> nombreMot = new ArrayList<>();

		for (int i = 0; i < grille.nbCol(); i++)
			nombreMot.add(grille.getCase(lig, i));

		return nombreMot;
	}
	
	/**
	 * recupere les cases d'un colonne donner 
	 * @param col qui indique l'indice de la colonne a recupere
	 * @return la liste des cases constituant la colonne
	 */
	private List<Case> getCol(int col) {
		List<Case> nombreMot = new ArrayList<>();
		for (int i = 0; i < grille.nbLig(); i++)
			nombreMot.add(grille.getCase(i, col));

		return nombreMot;
	}

	/**
	 * recherche des mots se situant sur une liste de cases
	 * @param cases liste de cases 
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();

		for (Case c : cases) {
			if (!c.isPleine()) {
				e.addCase(c);
			} else {
				if (e.size() > 1)
					places.add(e);
				e = new Emplacement();
			}
		}
		if (e.size() > 1)
			places.add(e);

	}

	/**
	 * recupere le nombre de mots horizentaux
	 * @return le nombre de mot Horizentaux
	 */
	public int getNbHorizontal() {
		return horizontal;
	}
	
	/**
	 * fonction qui permet de fixer une solution a emplacement donnée
	 * @param m l'indice de l'emplacement ou fixer la solution
	 * @param soluce la solution a fixer
	 * @return grillePlace avec la solution fixer
	 */
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces copy=new GrillePlaces(this.grille.copy());
		Emplacement e=copy.getPlaces().get(m);
		for (int i = 0; i<e.size(); i++) {
			e.getCase(i).setChar(soluce.charAt(i));
		}
		for (int i = 0; i < e.size(); i++) {
			int lig=e.getCase(i).getLig();
			int col= e.getCase(i).getCol();
			copy.grille.getCase(lig,col).setChar(e.getCase(i).getChar());
		}
		return copy;
		
	}

	@Override
	public String toString() {
		String s = "";
		for (Emplacement e : places) {
			s += e.toString() + " Case :";
			for (int i = 0; i < e.size(); i++) {
				s += e.getCase(i);
			}
			s += '\n';
		}
		return s;
	}

	/**
	 * getter qui permet de recupere la grille de la place 
	 * @return la grille de la classe
	 */
	public Grille getGrille() {
		// TODO Auto-generated method stub
		return grille;
	}

}
