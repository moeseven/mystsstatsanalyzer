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
"badges",
"character",
"deck",
"id",
"max_potion_slot_count",
"potions",
"relics"
})
@Generated("jsonschema2pojo")
public class Player {

@JsonProperty("badges")
private List<Object> badges;
@JsonProperty("character")
private String character;
@JsonProperty("deck")
private List<Deck> deck;
@JsonProperty("id")
private Integer id;
@JsonProperty("max_potion_slot_count")
private Integer maxPotionSlotCount;
@JsonProperty("potions")
private List<Potion> potions;
@JsonProperty("relics")
private List<Relic> relics;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("badges")
public List<Object> getBadges() {
return badges;
}

@JsonProperty("badges")
public void setBadges(List<Object> badges) {
this.badges = badges;
}

@JsonProperty("character")
public String getCharacter() {
return character;
}

@JsonProperty("character")
public void setCharacter(String character) {
this.character = character;
}

@JsonProperty("deck")
public List<Deck> getDeck() {
return deck;
}

@JsonProperty("deck")
public void setDeck(List<Deck> deck) {
this.deck = deck;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("max_potion_slot_count")
public Integer getMaxPotionSlotCount() {
return maxPotionSlotCount;
}

@JsonProperty("max_potion_slot_count")
public void setMaxPotionSlotCount(Integer maxPotionSlotCount) {
this.maxPotionSlotCount = maxPotionSlotCount;
}

@JsonProperty("potions")
public List<Potion> getPotions() {
return potions;
}

@JsonProperty("potions")
public void setPotions(List<Potion> potions) {
this.potions = potions;
}

@JsonProperty("relics")
public List<Relic> getRelics() {
return relics;
}

@JsonProperty("relics")
public void setRelics(List<Relic> relics) {
this.relics = relics;
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
