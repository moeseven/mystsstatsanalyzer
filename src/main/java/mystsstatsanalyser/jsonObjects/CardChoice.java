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
"card",
"was_picked"
})
@Generated("jsonschema2pojo")
public class CardChoice {

@JsonProperty("card")
private Card card;
@JsonProperty("was_picked")
private Boolean wasPicked;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("card")
public Card getCard() {
return card;
}

@JsonProperty("card")
public void setCard(Card card) {
this.card = card;
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