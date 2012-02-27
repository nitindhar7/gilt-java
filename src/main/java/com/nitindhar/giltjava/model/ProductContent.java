package com.nitindhar.giltjava.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductContent implements Serializable {

    private static final long serialVersionUID = -413927201708808995L;

    @JsonProperty("description")
    private final String description;
    
    @JsonProperty("fit_notes")
    private final String fitNotes;
    
    @JsonProperty("material")
    private final String material;
    
    @JsonProperty("care_instructions")
    private final String careInstructions;
    
    @JsonProperty("origin")
    private final String origin;
    
    @JsonCreator
    public ProductContent(@JsonProperty("description") String description,
                          @JsonProperty("fit_notes") String fitNotes,
                          @JsonProperty("material") String material,
                          @JsonProperty("care_instructions") String careInstructions,
                          @JsonProperty("origin") String origin) {
        this.description = description;
        this.fitNotes = fitNotes;
        this.material = material;
        this.careInstructions = careInstructions;
        this.origin = origin;
    }
    
    public String getDescription() {
        return description;
    }

    public String getFitNotes() {
        return fitNotes;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public String getCareInstructions() {
        return careInstructions;
    }
    
    public String getOrigin() {
        return origin;
    }
    
}
