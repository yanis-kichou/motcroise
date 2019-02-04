package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yanis KICHOU 3703169
 *
 */
public class EnsembleLettre {

	//liste de charactere de l'ensembleLettre
	private List<Character> ens;
	
	/**
	 * Constructeur qui initialise l'attribut ens 
	 */
	public EnsembleLettre() {
		ens=new ArrayList<>();
	}

	/**
	 * ajout d'un caractere dans l'ensemble
	 * @param c caractere a ajouté dans l'ensemble 
	 */
	public void add(char c) {
		for (char e: ens ) {
			if(e==c)
				return;
		}
		ens.add(c);
	}
	
	
	/**
	 * recuperer la taille de l'ensemble
	 * @return la taille de l'enseble 
	 */
	public int size() {
		return ens.size();
	}
	
	/** 
	 * fonction qui verfie si un caractere existe dans l'ensemble ou pas 
	 * @param c le caractere a verifier son existance dans l'ensemble
	 * @return vrai si c est contenu dans l'ensemble et faux sinon
	 */
	public boolean contains(char c) {
		return ens.contains(c);
	}
	
	public EnsembleLettre intersection(EnsembleLettre e) {
		EnsembleLettre inter=new EnsembleLettre();
		for(char c:ens) {
			if(e.contains(c))
				inter.add(c);
		}
		return inter;
	}
	
	
	
}
