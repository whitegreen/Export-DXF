package dxf;

import java.util.ArrayList;
import dxfExporter.DXFData;
import dxfExporter.DXFExport;
import dxfExporter.DXFPoint;

/**
 * @author Hua Hao   whitegreen@163.com
 * Built on  CADSoftTools (https://cadsofttools.com)
 */

public class Shape {

	public static void lines2D(DXFExport wt, DXFData dt, float[][] lines) { // 2d
		for (float[] line : lines) {
			dt.Point = new DXFPoint(line[0], line[1], 0);
			dt.Point1 = new DXFPoint(line[2], line[3], 0);
			wt.addLine(dt);
		}
	}

	public static void line(DXFExport wt, DXFData dt, float[] a, float[] b) {
		dt.Point = new DXFPoint(a[0], a[1], a[2]);
		dt.Point1 = new DXFPoint(b[0], b[1], b[2]);
		wt.addLine(dt);
	}

	public static void poly2D(DXFExport wt, DXFData dt, float[][] ps) {
		dt.Count = ps.length;
		dt.Points = new ArrayList<DXFPoint>(ps.length);
		for (float[] p : ps)
			dt.Points.add(new DXFPoint(p[0], p[1], 0));
		wt.addPolyline(dt);
	}

	public static void polyC2D(DXFExport wt,DXFData dt, float[][] ps) {
		dt.Count = ps.length + 1;
		dt.Points = new ArrayList<DXFPoint>(ps.length + 1);
		for (float[] p : ps)
			dt.Points.add(new DXFPoint(p[0], p[1], 0));
		float[] p = ps[0];
		dt.Points.add(new DXFPoint(p[0], p[1], 0));
		wt.addPolyline(dt);
	}

	public static void circle(DXFExport wt,DXFData dt, float[] p, float radius) {
		dt.Point = new DXFPoint(p[0], p[1], 0);
		dt.Radius = radius;
		wt.addCircle(dt);
	}
	public static void polyC2D(DXFExport wt,DXFData dt, double[][] ps) {
		dt.Count = ps.length + 1;
		dt.Points = new ArrayList<DXFPoint>(ps.length + 1);
		for (double[] p : ps)
			dt.Points.add(new DXFPoint( (float)p[0],  (float)p[1], 0));
		double[] p = ps[0];
		dt.Points.add(new DXFPoint( (float)p[0],  (float)p[1], 0));
		wt.addPolyline(dt);
	}
	
	public static void arc(DXFExport wt,DXFData dt, float[] p,  float stAng, float endAng, float radius) {
	 dt.Point = new DXFPoint(p[0], p[1], 0);
     dt.StartAngle = stAng;
     dt.EndAngle = endAng;
     dt.Radius = radius;
     wt.addArc(dt);
	}

}
