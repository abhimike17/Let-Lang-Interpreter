package ppl;

public class LetExp extends LetLangExp {

	public VarExp variable;
	private LetLangExp e1; 
	private LetLangExp e2; 

	public LetExp() {
		
		this.name = "LetExp";
	}

	public VarExp getVariable() {
		return variable;
	}

	public LetLangExp getE1() {
		return e1;
	}

	public LetLangExp getE2() {
		return e2;
	}

	public void setVariable(VarExp variable) {
		this.variable = variable;
	}

	public void setE1(LetLangExp e1) {
		this.e1 = e1;
	}

	public void setE2(LetLangExp e2) {
		this.e2 = e2;
	}

}
