
package ca.uqam.projet.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "type",
    "features"
})
public class Features {

    @JsonProperty("type")
    private String type;
    @JsonProperty("features")
    private List<Feature> features = new ArrayList<Feature>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Features() {
    }

    /**
     * 
     * @param features
     * @param type
     */
    public Features(String type, List<Feature> features) {
        this.type = type;
        this.features = features;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Features withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The features
     */
    @JsonProperty("features")
    public List<Feature> getFeatures() {
        return features;
    }
    
    public Feature getFeatureFromFeatures (List<Feature> features){
        return features.get(0);
    }

    /**
     * 
     * @param features
     *     The features
     */
    @JsonProperty("features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Features withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    @Override
    public String toString() { 
        for(Feature feature : features) {
            System.out.println(feature.toString());
        }
        return null;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Features withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
