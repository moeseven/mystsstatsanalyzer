package mystsstatsanalyser.jsonObjects;

import java.util.LinkedHashMap;
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
"floor_added_to_deck",
"id"
})
@Generated("jsonschema2pojo")
public class CardsRemoved {

@JsonProperty("floor_added_to_deck")
private Integer floorAddedToDeck;
@JsonProperty("id")
private String id;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("floor_added_to_deck")
public Integer getFloorAddedToDeck() {
return floorAddedToDeck;
}

@JsonProperty("floor_added_to_deck")
public void setFloorAddedToDeck(Integer floorAddedToDeck) {
this.floorAddedToDeck = floorAddedToDeck;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
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