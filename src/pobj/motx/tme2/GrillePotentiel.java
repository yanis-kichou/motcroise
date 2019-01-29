package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;

	public GrillePotentiel(GrillePlaces gr, Dictionnaire dicoComplet) {
		this.grille = gr;
		this.dico = dicoComplet;
		Dictionnaire copy;
		motsPot = new ArrayList<>();
		for (Emplacement e : grille.getPlaces()) {
			copy = dico.copy();
			copy.filtreLongueur(e.size());
		for (int i = 0; i < e.size(); i++) {
			if(!e.getCase(i).isPleine() && !e.getCase(i).isVide()) {
				copy.filtreParLettre(e.getCase(i).getChar(), i);
			}
		}
			motsPot.add(copy);
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
	
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}
}
