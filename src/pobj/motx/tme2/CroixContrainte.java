package pobj.motx.tme2;
/**
 * 
 * @author yanis KCIHOU 3703169
 *
 */


public class CroixContrainte implements IContrainte{
	//variable qu stock l'indice de l'emplacement 1
	private int m1;
	
	//variable qu stock l'indice de l'emplacement 2
	private int m2;
	
	//numero de la case de l'emplacement 1 ou figure une contrainte 
	private int c1;
	
	//numero de la case de l'emplacement 2 ou figure une contrainte
	private int c2;
	
	/**
	 * Constructeur de la classe CroixContraite qui permet d'initialiser les variblae 
	 * @param m1 indice de l'emplacement 1 ou ya croisement de deux case 
	 * @param c1 indice de la case ou ya croisement de l'emplacement 1 
	 * @param m2 indice de l'emplacement 2 ou ya croisement entre deux case 
	 * @param c2 indice de la case de l'emplacement deux ou figure le croisement 
	 */
	public CroixContrainte(int m1,int c1, int m2,int c2) {
		this.m1=m1;
		this.m2=m2;
		this.c1=c1;
		this.c2=c2;
	}
	/**
	 * fonction qui prend en paramettre une grille (GrillePotentiel)
	 * et filtre les dictionnaires grace a des contraite afin de garder que les mots possible dans un croisement de deux Emplacements
	 */
	@Override
	public int reduce(GrillePotentiel grille) {
		
		EnsembleLettre l1=grille.getMotsPot().get(m1).getLettres(c1);
		EnsembleLettre l2=grille.getMotsPot().get(m2).getLettres(c2);
		
		EnsembleLettre s=l1.intersection(l2);
		int cpt1=0,cpt2=0;
		if(l1.size()>s.size()) {
			cpt1=grille.getMotsPot().get(m1).filtreParLettre(c1,s);
		}
		
		if(l2.size()>s.size()) {
			cpt2=grille.getMotsPot().get(m2).filtreParLettre(c2,s);
		}
		
		return cpt1+cpt2;
	}
	@Override
	public String toString() {
		return "(("+m1+" , "+c1+") , ("+m2+" , "+c2+") ) ";
	}
	
	@Override
	public boolean equals(Object other) {
		if(this==other)
			return true;
		if(!(other instanceof CroixContrainte))
			return false;
		CroixContrainte o=(CroixContrainte)other;
		return this.m1==o.m1 && this.m2==o.m2 && this.c1==o.c1 && this.c2==o.c2;
	}
}
