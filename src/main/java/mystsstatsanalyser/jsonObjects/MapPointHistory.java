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
"map_point_type",
"player_stats",
"rooms"
})
@Generated("jsonschema2pojo")
public class MapPointHistory {

@JsonProperty("map_point_type")
private String mapPointType;
@JsonProperty("player_stats")
private List<PlayerStat> playerStats;
@JsonProperty("rooms")
private List<Room> rooms;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("map_point_type")
public String getMapPointType() {
return mapPointType;
}

@JsonProperty("map_point_type")
public void setMapPointType(String mapPointType) {
this.mapPointType = mapPointType;
}

@JsonProperty("player_stats")
public List<PlayerStat> getPlayerStats() {
return playerStats;
}

@JsonProperty("player_stats")
public void setPlayerStats(List<PlayerStat> playerStats) {
this.playerStats = playerStats;
}

@JsonProperty("rooms")
public List<Room> getRooms() {
return rooms;
}

@JsonProperty("rooms")
public void setRooms(List<Room> rooms) {
this.rooms = rooms;
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