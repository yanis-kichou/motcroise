package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {

	private List <Case> lettres;
	public Emplacement() {
		lettres= new ArrayList<Case>();
	}
	
	public String toString() {
		String s="";
		for(Case c:lettres) {
			s+=c.getChar();
		}
		return s;
	}

	public void addCase(Case s) {
		lettres.add(s);
	}
	
	public Case getCase(int i) {
		return lettres.get(i);
	}
	
	public int size() {
		return lettres.size();
	}
}
