package ppl;

public class DiffExp extends LetLangExp {

	LetLangExp e1;
	LetLangExp e2;
	public Integer gvalue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	private Integer value;
	public DiffExp() {
		this.name = "DiffExp";
	}

	public LetLangExp getE1() {
		return e1;
	}

	public LetLangExp getE2() {
		return e2;
	}

	public void setE1(LetLangExp e1) {
		this.e1 = e1;
	}

	public void setE2(LetLangExp e2) {
		this.e2 = e2;
	}

	public int getValue() {
		this.val = this.e1.val - this.e2.val;
		return this.e1.val - this.e2.val;
	}

}
