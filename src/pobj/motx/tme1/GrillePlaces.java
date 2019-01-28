package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {

	private Grille grille;
	private List<Emplacement> places;
	private int horizontal;

	public GrillePlaces(Grille grille) {

		this.grille = grille;
		places = new ArrayList<>();
		horizontal = 0;
		int col = grille.nbCol();
		int lig = grille.nbLig();
		Emplacement m;
		for (int i = 0; i < lig; i++) {
			int j = 0;
			m = new Emplacement();
			while (j < col) {
				while (j < col && grille.getCase(i, j).isPleine()) {
					j++;
					System.out.println(j);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("la");
				if (j + 1 < col && !grille.getCase(i, j + 1).isPleine()) {
					while (j < col && grille.getCase(i, j).isPleine()) {
						m.addCase(grille.getCase(i, j));
						System.out.println(m.size());
						j++;
					}
					if (m.size() > 0) {
						places.add(m);
						horizontal++;
						m = new Emplacement();
					}
				} else
					j++;
			}

		}
		System.out.println(horizontal);
		for (int j = 0; j < col; j++) {
			int i = 0;
			m = new Emplacement();
			while (i < lig) {
				while (i < lig && (grille.getCase(i, j).isPleine()))
					i++;
				if (i + 1 < lig && !grille.getCase(i+1, j).isPleine()) {
					while (i < lig && !grille.getCase(i, j).isPleine()) {
						m.addCase(grille.getCase(i, j));
						i++;
					}
					if (m.size() > 0) {
						places.add(m);
						m=new Emplacement();
					}
				}else
					i++;
			}
			
		}
	}

	private List<Case> getLig(int lig) {
		List<Case> nombreMot = new ArrayList<>();
		int j = 0;
		while (j < grille.nbCol()) {
			while (j < grille.nbCol() && (grille.getCase(lig, j).isPleine() || grille.getCase(lig, j).isVide()))
				j++;
			if (j + 1 < grille.nbCol() && !grille.getCase(lig, j + 1).isPleine() && !grille.getCase(lig, j).isVide()) {
				while (j < grille.nbCol() && !grille.getCase(lig, j).isPleine() && !grille.getCase(lig, j).isPleine()) {

				}
			}
		}

		return nombreMot;
	}

	public List<Emplacement> getPlaces() {
		return places;
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
