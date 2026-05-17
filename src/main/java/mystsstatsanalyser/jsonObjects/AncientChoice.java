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
"TextKey",
"title",
"was_chosen"
})
@Generated("jsonschema2pojo")
public class AncientChoice {

@JsonProperty("TextKey")
private String textKey;
@JsonProperty("title")
private Title title;
@JsonProperty("was_chosen")
private Boolean wasChosen;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("TextKey")
public String getTextKey() {
return textKey;
}

@JsonProperty("TextKey")
public void setTextKey(String textKey) {
this.textKey = textKey;
}

@JsonProperty("title")
public Title getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(Title title) {
this.title = title;
}

@JsonProperty("was_chosen")
public Boolean getWasChosen() {
return wasChosen;
}

@JsonProperty("was_chosen")
public void setWasChosen(Boolean wasChosen) {
this.wasChosen = wasChosen;
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

