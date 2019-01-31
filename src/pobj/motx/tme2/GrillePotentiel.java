package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;

	public GrillePotentiel(GrillePlaces gr, Dictionnaire dicoComplet) {
		this.grille = gr;
		this.dico = dicoComplet;
		Dictionnaire copy;
		System.out.println(gr.getPlaces());
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
		List<Emplacement> h = getHorizental(), v = getVertical();

		for (int i = 0; i < h.size(); i++) {

			for (int j = 0; j < v.size(); j++) {
				System.out.println("i=" + i + " j=" + j);

				chercherContrainte(h.get(i), i, v.get(j), j);
			}
		}

	}

	public boolean isDead() {
		for (Dictionnaire d : motsPot) {
			if (d.size() == 0)
				return true;
		}
		return false;
	}

	public GrillePotentiel fixer(int m, String soluce) {

		return new GrillePotentiel(grille.fixer(m, soluce), dico);
	}

	private List<Emplacement> getHorizental() {
		List<Emplacement> horizental = new ArrayList<>();
		for (int i = 0; i < grille.getNbHorizontal(); i++) {
			horizental.add(grille.getPlaces().get(i));
		}

		return horizental;
	}

	private List<Emplacement> getVertical() {
		List<Emplacement> vertical = new ArrayList<>();
		for (int i = grille.getNbHorizontal(); i < grille.getPlaces().size(); i++) {
			vertical.add(grille.getPlaces().get(i));
		}

		return vertical;
	}

	private void chercherContrainte(Emplacement h, int m1, Emplacement v, int m2) {

		contraintes = new ArrayList<>();

		for (int i = 0; i < h.size(); i++) {
			for (int j = 0; j < v.size(); j++) {

				if (h.getCase(i).getCol() == v.getCase(j).getCol() && h.getCase(i).getLig() == v.getCase(j).getLig()) {
					if (h.getCase(i).isVide()) {
						System.out.println("m1 " + m1 + " c1 " + i + " m2 " + m2 + " c2 " + j);
						contraintes.add(new CroixContrainte(m1, i,m2, j));
					}
				}
			}
		}
	}

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public List<IContrainte> getContraintes() {
		// TODO Auto-generated method stub
		System.out.println("[ ");
		for (IContrainte c : contraintes)
			System.out.println(((CroixContrainte) c).toString());
		System.out.println(" ]");
		return contraintes;
	}

	public GrillePlaces getGrillePlaces() {
		// TODO Auto-generated method stub
		return grille;
	}
}
