package tests;

import java.awt.Color;
import dxf.Shape;
import dxf.LaserDecimal;
import dxfExporter.Constants;
import dxfExporter.DXFData;
import dxfExporter.DXFExport;
import dxfExporter.DXFLayer;

/**
 * @author Hua Hao   whitegreen@163.com
 * Built on  CADSoftTools (https://cadsofttools.com)
 */

public class DrawLaserCutDigits {  //The font of digits are designed for laser cut

	public static void main(String[] s) {
		new DrawLaserCutDigits();
	}

	public DrawLaserCutDigits() {
		DXFExport wt = new DXFExport();
		wt.AutoCADVer = Constants.DXFVERSION_R2000;

		DXFLayer layer = new DXFLayer("layer1");
		wt.setCurrentLayer(layer);
		DXFData dt = new DXFData();
		dt.LayerName = layer.getName();
		dt.Color = (Constants.convertColorRGBToDXF(Color.WHITE));

		int value = 567891234;
		double[][][] arr = LaserDecimal.digits("" + value);  // font for laser cut
		for (double[][] ps : arr)
			Shape.polyC2D(wt, dt, ps);

		try {
			wt.saveToFile("/Users/huahao/Desktop/num.dxf"); //put your folder directory here
		} catch (Exception excpt) {
		} finally {
			wt.finalize();
			System.out.println("dxf saved");
		}
	}

	
}
