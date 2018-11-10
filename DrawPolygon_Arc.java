package tests;

import java.awt.Color;
import java.util.Random;
import dxf.Shape;
import dxfExporter.Constants;
import dxfExporter.DXFData;
import dxfExporter.DXFExport;
import dxfExporter.DXFLayer;

/**
 * @author Hua Hao whitegreen@163.com 
 * Built on CADSoftTools (https://cadsofttools.com)
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
		
		
		DXFExport wt = new DXFExport();
		wt.AutoCADVer = Constants.DXFVERSION_R2000;

		DXFLayer layer = new DXFLayer("layer1");
		wt.setCurrentLayer(layer);
		DXFData dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.WHITE));
		Shape.poly2D(wt, dt, ps);

		
		layer = new DXFLayer("layer2");
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.RED));
		float[][] poly = new float[n][];
		for (int j = 0; j < n; j++) {
			poly[j] = ps[j].clone();
			poly[j][0] += 640;
		}
		Shape.polyC2D(wt, dt, poly); //closed polygon
		

		layer = new DXFLayer("layer3");
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.GREEN));
		Shape.circle(wt, dt, new float[] { 0, 0}, 100);
		Shape.circle(wt, dt, new float[] { 100, 100}, 100);
		
		
		layer = new DXFLayer("layer4");
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.BLUE));
		Shape.arc(wt, dt, new float[] { 350, 0 }, 30, 150, 100); // from 30 degree, to 150 degree
		Shape.arc(wt, dt, new float[] { 350, 0 }, 270, 360, 100); // from 270 degree, to 360degree
		
		try {
			wt.saveToFile("/Users/huahao/Desktop/poly.dxf"); // put your folder directory here
		} catch (Exception excpt) {
		} finally {
			wt.finalize();
			System.out.println("dxf saved");
		}
	}


}
