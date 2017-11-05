package ppl;

public class ConstExp extends LetLangExp {

	private int value;

	public ConstExp() {
		this.name = "ConstExp";
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
