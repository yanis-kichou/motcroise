package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {

	private List<Character> ens;
	public EnsembleLettre() {
		ens=new ArrayList<>();
	}

	public void add(char c) {
		for (char e: ens ) {
			if(e==c)
				return;
		}
		ens.add(c);
	}
	
	public int size() {
		return ens.size();
	}
	
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
