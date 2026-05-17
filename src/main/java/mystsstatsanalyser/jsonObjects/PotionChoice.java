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
"choice",
"was_picked"
})
@Generated("jsonschema2pojo")
public class PotionChoice {

@JsonProperty("choice")
private String choice;
@JsonProperty("was_picked")
private Boolean wasPicked;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("choice")
public String getChoice() {
return choice;
}

@JsonProperty("choice")
public void setChoice(String choice) {
this.choice = choice;
}

@JsonProperty("was_picked")
public Boolean getWasPicked() {
return wasPicked;
}

@JsonProperty("was_picked")
public void setWasPicked(Boolean wasPicked) {
this.wasPicked = wasPicked;
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