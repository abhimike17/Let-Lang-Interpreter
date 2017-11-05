package ppl;

import java.util.*;

public class Evaluate {

	//LetlangEnv env1 = new LetlangEnv();

	String gvalue;

	public Evaluate() {

	}

	@SuppressWarnings("static-access")
	public LetLangExp evaluateParse(Queue<LetLangExp> tokens, LetlangEnv env) {

		LetLangExp EV = tokens.poll();
		//System.out.println();
		Queue<LetLangExp> EP = new LinkedList<LetLangExp>();
		switch(EV.name) {
		case("LETEXP"):
			LetLangExp LL1 = new LetLangExp();
			LetExp LE = (LetExp) EV;
			VarExp EV1 = LE.getVariable();
			gvalue = EV1.getV();
			EV = LE.getE1();
			EP.add(EV);
			LL1 = evaluateParse(EP, env);
			LE.val = LL1.val;
			// LetlangEnv.name = gvalue;
			// LetlangEnv.value = LE.val;
			env = env.extendEnv(env, EV1.v, LE.val);
			LetlangEnv copyoforiginal = env;
			// System.out.println(LetlangEnv.value);
			EV = LE.getE2();// 1
			EP.add(EV);
			LL1 = evaluateParse(EP, copyoforiginal);// 2
			env.stack.pop();
			//System.out.println("print:" + LE.val);
				return LL1;
		case("ConstExp"):
			ConstExp CE = (ConstExp) EV;
			CE.val = CE.getValue();
				return CE;
		case("DiffExp"):
			DiffExp DE = (DiffExp) EV;
			EV = DE.getE1();
			EP.add(EV);
			LetLangExp ev = evaluateParse(EP, env);
			DE.setE1(ev);
			EV = DE.getE2();
			EP.add(EV);
			LetLangExp ev1 = evaluateParse(EP, env);
			DE.setE2(ev1);
			DE.setValue(DE.getValue());
			System.out.println("In diff");
			EV.val = DE.val;
				return EV;
		case("VarExp"):
			VarExp VE = (VarExp) EV;
			// VE.val = env.H.get(VE.getV());
			IntBool ib = env.Applyenv(env, VE.getV());
			System.out.println("Var Exp");
			VE.variable = VE.getV();
			VE.val = ib.i;
				return VE;
			
			
		/*if (EV.name.equalsIgnoreCase("LETEXP")) {
			LetLangExp LL1 = new LetLangExp();
			LetExp LE = (LetExp) EV;
			VarExp EV1 = LE.getVariable();
			
			gvalue = EV1.getV();
			EV = LE.getE1();
			EP.add(EV);
			LL1 = evaluateParse(EP, env);
			LE.val = LL1.val;
			// LetlangEnv.name = gvalue;
			// LetlangEnv.value = LE.val;
			env = env.extendEnv(env, EV1.v, LE.val);
			LetlangEnv copyoforiginal = env;
			// System.out.println(LetlangEnv.value);
			EV = LE.getE2();// 1
			EP.add(EV);
			LL1 = evaluateParse(EP, copyoforiginal);// 2
			env.stack.pop();
			//System.out.println("print:" + LE.val);
			return LL1;

		} else if (EV.name.equalsIgnoreCase("ConstExp")) {
			ConstExp CE = (ConstExp) EV;
			CE.val = CE.getValue();
			return CE;
		} else if (EV.name.equalsIgnoreCase("DiffExp")) {

			DiffExp DE = (DiffExp) EV;
			EV = DE.getE1();
			EP.add(EV);
			LetLangExp ev = evaluateParse(EP, env);
			DE.setE1(ev);
			EV = DE.getE2();
			EP.add(EV);
			LetLangExp ev1 = evaluateParse(EP, env);
			DE.setE2(ev1);
			DE.setValue(DE.getValue());
			System.out.println("In diff");
			EV.val = DE.val;
			return EV;
		} else if (EV.name.equalsIgnoreCase("VarExp")) {
			VarExp VE = (VarExp) EV;
			// VE.val = env.H.get(VE.getV());
			IntBool ib = env.Applyenv(env, VE.getV());
			System.out.println("Var Exp");
			VE.variable = VE.getV();
			VE.val = ib.i;
			return VE;*/

		}
		
		return EV;
	}

}
