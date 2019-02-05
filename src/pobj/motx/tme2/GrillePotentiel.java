package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

/**
 * 
 * @author yanis KICHOU 3703169
 *
 */

public class GrillePotentiel {
	
	//grillePlace grille vide avec des emplacement a remplir grace au dicionnaire
	private GrillePlaces grille;
	
	//dictionnaire a utiliser pour remplire la grille 
	private Dictionnaire dico;
	
	//la liste des mots pour chacun des emplacements 
	private List<Dictionnaire> motsPot;
	
	//liste des contrainte (les coordonnées des case ou ya collision entre un emplcement horizental et vertical
	private List<IContrainte> contraintes;
	
	//boolean qui renvoie si la grille est realisable ou pas 
	private boolean isRealisable;
	
	/**
	 * constructeur qui initialise les paramettre de la classe 
	 * @param gr grille vide a remplir 
	 * @param dicoComplet dictionnaire francais a utiliser pour remplir la grille 
	 */
	public GrillePotentiel(GrillePlaces gr, Dictionnaire dicoComplet) {
		this.grille = gr;
		this.dico = dicoComplet;
		Dictionnaire copy;
		contraintes = new ArrayList<>();
		motsPot = new ArrayList<>();
		for (Emplacement e : grille.getPlaces()) {
			copy = dicoComplet.copy();
			copy.filtreLongueur(e.size());

			for (int i = 0; i < e.size(); i++) {
				if (!e.getCase(i).isPleine() && !e.getCase(i).isVide()) {
					copy.filtreParLettre(e.getCase(i).getChar(), i);
				}
			}
			motsPot.add(copy);
		}
		int h = grille.getNbHorizontal();

		for (int i = 0; i < h; i++) {

			for (int j = h; j < grille.getPlaces().size(); j++) {
				chercherContrainte(grille.getPlaces().get(i), i, grille.getPlaces().get(j), j);
			}
		}
		for (IContrainte c : contraintes) {
			((CroixContrainte) c).reduce(this);
		}
		isRealisable=propage();
	}

	
	/**
	 * verifie que pour chaque emplacement il exit un mot qui peut etre mit dedant 
	 * @return vrai s'il exite un dictionnaire vide faux sinon 
	 */
	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if (d.size() == 0)
				return true;
		}
		return false;
	}

	/**
	 * appliquer la fonction reduce sur les contrainte 
	 * @return vrai s'il n y'a plus de mot a eliminer et false s'il exite un dictionnaire vide (pas de possibilité pour un emplacement )
	 */
	private boolean propage() {
		while (true) {
			int eliminer=0;
			for (IContrainte iContrainte : contraintes) {
				if (isDead()) {
					return false;
				}
				eliminer+=((CroixContrainte)iContrainte).reduce(this);
			}
			if(eliminer==0)
				return true;
		}
	}

	
	/**
	 * fonction qui fixe une solution a un emplcament donner 
	 * @param m emplcament ou fixer la solution 
	 * @param soluce la solution a fixé dans l'emplacement 
	 * @return nouvelle grillePotentiel avec la solution soluce appliquer a l'emplacement m 
	 */
	public GrillePotentiel fixer(int m, String soluce) {

		return new GrillePotentiel(grille.fixer(m, soluce), dico);
	}

	
	/**
	 * cherche et trouve tout les croisement entre deux Emplcament horizental et Vertical a indice m1 et m2
	 * @param h emplecement Horizentale 
	 * @param m1 indice de l'emplacement 
	 * @param v enmplacement Vertical 
	 * @param m2 indice de l'emplacement 
	 */
	private void chercherContrainte(Emplacement h, int m1, Emplacement v, int m2) {
		for (int i = 0; i < h.size(); i++) {
			for (int j = 0; j < v.size(); j++) {

				if ((h.getCase(i).getCol() == v.getCase(j).getCol())
						&& (h.getCase(i).getLig() == v.getCase(j).getLig())) {
					if (h.getCase(i).isVide()) {
						contraintes.add(new CroixContrainte(m1, i, m2, j));
					}
				}
			}
		}
	}

	
	/**
	 * recuperer la liste des dictionnaire de grille 
	 * @return motsPot la liste des Dctionnaire de la grille
	 */
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	

	/**
	 * recuperer les contraite trouver 
	 * @return la liste des contraintes de la grille 
	 */
	public List<IContrainte> getContraintes() {
		return contraintes;
	}

	/**
	 * fonction qui retourne si la grille est reaslisable ou pas 
	 */
	public boolean getRealisable() {
		return isRealisable;
	}
	/**
	 * recuperer la grille contenu dans la grillePotentiel
	 * @return grille 
	 */
	public GrillePlaces getGrillePlaces() {
		// TODO Auto-generated method stub
		return grille;
	}
	
	@Override
	public String toString() {
		String s="";
		for(int i=0;i<grille.getGrille().nbLig();i++) {
			for (int j = 0; j < grille.getGrille().nbCol(); j++) {
				s+=grille.getGrille().getCase(i, j).getChar()+" \t";
			}
			s+="\n";
		}
		return s;
	}
}
