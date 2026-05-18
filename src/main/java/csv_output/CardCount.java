package csv_output;

public class CardCount {
	int basic = 0;
	int upgraded = 0;
	
	
	
	public CardCount(int start) {
		super();
		basic = start;
		upgraded = start;
	}

	public void increment(boolean is_upgraded) {
		modify(1, is_upgraded);
	}
	
	public void modify(int i, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded+=i;
		}else {
			basic+=i;
		}
	}
	
	public void modifyFloorOne(int i, boolean is_upgraded) {
		if (is_upgraded) {
			upgraded = (upgraded + i <= 0) ? 1 : upgraded + i;
		}else {
			basic = (basic + i <= 0) ? 1 : basic + i;
		}
	}

	public int getBasic() {
		return basic;
	}

	public int getUpgraded() {
		return upgraded;
	}
	
	public int getCount(boolean upgraded) {
		if (upgraded) {
			return this.upgraded;
		}
		return basic;
	}
	
}
