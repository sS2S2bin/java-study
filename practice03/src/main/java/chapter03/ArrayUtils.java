package chapter03;

public class ArrayUtils {
	static double[] inToDouble(int[] source) {
		double [] result = new double[source.length];
		for(int i = 1; i< source.length;i++) {
			result[i] = source[i];
		}
		return result;
		
	}

}
