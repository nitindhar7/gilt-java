package com.nitindhar.giltjava.model;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product extends AbstractData {

    @JsonProperty("name")
    @NotNull
    private final String name;

    @JsonProperty("product")
    @NotNull
    private final String product;

    @JsonProperty("id")
    @NotNull
    private final int id;

    @JsonProperty("brand")
    @NotNull
    private final String brand;

    @JsonProperty("url")
    @NotNull
    private final String url;

    @JsonProperty("content")
    private final ProductContent content;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("fit_notes")
    private final String fitNotes;

    @JsonProperty("materials")
    private final String materials;

    @JsonProperty("care_instructions")
    private final String careInstructions;

    @JsonProperty("origin")
    private final String origin;

    @JsonProperty("image_urls")
    @NotNull
    private final Map<String,List<Map<String,Object>>> imageUrls;

    @JsonProperty("skus")
    @NotNull
    private final List<Sku> skus;

    @JsonCreator
    public Product(@JsonProperty("name") @NotNull String name,
                   @JsonProperty("product") @NotNull String product,
                   @JsonProperty("id") @NotNull int id,
                   @JsonProperty("brand") @NotNull String brand,
                   @JsonProperty("url") @NotNull String url,
                   @JsonProperty("content") ProductContent content,
                   @JsonProperty("description") String description,
                   @JsonProperty("fit_notes") String fitNotes,
                   @JsonProperty("materials") String materials,
                   @JsonProperty("care_instructions") String careInstructions,
                   @JsonProperty("origin") String origin,
                   @JsonProperty("image_urls") @NotNull Map<String,List<Map<String,Object>>> imageUrls,
                   @JsonProperty("skus") @NotNull List<Sku> skus) {
        this.name = name;
        this.product = product;
        this.id = id;
        this.brand = brand;
        this.url = url;
        this.content = content;
        this.description = description;
        this.fitNotes = fitNotes;
        this.materials = materials;
        this.careInstructions = careInstructions;
        this.origin = origin;
        this.imageUrls = imageUrls;
        this.skus = skus;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getUrl() {
        return url;
    }

    public ProductContent getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getFitNotes() {
        return fitNotes;
    }

    public String getMaterials() {
        return materials;
    }

    public String getCareInstructions() {
        return careInstructions;
    }

    public String getOrigin() {
        return origin;
    }

    public Map<String, List<Map<String, Object>>> getImageUrls() {
        return imageUrls;
    }

    public List<Sku> getSkus() {
        return skus;
    }

}