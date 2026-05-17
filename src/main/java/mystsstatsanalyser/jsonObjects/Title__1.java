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
"key",
"table"
})
@Generated("jsonschema2pojo")
public class Title__1 {

@JsonProperty("key")
private String key;
@JsonProperty("table")
private String table;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("key")
public String getKey() {
return key;
}

@JsonProperty("key")
public void setKey(String key) {
this.key = key;
}

@JsonProperty("table")
public String getTable() {
return table;
}

@JsonProperty("table")
public void setTable(String table) {
this.table = table;
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

