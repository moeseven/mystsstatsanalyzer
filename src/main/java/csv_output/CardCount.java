package csv_output;

public class CardCount {
	int basic = 0;
	int upgraded = 0;
	
	public void increment(boolean is_upgraded) {
		if (is_upgraded) {
			upgraded++;
		}else {
			basic++;
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
