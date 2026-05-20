package tools;

public class STSAnalyserUtils {



	public static double truncateToTwoDecimals(double retVal) {
		return Math.round(retVal* 100.0) / 100.0;
	}
	
	public static double calcTruncatedRate(int wins, int losses) {
		double retVal = 0;
		if (losses >= 0 && wins >= 0 && wins+losses > 0) {
			retVal = 1.0 * wins / (wins + losses);
		}
		return STSAnalyserUtils.truncateToTwoDecimals(retVal);
	}
}
