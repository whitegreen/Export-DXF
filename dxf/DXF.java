package dxf;

import java.awt.Color;
import java.util.ArrayList;

import dxfExporter.Constants;
import dxfExporter.DXFData;
import dxfExporter.DXFExport;
import dxfExporter.DXFLayer;
import dxfExporter.DXFPoint;

public class DXF {

	private DXFExport wt;
	private DXFData dt;

	public DXF() {
		wt = new DXFExport();
		wt.AutoCADVer = Constants.DXFVERSION_R2000;

		DXFLayer layer = new DXFLayer("default_layer");
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.WHITE));
	}

	public void lines2D(float[][] lines) { // 2d
		for (float[] line : lines) {
			dt.Point = new DXFPoint(line[0], line[1], 0);
			dt.Point1 = new DXFPoint(line[2], line[3], 0);
			wt.addLine(dt);
		}
	}

	public void line(float[] a, float[] b) {
		dt.Point = new DXFPoint(a[0], a[1], a[2]);
		dt.Point1 = new DXFPoint(b[0], b[1], b[2]);
		wt.addLine(dt);
	}

	public void poly2D(float[][] ps) {
		dt.Count = ps.length;
		dt.Points = new ArrayList<DXFPoint>(ps.length);
		for (float[] p : ps)
			dt.Points.add(new DXFPoint(p[0], p[1], 0));
		wt.addPolyline(dt);
	}

	public void polyC2D(float[][] ps) {
		dt.Count = ps.length + 1;
		dt.Points = new ArrayList<DXFPoint>(ps.length + 1);
		for (float[] p : ps)
			dt.Points.add(new DXFPoint(p[0], p[1], 0));
		float[] p = ps[0];
		dt.Points.add(new DXFPoint(p[0], p[1], 0));
		wt.addPolyline(dt);
	}

	public void circle(float[] p, float radius) {
		dt.Point = new DXFPoint(p[0], p[1], 0);
		dt.Radius = radius;
		wt.addCircle(dt);
	}

	public void polyC2D(double[][] ps) {
		dt.Count = ps.length + 1;
		dt.Points = new ArrayList<DXFPoint>(ps.length + 1);
		for (double[] p : ps)
			dt.Points.add(new DXFPoint((float) p[0], (float) p[1], 0));
		double[] p = ps[0];
		dt.Points.add(new DXFPoint((float) p[0], (float) p[1], 0));
		wt.addPolyline(dt);
	}

	public void arc(float[] p, float stAng, float endAng, float radius) {
		dt.Point = new DXFPoint(p[0], p[1], 0);
		dt.StartAngle = stAng;
		dt.EndAngle = endAng;
		dt.Radius = radius;
		wt.addArc(dt);
	}

	public void set(String string, Color col) {
		DXFLayer layer = new DXFLayer(string);
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(col));
	}

	public void save(String file) {
		try {
			wt.saveToFile(file);
		} catch (Exception excpt) {
		} finally {
			wt.finalize();
			System.out.println("dxf saved");
		}

	}

}
