package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {

	private Grille grille;
	private List<Emplacement> places;
	private int horizontal;

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

	public List<Emplacement> getPlaces() {
		return places;
	}

	private List<Case> getLig(int lig) {

		List<Case> nombreMot = new ArrayList<>();

		for (int i = 0; i < grille.nbCol(); i++)
			nombreMot.add(grille.getCase(lig, i));

		return nombreMot;
	}

	private List<Case> getCol(int col) {
		List<Case> nombreMot = new ArrayList<>();
		for (int i = 0; i < grille.nbLig(); i++)
			nombreMot.add(grille.getCase(i, col));

		return nombreMot;
	}

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

	public int getNbHorizontal() {
		return horizontal;
	}

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
}
