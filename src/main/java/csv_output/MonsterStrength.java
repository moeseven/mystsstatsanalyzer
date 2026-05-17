package csv_output;

import mystsstatsanalyser.RunAnaylser;
import tools.STSAnalyserUtils;

public class MonsterStrength extends BaseSTSStats {
	
	private String character;
	private String monster;
	private String type;
	private String act;
	private int act_number;
	private double avg_damage_done;
	private double avg_fight_duration;
	private double win_rate_against_this;
	


	public MonsterStrength(String character, String monster, String type, String act, int act_number, double avg_damage_done,
			double avg_fight_duration, double win_rate_against_this) {
		super();
		this.character = character;
		this.monster = monster;
		this.type = type;
		this.act = act;
		this.act_number = act_number;
		this.avg_damage_done = avg_damage_done;
		this.avg_fight_duration = avg_fight_duration;
		this.win_rate_against_this = win_rate_against_this;
	}

	public String getAct() {
		return act;
	}

	@Override
	public String headerRow() {
		return "character,monster,type,act name, act,avg damage, avg fight duration";
	}

	@Override
	public String toString() {
		return 	character.substring(character.lastIndexOf('.') + 1)
                +"," + monster
                +"," + type
                +"," + act
                +"," + act_number
                +"," + STSAnalyserUtils.truncateToTwoDecimals(avg_damage_done)
                +"," + STSAnalyserUtils.truncateToTwoDecimals(avg_fight_duration)
                //+"," + STSAnalyserUtils.truncateToTwoDecimals(win_rate_against_this)
                ;
	}

}
