package com.nitindhar.giltjava.model;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageUrl extends AbstractData {

    @JsonProperty("url")
    @NotNull
    private final String url;

    @JsonProperty("width")
    @NotNull
    private final int width;

    @JsonProperty("height")
    @NotNull
    private final int height;

    @JsonCreator
    public ImageUrl(@JsonProperty("url") @NotNull String url,
                    @JsonProperty("width") @NotNull int width,
                    @JsonProperty("height") @NotNull int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}