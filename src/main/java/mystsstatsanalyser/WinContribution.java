package mystsstatsanalyser;

public class WinContribution {
	
	
	private double contributionFactor;
	
	
	public final static double floor = -1;
	public final static double max = 1;
	
	private final double min_adjustment_factor = .14;
	private final double fitting_factor = 0.16;
	
	
	
	private double wr;
	
	public WinContribution(double wr) {
		super();
		this.contributionFactor = wr;
		this.wr = wr;
	}

	private void modify(double mod) {
			contributionFactor= keepValueInBorders(contributionFactor + mod);
	}
	
	private double keepValueInBorders(double value) {
		return Math.min(Math.max(floor,value),max);
	}
	
	public void modifyDiminishingly(double deviationToExpectation) {
		double mod = fitting_factor * deviationToExpectation;
		double unadjustedNewValue = keepValueInBorders(contributionFactor + mod);
		double distanceToBorder = measureDistanceToClosestBorder(unadjustedNewValue);
		double modifyFactor = Math.min(distanceToBorder, min_adjustment_factor);
		modify(mod* modifyFactor);
	}
	
	
	private double measureDistanceToClosestBorder(double value) {
		return Math.min(Math.abs(max - value), Math.abs(-value - floor));
	}

	public double getContributionDeviation() {
		return getValue() - wr;
	}

	
	public double getValue() {
		return this.contributionFactor;
	}
}
