package ppl;

public class VarExp extends LetLangExp {

	public String v;
	

	public VarExp(String v) {
		this.v = v;
		this.name = "VarExp";
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}
	
	

}
