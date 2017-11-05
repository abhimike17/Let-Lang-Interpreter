package ppl;

import java.util.HashMap;
import java.util.Stack;

@SuppressWarnings("unused")
public class LetlangEnv {
	public static Stack<Environment> stack = new Stack<Environment>();
	public static Integer value;
	public static String name;

	public LetlangEnv() {

	}

	public static Stack<Environment> getStack() {
		return stack;
	}

	public static void setStack(Stack<Environment> stack) {
		LetlangEnv.stack = stack;
	}

	public static Integer getValue() {
		return value;
	}

	public static void setValue(Integer value) {
		LetlangEnv.value = value;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		LetlangEnv.name = name;
	}

	public void empty_env() {
		// H = new HashMap<String, Integer>();

	}

	public LetlangEnv extendEnv(LetlangEnv LLE, String x, Integer i) {
		Environment LEn = new Environment();
		LEn.setI(i);
		LEn.setV(x);
		LetlangEnv.stack.push(LEn);
		return LLE;
	}

	public IntBool Applyenv(LetlangEnv env, String x) {
		IntBool ib = null;
		for (Environment en : LetlangEnv.getStack()) {
			if (en.v.equalsIgnoreCase(x)) {
				ib = new IntBool(en.getI(), false);
			}
		}
		return ib;
	}
}
