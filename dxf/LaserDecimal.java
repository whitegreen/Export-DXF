package dxf;

/**
 * @author Hua Hao   whitegreen@163.com
 * Built on  CADSoftTools (https://cadsofttools.com)
 */

public class LaserDecimal {

	private static double gap=2.7;

	public static double[][][] digits(String st) {
		int len = st.length();
		double[][][] re = new double[len][][];
		for (int i = 0; i < len; i++) {
			Character ch = st.charAt(i);
			double[] p = { i * gap, 0 };
			re[i] = digit(Integer.parseInt("" + ch), p);
		}
		return re;
	}

	public static double[][] digit(int num, double[] ori) {
		double[][] arr = null;
		switch (num) {
		case 0:
			arr = regularPoly(12, 1);
			break;
		case 1:
			arr = new double[][] { {0.5, 0} ,{0.5,2.5},{1.5,3}, {1.5,0} };
			break;
		case 2:
			arr = new double[][] { { 0, 0 }, {0.75,2},{0,2},{0,2.5},{2,3},{1.25,1},{2,1},{2,0} };
			break;
		case 3:
			arr = regularPoly(num,1.1);
			break;
		case 4:
			arr =  regularPoly(num,1.1);
			break;
		case 5:
			arr =  regularPoly(num,1.1);
			break;
		case 6:
			arr =  regularPoly(num,1.1);
			break;
		case 7:
			arr = new double[][] { { 0, 0 }, { 1, 2 }, { 0, 2 } ,{0,2.5},{2,3},{2,2},{1,0} };
			break;
		case 8:
			arr = new double[][] { { 0, 0 }, { 0.5, 1.5 }, { 0, 3 }, { 2, 3 }, { 1.5, 1.5 },{2,0} };
			break;
		case 9:
			arr = new double[][] { { 1, 0 }, { 1, 1.5 }, {0,2},{ 0, 2.5 }, { 1, 3 },{2,3},{2,0} };
			break;
		}
		for(double[] p: arr)
			M._add(p, ori);
		return arr;
	}
	
	public static double[][] regularPoly(int n, double r) {
		double[][] ps = new double[n][];
		for (int i = 0; i < n; i++) {
			double ang = i * 2 * Math.PI / n;
			ps[i] = new double[] { 1 + r * Math.sin(ang), 1.5 + r * Math.cos(ang) };
		}
		return ps;
	}

}
