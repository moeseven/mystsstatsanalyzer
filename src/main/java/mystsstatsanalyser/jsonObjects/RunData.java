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
"acts",
"ascension",
"build_id",
"game_mode",
"killed_by_encounter",
"killed_by_event",
"map_point_history",
"modifiers",
"platform_type",
"players",
"run_time",
"schema_version",
"seed",
"start_time",
"was_abandoned",
"win"
})
@Generated("jsonschema2pojo")
public class RunData {

@JsonProperty("acts")
private List<String> acts;
@JsonProperty("ascension")
private Integer ascension;
@JsonProperty("build_id")
private String buildId;
@JsonProperty("game_mode")
private String gameMode;
@JsonProperty("killed_by_encounter")
private String killedByEncounter;
@JsonProperty("killed_by_event")
private String killedByEvent;
@JsonProperty("map_point_history")
private List<List<MapPointHistory>> mapPointHistory;
@JsonProperty("modifiers")
private List<Object> modifiers;
@JsonProperty("platform_type")
private String platformType;
@JsonProperty("players")
private List<Player> players;
@JsonProperty("run_time")
private Integer runTime;
@JsonProperty("schema_version")
private Integer schemaVersion;
@JsonProperty("seed")
private String seed;
@JsonProperty("start_time")
private Integer startTime;
@JsonProperty("was_abandoned")
private Boolean wasAbandoned;
@JsonProperty("win")
private Boolean win;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("acts")
public List<String> getActs() {
return acts;
}

@JsonProperty("acts")
public void setActs(List<String> acts) {
this.acts = acts;
}

@JsonProperty("ascension")
public Integer getAscension() {
return ascension;
}

@JsonProperty("ascension")
public void setAscension(Integer ascension) {
this.ascension = ascension;
}

@JsonProperty("build_id")
public String getBuildId() {
return buildId;
}

@JsonProperty("build_id")
public void setBuildId(String buildId) {
this.buildId = buildId;
}

@JsonProperty("game_mode")
public String getGameMode() {
return gameMode;
}

@JsonProperty("game_mode")
public void setGameMode(String gameMode) {
this.gameMode = gameMode;
}

@JsonProperty("killed_by_encounter")
public String getKilledByEncounter() {
return killedByEncounter;
}

@JsonProperty("killed_by_encounter")
public void setKilledByEncounter(String killedByEncounter) {
this.killedByEncounter = killedByEncounter;
}

@JsonProperty("killed_by_event")
public String getKilledByEvent() {
return killedByEvent;
}

@JsonProperty("killed_by_event")
public void setKilledByEvent(String killedByEvent) {
this.killedByEvent = killedByEvent;
}

@JsonProperty("map_point_history")
public List<List<MapPointHistory>> getMapPointHistory() {
return mapPointHistory;
}

@JsonProperty("map_point_history")
public void setMapPointHistory(List<List<MapPointHistory>> mapPointHistory) {
this.mapPointHistory = mapPointHistory;
}

@JsonProperty("modifiers")
public List<Object> getModifiers() {
return modifiers;
}

@JsonProperty("modifiers")
public void setModifiers(List<Object> modifiers) {
this.modifiers = modifiers;
}

@JsonProperty("platform_type")
public String getPlatformType() {
return platformType;
}

@JsonProperty("platform_type")
public void setPlatformType(String platformType) {
this.platformType = platformType;
}

@JsonProperty("players")
public List<Player> getPlayers() {
return players;
}

@JsonProperty("players")
public void setPlayers(List<Player> players) {
this.players = players;
}

@JsonProperty("run_time")
public Integer getRunTime() {
return runTime;
}

@JsonProperty("run_time")
public void setRunTime(Integer runTime) {
this.runTime = runTime;
}

@JsonProperty("schema_version")
public Integer getSchemaVersion() {
return schemaVersion;
}

@JsonProperty("schema_version")
public void setSchemaVersion(Integer schemaVersion) {
this.schemaVersion = schemaVersion;
}

@JsonProperty("seed")
public String getSeed() {
return seed;
}

@JsonProperty("seed")
public void setSeed(String seed) {
this.seed = seed;
}

@JsonProperty("start_time")
public Integer getStartTime() {
return startTime;
}

@JsonProperty("start_time")
public void setStartTime(Integer startTime) {
this.startTime = startTime;
}

@JsonProperty("was_abandoned")
public Boolean getWasAbandoned() {
return wasAbandoned;
}

@JsonProperty("was_abandoned")
public void setWasAbandoned(Boolean wasAbandoned) {
this.wasAbandoned = wasAbandoned;
}

@JsonProperty("win")
public Boolean getWin() {
return win;
}

@JsonProperty("win")
public void setWin(Boolean win) {
this.win = win;
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