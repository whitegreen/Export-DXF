package tests;

import dxf.DXF;
import dxf.LaserDecimal;

/**
 * @author Hao Hua,  whitegreen@163.com 
 * 
 * Southeast University, http://labaaa.org
 * 
 * Built on CADSoftTools (https://cadsofttools.com)
 * 
 */

public class DrawLaserCutDigits { // The font of digits are designed for laser cut

	public static void main(String[] s) {
		new DrawLaserCutDigits();
	}

	public DrawLaserCutDigits() {
		int value = 567891234;
		double[][][] arr = LaserDecimal.digits("" + value); // font for laser cut

		DXF dxf = new DXF();
		for (double[][] ps : arr)
			dxf.polyC2D(ps);
		dxf.save("/Users/huahao/Desktop/cut_digits.dxf");
	}

}
