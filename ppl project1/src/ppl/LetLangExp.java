package ppl;

import ppl.LetScanner.Token;

public class LetLangExp {

	Token expression;
	String name;
	Integer val;
	public void setVariable(String variable) {
		this.variable = variable;
	}

	String variable;

	public LetLangExp() {

	}

	public void setExpression(Token expression) {
		this.expression = expression;
	}

	public void setName(String name) {  
		this.name = name;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

}
