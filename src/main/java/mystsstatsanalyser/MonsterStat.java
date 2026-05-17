package mystsstatsanalyser;

public class MonsterStat {
	
	int damage = 0;
	int turns = 0;
	int records = 0;
	int wins = 0;
	String act;
	int act_number;
	String type;
	
	
	
	public MonsterStat(String act, int actNumber, String type) {
		super();
		this.act = act;
		this.act_number = actNumber;
		this.type = type;
	}

	public void merge(int damage, int turns, boolean win) {
		this.damage += damage;
		this.turns += turns;
		if (win) {
			this.wins++;
		}
		records++;
	}

	public int getDamage() {
		return damage;
	}

	public int getTurns() {
		return turns;
	}

	public int getRecords() {
		return records;
	}

	public int getWins() {
		return wins;
	}

	public String getAct() {
		return act;
	}

	public int getAct_number() {
		return act_number;
	}

	public String getType() {
		return type;
	}
	
	
	

}
