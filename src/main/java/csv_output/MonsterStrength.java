package csv_output;

import mystsstatsanalyser.RunAnaylser;
import tools.STSAnalyserUtils;

public class MonsterStrength extends BaseSTSStats {
	
	
	
	
	public String getCharacter() {
		return character;
	}

	public String getMonster() {
		return monster;
	}

	public String getType() {
		return type;
	}

	public int getAct_number() {
		return act_number;
	}

	public double getAvg_damage_done() {
		return avg_damage_done;
	}

	public double getAvg_fight_duration() {
		return avg_fight_duration;
	}

	public double getKill_rate() {
		return kill_rate;
	}

	private String character;
	private String monster;
	private String type;
	private String act;
	private int act_number;
	private double avg_damage_done;
	private double avg_fight_duration;
	private double kill_rate;
	


	public MonsterStrength(String character, String monster, String type, String act, int act_number, double avg_damage_done,
			double avg_fight_duration, double kill_rate) {
		super();
		this.character = character;
		this.monster = monster.substring(monster.lastIndexOf('.') + 1);
		this.type = type;
		this.act = act.substring(act.lastIndexOf('.') + 1);
		this.act_number = act_number;
		this.avg_damage_done = avg_damage_done;
		this.avg_fight_duration = avg_fight_duration;
		this.kill_rate = kill_rate;
	}

	public String getAct() {
		return act;
	}

	@Override
	public String headerRow() {
		return String.join(CsvWriter.seperator, "character","monster","type","act name", "act","avg damage", "avg fight duration", "kill rate");
	}

	@Override
	public String printRow() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +CsvWriter.seperator + monster
                +CsvWriter.seperator + type
                +CsvWriter.seperator + act
                +CsvWriter.seperator + act_number
                +CsvWriter.seperator + STSAnalyserUtils.truncateToTwoDecimals(avg_damage_done)
                +CsvWriter.seperator + STSAnalyserUtils.truncateToTwoDecimals(avg_fight_duration)
                +CsvWriter.seperator + STSAnalyserUtils.truncateToTwoDecimals(kill_rate)
                ;
	}

}
