
package ca.uqam.projet.resources;

import java.util.HashMap;
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
    "name",
    "description",
    "Date",
    "Heure_debut",
    "Heure_fin",
    "Lieu",
    "Camion",
    "Truckid"
})
public class Properties {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Heure_debut")
    private String heureDebut;
    @JsonProperty("Heure_fin")
    private String heureFin;
    @JsonProperty("Lieu")
    private String lieu;
    @JsonProperty("Camion")
    private String camion;
    @JsonProperty("Truckid")
    private String truckid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Properties() {
    }

    /**
     * 
     * @param camion
     * @param lieu
     * @param description
     * @param heureFin
     * @param name
     * @param heureDebut
     * @param truckid
     * @param date
     */
    public Properties(String name, String description, String date, String heureDebut, String heureFin, String lieu, String camion, String truckid) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.camion = camion;
        this.truckid = truckid;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Properties withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Properties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 
     * @return
     *     The date
     */
    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The Date
     */
    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    public Properties withDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * 
     * @return
     *     The heureDebut
     */
    @JsonProperty("Heure_debut")
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * 
     * @param heureDebut
     *     The Heure_debut
     */
    @JsonProperty("Heure_debut")
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Properties withHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    /**
     * 
     * @return
     *     The heureFin
     */
    @JsonProperty("Heure_fin")
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * 
     * @param heureFin
     *     The Heure_fin
     */
    @JsonProperty("Heure_fin")
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Properties withHeureFin(String heureFin) {
        this.heureFin = heureFin;
        return this;
    }

    /**
     * 
     * @return
     *     The lieu
     */
    @JsonProperty("Lieu")
    public String getLieu() {
        return lieu;
    }

    /**
     * 
     * @param lieu
     *     The Lieu
     */
    @JsonProperty("Lieu")
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Properties withLieu(String lieu) {
        this.lieu = lieu;
        return this;
    }

    /**
     * 
     * @return
     *     The camion
     */
    @JsonProperty("Camion")
    public String getCamion() {
        return camion;
    }

    /**
     * 
     * @param camion
     *     The Camion
     */
    @JsonProperty("Camion")
    public void setCamion(String camion) {
        this.camion = camion;
    }

    public Properties withCamion(String camion) {
        this.camion = camion;
        return this;
    }

    /**
     * 
     * @return
     *     The truckid
     */
    @JsonProperty("Truckid")
    public String getTruckid() {
        return truckid;
    }

    /**
     * 
     * @param truckid
     *     The Truckid
     */
    @JsonProperty("Truckid")
    public void setTruckid(String truckid) {
        this.truckid = truckid;
    }

    public Properties withTruckid(String truckid) {
        this.truckid = truckid;
        return this;
    }

    @Override
    public String toString() {
        return "Date: " + date + '\n' +
            "Heure_debut: " + heureDebut + '\n' +
            "Heure_fin: "+ heureFin + '\n' +
            "Lieu: " + lieu + '\n' +
            "Camion: " + camion + '\n' +
            "Truckid: " + truckid + '\n';
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Properties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
