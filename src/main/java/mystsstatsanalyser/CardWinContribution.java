package mystsstatsanalyser;

public class CardWinContribution {

	
	double basic = .5;
	double upgraded = .5;
	
	private double wr;
	
	public CardWinContribution(double wr) {
		super();
		this.basic = wr;
		this.upgraded = wr;
		this.wr = wr;
	}

	public void modify(double i, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded+=i;
		}else {
			basic+=i;
		}
	}
	
	public void modifyPercentage(double i, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded+= calcMiddlingModification(i, is_upgraded);
		}else {
			basic+= calcMiddlingModification(i, is_upgraded);
		}
	}

	private double calcMiddlingModification(double i,boolean isUpgraded) {
		double factor;
		if (i > 0) {
			factor = Math.max(wr-Math.abs(wr-getValue(isUpgraded)),0);
		}else {
			factor = Math.max(wr-Math.abs(wr-getValue(isUpgraded)), 0);
		}
		return 3*i*factor;
	}

	public double getBasic() {
		return basic;
	}

	public double getUpgraded() {
		return upgraded;
	}
	
	public double getValue(boolean upgraded) {
		if (upgraded) {
			return this.upgraded;
		}
		return basic;
	}
	
}
