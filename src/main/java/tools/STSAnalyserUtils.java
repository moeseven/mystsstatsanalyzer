package tools;

public class STSAnalyserUtils {



	public static double truncateToTwoDecimals(double retVal) {
		return Math.round(retVal* 100.0) / 100.0;
	}
}
