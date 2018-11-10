package dxf;


/**
 * @author Hua Hao   whitegreen@163.com
 * Built on  CADSoftTools (https://cadsofttools.com)
 */

public class Symbol {

	private static float gap = 0.2f;
	public static final char[] alph = { 'a', 'b', 'c', 'd', 'g', 'l', 'm', 'n', 'u', 'v', 'w', 'z' }; // 12

	public static float[][][] digits(String st, float[] ori, float w, float h) {
		int len = st.length();
		float[][][] re = new float[len][][];
		for (int i = 0; i < len; i++) {
			Character ch = st.charAt(i);
			float[] p = ori.clone();
			p[0] += i * (w + w * gap);
			re[i] = digit(Integer.parseInt("" + ch), p, w, h);
		}
		return re;
	}

	public static float[][] alphabet(int i, float[] ori, float w, float h) {
		return alphabet(alph[i], ori, w, h);
	}

	public static float[][] alphabet(char ch, float[] ori, float w, float h) {
		float[][] arr = null;
		switch (ch) {
		case 'A':
		case 'a':
			arr = new float[][] { { 0, 0 }, { 0.5f, 2 }, { 1, 0 }, { 0, 0 } };
			break;
		case 'B':
		case 'b':
			arr = new float[][] { { 0, 0 }, { 0, 2 }, { 1, 1.5f }, { 0, 1 }, { 1, 0.5f }, { 0, 0 } };
			break;
		case 'C':
		case 'c':
			arr = new float[][] { { 1, 0 }, { 0, 0 }, { 0, 2 }, { 1, 2 } };
			break;
		case 'D':
		case 'd':
			arr = new float[][] { { 0, 0 }, { 0, 2 }, { 1,  7f/4} ,   {  1, 1f/4}, {0,0} } ; 
			break;
		case 'G':
		case 'g':
			arr = new float[][] { { 0.5f, 1 }, { 1, 1} ,{ 1,  0} ,    {0,0} , {0,2},{1,2}} ; 
			break;
		case 'L':
		case 'l':
			arr = new float[][] { { 1,  0} ,    {0,0} , {0,2}} ; 
			break;
		case 'M':
		case 'm':
			arr = new float[][] { { 0,  0} ,    {0,2} , {0.5f,0},{1,2}, {1,0}} ; 
			break;
		case 'N':
		case 'n':
			arr = new float[][] { { 0,  0} ,    {0,2} ,  {1,0},{1,2}} ; 
			break;
		case 'U':
		case 'u':
			arr = new float[][] { { 0,  2} ,    {0,0} ,  {1,0},{1,2}} ; 
			break;
		case 'V':
		case 'v':
			arr = new float[][] { { 0,  2} ,    {0.5f,0} ,  {1,2}} ; 
			break;
		case 'W':
		case 'w':
			arr = new float[][] { { 0,  2} ,    {0.25f,0} ,  {0.5f, 1} , { 0.75f, 0}, {1,2}} ; 
			break;
		case 'Z':
		case 'z':
			arr = new float[][] { { 1,  0} ,    {0,0} ,  {1, 2} , {0,2}} ; 
			break;
		}
		for(float[] p:arr){
			p[0]= ori[0]+p[0]*w;
			p[1]=ori[1]+p[1]* 0.5f*h;
		}
		return arr;
	}

	public static float[][] digit(int num, float[] ori, float w, float h) {
		float[][] arr = null;
		switch (num) {
		case -2:
			arr = new float[][] { { 0, 0 }, { 1, 0 } }; // center
			break;
		case -1:
			arr = new float[][] { { 0, 1 }, { 1, 1 } }; // middle
			break;
		case 0:
			arr = new float[][] { { 0, 0 }, { 1, 0 }, { 1, 2 }, { 0, 2 }, { 0, 0 } };
			break;
		case 1:
			arr = new float[][] { { 0.5f, 0 }, { 0.5f, 2 } };
			break;
		case 2:
			arr = new float[][] { { 1, 0 }, { 0, 0 }, { 0, 0.75f }, { 1, 1.25f }, { 1, 2 }, { 0, 2 } };
			break;
		case 3:
			arr = new float[][] { { 0, 0 }, { 1, 0 }, { 0.6f, 1 }, { 1, 2 }, { 0, 2 } };
			break;
		case 4:
			arr = new float[][] { { 0.8f, 0 }, { 0.8f, 2 }, { 0, 0.7f }, { 1, 0.7f } };
			break;
		case 5:
			arr = new float[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 2 } };
			break;
		case 6:
			arr = new float[][] { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0, 0 }, { 0, 2 }, { 1, 2 } };
			break;
		case 7:
			arr = new float[][] { { 0, 0 }, { 1, 2 }, { 0, 2 } };
			break;
		case 8:
			arr = new float[][] { { 0, 0 }, { 1, 2 }, { 0, 2 }, { 1, 0 }, { 0, 0 } };
			break;
		case 9:
			arr = new float[][] { { 1, 0 }, { 1, 2 }, { 0, 1.5f },  { 1, 1 } };
			break;
		}
		for(float[] p:arr){
			p[0]= ori[0]+p[0]*w;
			p[1]=ori[1]+p[1]* 0.5f*h;
		}
		return arr;
	}

}
