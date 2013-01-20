package com.nitindhar.giltjava.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductCategoryWrapper extends AbstractData {

    @JsonProperty("categories")
    @NotNull
    private final List<String> categories;

    @JsonCreator
    public ProductCategoryWrapper(@JsonProperty("categories") @NotNull List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }

}