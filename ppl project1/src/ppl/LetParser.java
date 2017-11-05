package ppl;

//import java.util.LinkedList;
import java.util.*;

import ppl.LetScanner.Token;

public class LetParser {

	public static LinkedList<Token> firsttoken = new LinkedList<>();
	public static LinkedList<Token> secondtoken = new LinkedList<>();
	public static Token tok;
	public static int index = 0;

	public static Queue<LetLangExp> DQueue = new LinkedList<LetLangExp>();
	public static Queue<LetLangExp> DQueue1 = new LinkedList<LetLangExp>();

	@SuppressWarnings("unchecked")
	public void getfirsttoken() {
		String input = "let x = 7\n" + "in let y = 2\n" + "in let y =\n" + "let x = -(x, 1) in -(x, y)\n"
				+ "in -(-(x, 8), y)";
		firsttoken = LetScanner.lex(input);
		secondtoken = (LinkedList<Token>) LetParser.firsttoken.clone();
	}

	public LetLangExp parseToken() {
		LetLangExp LLE = new LetLangExp();
		switch (tok.type.toString()) {
		case ("Integeri32"):
			LLE = number();
			break;
		case ("Minus"):
			LLE = minus();
			break;
		case ("IsZero"):
			break;
		case ("Ifexp"):
			break;
		case ("Letexp"):
			LLE = letExp();
			break;
		case ("Identifier"):
			LLE = identifier();
			break;
		default:
			gtoken();
			parseToken();
		}
		return LLE;

	}

	public ConstExp number() {
		ConstExp e1 = new ConstExp();
		e1.setValue(Integer.parseInt(tok.data.toString()));
		System.out.println("Integeri32 : " + tok.type);
		gtoken();
		return e1;

	}

	public void lParen() {

		System.out.println("Lparen : " + tok.type);
		gtoken();
	}

	public void comma() {
		System.out.println("Comma :" + tok.type);
		gtoken();
	}

	public void rParen() {

		System.out.println("Rparen : " + tok.type);
		gtoken();
	}

	public DiffExp minus() {
		System.out.println("Minus : " + tok.type);
		DiffExp de = new DiffExp();
		new LetLangExp();
		gtoken();
		lParen();
		de.setE1(parseToken());
		comma();
		de.setE2(parseToken());
		rParen();
		return de;
	}

	public VarExp identifier() {
		System.out.println("Identifier :" + tok.type);
		VarExp v = new VarExp(tok.data.toString());
		gtoken();
		return v;
	}

	public void assign() {
		System.out.println("Assign :" + tok.type);
		gtoken();
	}

	public void in() {
		System.out.println("Inexp :" + tok.type);
		gtoken();
	}

	public LetExp letExp() {

		LetExp exp = new LetExp();
		new LetLangExp();
		System.out.println("LetExp :" + tok.type);
		gtoken();
		exp.setVariable(identifier());
		assign();
		exp.setE1(parseToken());
		in();
		exp.setE2(parseToken());
		DQueue.add(exp);

		return exp;
	}

	public void gtoken() {

		firsttoken.pop();
		if (!firsttoken.isEmpty()) {
			tok = firsttoken.getFirst();
		}
	}

	public static void main(String args[]) {

		LetParser letParser = new LetParser();
		letParser.getfirsttoken();
		tok = firsttoken.getFirst();
		letParser.parseToken();
		Evaluate EV = new Evaluate();
		DQueue1.add((LetLangExp) DQueue.toArray()[DQueue.size() - 1]);
		LetlangEnv env = new LetlangEnv();
		LetLangExp value = EV.evaluateParse(DQueue1, env);
		System.out.println("Expression value is : " + value.val);
	}

}