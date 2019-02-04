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
		contraintes=new ArrayList<>();
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
		for (IContrainte c:contraintes) {
			((CroixContrainte)c).reduce(this);
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

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public List<IContrainte> getContraintes() {
		return contraintes;
	}

	public GrillePlaces getGrillePlaces() {
		// TODO Auto-generated method stub
		return grille;
	}
}
