package pobj.motx.tme3.csp;

public class CSPSolverCorrige {

	private ICSP prob;
	public ICSP solve(ICSP problem) {
		this.prob=problem;
		return new CSPSolver().solve(problem);
	}

}
