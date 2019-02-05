package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable {

	private GrillePotentiel gp;
	private Emplacement mot;
	private int index;
	private Dictionnaire d;
	public DicoVariable(int index, GrillePotentiel gp) {
		this.gp=gp;
		mot=gp.getGrillePlaces().getPlaces().get(index);
		this.index=index;
		d=gp.getMotsPot().get(index);
	}
	@Override
	public List<String> getDomain() {
		return d.getMotsDico();
	}

	
	public Emplacement getEmplacement() {
		return mot;
	}
	
	
	public GrillePotentiel getGrillePotentiel() {
		return gp;
	}
	
	
	@Override
	public String toString() {
		String s="";
		s+=" Emplcament "+index+" \n Domaines :";
		for(String c:d.getMotsDico()) {
			s+=c+" ";
		}
		return s;
	}
	public int getIndex() {
		return index;
	}
}
