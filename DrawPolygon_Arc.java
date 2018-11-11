package tests;

import java.awt.Color;
import java.util.Random;
import dxf.DXF;

/**
 * @author Hao Hua,  whitegreen@163.com 
 * 
 * Southeast University, http://labaaa.org
 * 
 * Built on CADSoftTools (https://cadsofttools.com)
 * 
 */

public class DrawPolygon_Arc {

	Random ran = new Random();

	public static void main(String[] s) {
		new DrawPolygon_Arc();
	}

	public DrawPolygon_Arc() {
		int n = 12;
		float[][] ps = new float[n][];
		double ox = -100;
		double oy = 120;
		for (int i = 0; i < n; i++) {
			double ang = i * 2 * Math.PI / n;
			double cos = Math.cos(ang);
			double sin = Math.sin(ang);
			double r = ran.nextDouble() * 100 + 200;
			ps[i] = new float[] { (float) (ox + r * cos), (float) (oy + r * sin) };
		}
		float[][] poly = new float[n][];
		for (int j = 0; j < n; j++) {
			poly[j] = ps[j].clone();
			poly[j][0] += 640;
		}

		DXF dxf = new DXF();
		dxf.set("layer1", Color.WHITE);
		dxf.poly2D(ps); // open polygon

		dxf.set("layer2", Color.RED);
		dxf.polyC2D(poly); // closed polygon

		dxf.set("layer3", Color.GREEN);
		dxf.circle(new float[] { 0, 0 }, 100);
		dxf.circle(new float[] { 100, 100 }, 100);

		dxf.set("layer4", Color.BLUE);
		dxf.arc(new float[] { 350, 0 }, 30, 150, 100); // from 30 degree, to 150 degree
		dxf.arc(new float[] { 350, 0 }, 270, 360, 100); // from 270 degree to 360degree

		dxf.save("/Users/huahao/Desktop/poly_arc.dxf"); // put your folder directory here
	}

}
