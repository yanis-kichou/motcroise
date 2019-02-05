package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class MotX implements ICSP {

	private GrillePotentiel gp;
	private List<IVariable> dicoVariable;

	public MotX(GrillePotentiel gp) {
		this.gp = gp;
		dicoVariable=new ArrayList<>();
		for (int i = 0; i < gp.getGrillePlaces().getPlaces().size(); i++) {
			if (gp.getGrillePlaces().getPlaces().get(i).hasCaseVide()) {
				dicoVariable.add(new DicoVariable(i, gp));
			}
		}
	}

	@Override
	public List<IVariable> getVars() {
		return dicoVariable;
	}

	@Override
	public boolean isConsistent() {
		return gp.getRealisable();
	}

	public GrillePotentiel getGrillePotentiel() {
		return gp;
	}
	@Override
	public ICSP assign(IVariable vi, String val) {
		if (!(vi instanceof DicoVariable))
			return null;
		gp=gp.fixer(((DicoVariable)vi).getIndex(), val);
		return new MotX(gp);
	}

	@Override
	public String toString() {
		return gp.toString();
	}
}
