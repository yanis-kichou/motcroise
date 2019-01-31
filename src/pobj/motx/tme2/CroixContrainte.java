package pobj.motx.tme2;

public class CroixContrainte implements IContrainte{
	
	private int m1;
	private int m2;
	private int c1;
	private int c2;
	
	public CroixContrainte(int m1,int c1, int m2,int c2) {
		this.m1=m1;
		this.m2=m2;
		this.c1=c1;
		this.c2=c2;
	}
	
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
	
	
	public boolean equals(Object other) {
		if(this==other)
			return true;
		if(!(other instanceof CroixContrainte))
			return false;
		CroixContrainte o=(CroixContrainte)other;
		return this.m1==o.m1 && this.m2==o.m2 && this.c1==o.c1 && this.c2==o.c2;
	}
}
