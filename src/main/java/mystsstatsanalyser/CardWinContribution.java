package mystsstatsanalyser;

public class CardWinContribution {
	double basic = 0.5;
	double upgraded = 0.5;
	
	
	public void modify(double i, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded+=i;
		}else {
			basic+=i;
		}
	}

	public double getBasic() {
		return basic;
	}

	public double getUpgraded() {
		return upgraded;
	}
	
	public double getCount(boolean upgraded) {
		if (upgraded) {
			return this.upgraded;
		}
		return basic;
	}
	
}
