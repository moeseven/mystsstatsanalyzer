package mystsstatsanalyser.jsonObjects;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"ancient_choice",
"current_gold",
"current_hp",
"damage_taken",
"event_choices",
"gold_gained",
"gold_lost",
"gold_spent",
"gold_stolen",
"hp_healed",
"max_hp",
"max_hp_gained",
"max_hp_lost",
"player_id",
"potion_choices",
"relic_choices",
"card_choices",
"cards_gained",
"cards_removed",
"potion_used"
})
@Generated("jsonschema2pojo")
public class PlayerStat {

@JsonProperty("ancient_choice")
private List<AncientChoice> ancientChoice;
@JsonProperty("current_gold")
private Integer currentGold;
@JsonProperty("current_hp")
private Integer currentHp;
@JsonProperty("damage_taken")
private Integer damageTaken;
@JsonProperty("event_choices")
private List<EventChoice> eventChoices;
@JsonProperty("gold_gained")
private Integer goldGained;
@JsonProperty("gold_lost")
private Integer goldLost;
@JsonProperty("gold_spent")
private Integer goldSpent;
@JsonProperty("gold_stolen")
private Integer goldStolen;
@JsonProperty("hp_healed")
private Integer hpHealed;
@JsonProperty("max_hp")
private Integer maxHp;
@JsonProperty("max_hp_gained")
private Integer maxHpGained;
@JsonProperty("max_hp_lost")
private Integer maxHpLost;
@JsonProperty("player_id")
private Integer playerId;
@JsonProperty("potion_choices")
private List<PotionChoice> potionChoices;
@JsonProperty("relic_choices")
private List<RelicChoice> relicChoices;
@JsonProperty("card_choices")
private List<CardChoice> cardChoices;
@JsonProperty("cards_gained")
private List<CardsGained> cardsGained;
@JsonProperty("cards_removed")
private List<CardsRemoved> cardsRemoved;
@JsonProperty("potion_used")
private List<String> potionUsed;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("ancient_choice")
public List<AncientChoice> getAncientChoice() {
return ancientChoice;
}

@JsonProperty("ancient_choice")
public void setAncientChoice(List<AncientChoice> ancientChoice) {
this.ancientChoice = ancientChoice;
}

@JsonProperty("current_gold")
public Integer getCurrentGold() {
return currentGold;
}

@JsonProperty("current_gold")
public void setCurrentGold(Integer currentGold) {
this.currentGold = currentGold;
}

@JsonProperty("current_hp")
public Integer getCurrentHp() {
return currentHp;
}

@JsonProperty("current_hp")
public void setCurrentHp(Integer currentHp) {
this.currentHp = currentHp;
}

@JsonProperty("damage_taken")
public Integer getDamageTaken() {
return damageTaken;
}

@JsonProperty("damage_taken")
public void setDamageTaken(Integer damageTaken) {
this.damageTaken = damageTaken;
}

@JsonProperty("event_choices")
public List<EventChoice> getEventChoices() {
return eventChoices;
}

@JsonProperty("event_choices")
public void setEventChoices(List<EventChoice> eventChoices) {
this.eventChoices = eventChoices;
}

@JsonProperty("gold_gained")
public Integer getGoldGained() {
return goldGained;
}

@JsonProperty("gold_gained")
public void setGoldGained(Integer goldGained) {
this.goldGained = goldGained;
}

@JsonProperty("gold_lost")
public Integer getGoldLost() {
return goldLost;
}

@JsonProperty("gold_lost")
public void setGoldLost(Integer goldLost) {
this.goldLost = goldLost;
}

@JsonProperty("gold_spent")
public Integer getGoldSpent() {
return goldSpent;
}

@JsonProperty("gold_spent")
public void setGoldSpent(Integer goldSpent) {
this.goldSpent = goldSpent;
}

@JsonProperty("gold_stolen")
public Integer getGoldStolen() {
return goldStolen;
}

@JsonProperty("gold_stolen")
public void setGoldStolen(Integer goldStolen) {
this.goldStolen = goldStolen;
}

@JsonProperty("hp_healed")
public Integer getHpHealed() {
return hpHealed;
}

@JsonProperty("hp_healed")
public void setHpHealed(Integer hpHealed) {
this.hpHealed = hpHealed;
}

@JsonProperty("max_hp")
public Integer getMaxHp() {
return maxHp;
}

@JsonProperty("max_hp")
public void setMaxHp(Integer maxHp) {
this.maxHp = maxHp;
}

@JsonProperty("max_hp_gained")
public Integer getMaxHpGained() {
return maxHpGained;
}

@JsonProperty("max_hp_gained")
public void setMaxHpGained(Integer maxHpGained) {
this.maxHpGained = maxHpGained;
}

@JsonProperty("max_hp_lost")
public Integer getMaxHpLost() {
return maxHpLost;
}

@JsonProperty("max_hp_lost")
public void setMaxHpLost(Integer maxHpLost) {
this.maxHpLost = maxHpLost;
}

@JsonProperty("player_id")
public Integer getPlayerId() {
return playerId;
}

@JsonProperty("player_id")
public void setPlayerId(Integer playerId) {
this.playerId = playerId;
}

@JsonProperty("potion_choices")
public List<PotionChoice> getPotionChoices() {
return potionChoices;
}

@JsonProperty("potion_choices")
public void setPotionChoices(List<PotionChoice> potionChoices) {
this.potionChoices = potionChoices;
}

@JsonProperty("relic_choices")
public List<RelicChoice> getRelicChoices() {
return relicChoices;
}

@JsonProperty("relic_choices")
public void setRelicChoices(List<RelicChoice> relicChoices) {
this.relicChoices = relicChoices;
}

@JsonProperty("card_choices")
public List<CardChoice> getCardChoices() {
return cardChoices;
}

@JsonProperty("card_choices")
public void setCardChoices(List<CardChoice> cardChoices) {
this.cardChoices = cardChoices;
}

@JsonProperty("cards_gained")
public List<CardsGained> getCardsGained() {
return cardsGained;
}

@JsonProperty("cards_gained")
public void setCardsGained(List<CardsGained> cardsGained) {
this.cardsGained = cardsGained;
}

@JsonProperty("cards_removed")
public List<CardsRemoved> getCardsRemoved() {
return cardsRemoved;
}

@JsonProperty("cards_removed")
public void setCardsRemoved(List<CardsRemoved> cardsRemoved) {
this.cardsRemoved = cardsRemoved;
}

@JsonProperty("potion_used")
public List<String> getPotionUsed() {
return potionUsed;
}

@JsonProperty("potion_used")
public void setPotionUsed(List<String> potionUsed) {
this.potionUsed = potionUsed;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}