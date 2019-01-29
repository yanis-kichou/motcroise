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
		
		EnsembleLettre l1=new EnsembleLettre();
		EnsembleLettre l2=new EnsembleLettre();
		
		
		return 0;
	}

}
