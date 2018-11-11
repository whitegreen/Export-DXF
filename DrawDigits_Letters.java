package tests;

import java.awt.Color;
import java.util.Random;
import dxf.DXF;
import dxf.Symbol;

/**
 * @author Hao Hua,  whitegreen@163.com 
 * 
 * Southeast University, http://labaaa.org
 * 
 * Built on CADSoftTools (https://cadsofttools.com)
 * 
 */

public class DrawDigits_Letters {

	public static void main(String[] s) {
		new DrawDigits_Letters();
	}

	public DrawDigits_Letters() {
		DXF dxf = new DXF();
		dxf.set("layer1", Color.WHITE);

		float w = 50;
		float h = 100;
		for (int i = -2; i < 10; i++) {
			dxf.poly2D(Symbol.digit(i, new float[] { i * (w + 20), 100 }, w, h));
		}

		dxf.set("layer2", Color.CYAN);
		Random ran = new Random(-998);
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(1000);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -1400, i * 130 }, w, h);
			for (float[][] pl : ps)
				dxf.poly2D(pl);
		}
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(100);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -900, i * 130 }, w, h);
			for (float[][] pl : ps)
				dxf.poly2D(pl);
		}
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(10);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -400, i * 130 }, w, h);
			for (float[][] pl : ps)
				dxf.poly2D(pl);
		}

		for (int i = 0; i < 12; i++) {
			float[][] ps = Symbol.alphabet(i, new float[] { -400, -2000 + i * 130 }, w, h);
			dxf.poly2D(ps);
		}

		dxf.save("/Users/huahao/Desktop/digits_letters.dxf");
	}
}
