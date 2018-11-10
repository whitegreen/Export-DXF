package tests;

import java.awt.Color;
import java.util.Random;
import dxf.Symbol;
import dxf.Shape;
import dxfExporter.Constants;
import dxfExporter.DXFData;
import dxfExporter.DXFExport;
import dxfExporter.DXFLayer;

/**
 * @author Hua Hao   whitegreen@163.com
 * Built on  CADSoftTools (https://cadsofttools.com)
 */

public class DrawDigits_Letters {

	public static void main(String[] s) {
		new DrawDigits_Letters();
	}

	public DrawDigits_Letters() {
		DXFExport  wt = new DXFExport();
		wt.AutoCADVer = Constants.DXFVERSION_R2000;

		DXFLayer layer = new DXFLayer("layer1");
		wt.setCurrentLayer(layer);
		DXFData dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.WHITE));
		
		float w = 50;
		float h = 100;
		for (int i = -2; i < 10; i++) {
			Shape.poly2D(wt, dt,Symbol.digit(i, new float[]{i*(w+20), 100}, w, h));
		}
		
		layer = new DXFLayer("layer2");
		wt.setCurrentLayer(layer);
		dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.CYAN));
		Random ran = new Random(-998);
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(1000);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -1400, i * 130 }, w, h);
			for (float[][] pl : ps)
				Shape.poly2D(wt, dt, pl);
		}
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(100);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -900, i * 130 }, w, h);
			for (float[][] pl : ps)
				Shape.poly2D(wt, dt, pl);
		}
		for (int i = 0; i < 10; i++) {
			String st = "" + ran.nextInt(10);
			System.out.println(st);
			float[][][] ps = Symbol.digits(st, new float[] { -400, i * 130 }, w, h);
			for (float[][] pl : ps)
				Shape.poly2D(wt, dt, pl);
		}
		
		for (int i = 0; i < 12; i++) {
			float[][] ps = Symbol.alphabet(i, new float[] { -400, -2000+i * 130 }, w, h);
			Shape.poly2D(wt, dt, ps);
		}

		try {
			wt.saveToFile("/Users/huahao/Desktop/digits_letters.dxf"); //put your folder directory here
		} catch (Exception excpt) {
		} finally {
			wt.finalize();
			System.out.println("dxf saved");
		}
	}
}
