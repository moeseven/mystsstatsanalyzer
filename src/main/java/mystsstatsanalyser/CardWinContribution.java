package mystsstatsanalyser;

public class CardWinContribution {

	
	public WinContribution getBasic() {
		return basic;
	}

	public WinContribution getUpgraded() {
		return upgraded;
	}

	private WinContribution basic,upgraded;
	
	public CardWinContribution(double wr) {
		super();
		this.basic = new WinContribution(wr);
		this.upgraded = new WinContribution(wr);
	}
	
	public void modifyDiminishingly(double deviationToExpectation, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded.modifyDiminishingly(deviationToExpectation);
		}else {
			basic.modifyDiminishingly(deviationToExpectation);
		}
	}

	
	public double getBasicRelatedToAvarage() {
		return basic.getContributionDeviation();
	}
	
	public double getUpgradedRelatedToAvarage() {
		return upgraded.getContributionDeviation();
	}

	
}
