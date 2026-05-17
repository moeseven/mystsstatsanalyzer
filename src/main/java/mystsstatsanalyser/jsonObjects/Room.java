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
"model_id",
"room_type",
"turns_taken",
"monster_ids"
})
@Generated("jsonschema2pojo")
public class Room {

@JsonProperty("model_id")
private String modelId;
@JsonProperty("room_type")
private String roomType;
@JsonProperty("turns_taken")
private Integer turnsTaken;
@JsonProperty("monster_ids")
private List<String> monsterIds;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("model_id")
public String getModelId() {
return modelId;
}

@JsonProperty("model_id")
public void setModelId(String modelId) {
this.modelId = modelId;
}

@JsonProperty("room_type")
public String getRoomType() {
return roomType;
}

@JsonProperty("room_type")
public void setRoomType(String roomType) {
this.roomType = roomType;
}

@JsonProperty("turns_taken")
public Integer getTurnsTaken() {
return turnsTaken;
}

@JsonProperty("turns_taken")
public void setTurnsTaken(Integer turnsTaken) {
this.turnsTaken = turnsTaken;
}

@JsonProperty("monster_ids")
public List<String> getMonsterIds() {
return monsterIds;
}

@JsonProperty("monster_ids")
public void setMonsterIds(List<String> monsterIds) {
this.monsterIds = monsterIds;
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