package com.giltjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.giltjava.model.Product;
import com.giltjava.model.ProductContent;
import com.giltjava.model.Resource;
import com.giltjava.model.Sale;
import com.giltjava.model.Sku;
import com.giltjava.util.HttpUtil;
import com.giltjava.util.URIBuilder;

public class GiltAPI {

    private String apiKey;
    
    /**
     * Setup the api client
     * @param apiKey required to be able to access the Gilt API
     */
    public GiltAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Retrieves a list of sales from Gilt.com for given store. It is also possible to set the action to retrieve
     * upcoming sales instead of active sales.
     * 
     * @param store can be Store.(MEN|WOMEN|KIDS|HOME)
     * @param action can be Sale.(ACTIVE|UPCOMING)
     * @param params is a map of options. Currently the only valid option is "product_details", which returns extra detail per sale  
     * @return a list of sale objects
     */
    public List<Sale> getSales(String store, String action, Map<String,String> params) {
        if(action == null || action.length() == 0)
            action = Sale.ACTIVE;
        
        String uri = new URIBuilder()
                        .resource(Resource.SALES)
                        .store(store)
                        .action(action)
                        .apikey(apiKey)
                        .params(URIBuilder.parametrizeMap(params))
                        .build();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {
            root = mapper.readTree(HttpUtil.get(uri));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing json", e);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing json", e);
        }

        List<Sale> sales = new ArrayList<Sale>();

        for (JsonNode saleNode : root) {
            // Add sale data
            Sale sale = new Sale();
            sale.setName(saleNode.get("name").getTextValue());
            sale.setSaleUrl(saleNode.get("sale_url").getTextValue());
            List<String> imageUrls = new ArrayList<String>();
            for(JsonNode imageUrl : saleNode.get("image_urls")) {
                imageUrls.add(imageUrl.getTextValue());
            }
            sale.setImageUrls(imageUrls);
            sale.setBegins(saleNode.get("begins").getTextValue());
            if(saleNode.has("ends"))
                sale.setEnds(saleNode.get("ends").getTextValue());
            if(saleNode.has("description"))
                sale.setDescription(saleNode.get("description").getTextValue());
            
            // Add product data
            if(saleNode.has("products")) {
                List<Product> products = new ArrayList<Product>();
                for(JsonNode productNode : saleNode.get("products")) {
                    Product product = new Product();
                    product.setName(productNode.get("name").getTextValue());
                    product.setBrand(productNode.get("brand").getTextValue());
                    if(productNode.has("url"))
                        product.setUrl(productNode.get("url").getTextValue());
                    if(productNode.has("image_urls")) {
                        List<String> productImageUrls = new ArrayList<String>();
                        for(JsonNode imageUrl : productNode.get("image_urls")) {
                            productImageUrls.add(imageUrl.getTextValue());
                        }
                        product.setImageUrls(productImageUrls);
                    }
                    
                    // Add product content data
                    List<ProductContent> productContents = new ArrayList<ProductContent>();
                    if(productNode.get("content").isArray()) {
                        for(JsonNode productContentNode : productNode.get("content")) {
                            ProductContent productContent = new ProductContent();
                            if(productContentNode.has("description"))
                                productContent.setDescription(productContentNode.get("description").getTextValue());
                            if(productContentNode.has("fit_notes"))
                                productContent.setFitNotes(productContentNode.get("fit_notes").getTextValue());
                            if(productContentNode.has("material"))
                                productContent.setMaterial(productContentNode.get("material").getTextValue());
                            if(productContentNode.has("care_instructions"))
                                productContent.setCareInstructions(productContentNode.get("care_instructions").getTextValue());
                            if(productContentNode.has("origin"))
                                productContent.setOrigin(productContentNode.get("origin").getTextValue());
                            productContents.add(productContent);
                        }
                    } else {
                        ProductContent productContent = new ProductContent();
                        JsonNode productContentNode = productNode.get("content");
                        if(productContentNode.has("description"))
                            productContent.setDescription(productContentNode.get("description").getTextValue());
                        if(productContentNode.has("fit_notes"))
                            productContent.setFitNotes(productContentNode.get("fit_notes").getTextValue());
                        if(productContentNode.has("material"))
                            productContent.setMaterial(productContentNode.get("material").getTextValue());
                        if(productContentNode.has("care_instructions"))
                            productContent.setCareInstructions(productContentNode.get("care_instructions").getTextValue());
                        if(productContentNode.has("origin"))
                            productContent.setOrigin(productContentNode.get("origin").getTextValue());
                        productContents.add(productContent);
                    }
                    product.setContent(productContents);
                    
                    // Add skus
                    List<Sku> skus = new ArrayList<Sku>();
                    for(JsonNode skuNode : productNode.get("skus")) {
                        Sku sku = new Sku();
                        sku.setMsrpPrice(skuNode.get("msrp_price").getDoubleValue());
                        sku.setSalePrice(skuNode.get("sale_price").getDoubleValue());
                        if(skuNode.has("shipping_surcharge"))
                            sku.setShippingSurcharge(skuNode.get("shipping_surcharge").getDoubleValue());
                        
                        // Add attributess
                        List<Map<String,String>> attributes = new ArrayList<Map<String,String>>();
                        if(skuNode.has("attributes")) {
                            for(JsonNode attributeNode : skuNode.get("attributes")) {
                                Map<String,String> attribute = new HashMap<String,String>();
                                attribute.put("name", attributeNode.get("name").getTextValue());
                                attribute.put("value", attributeNode.get("value").getTextValue());
                                attributes.add(attribute);
                            }
                        }
                        sku.setAttributes(attributes);
                    }
                    product.setSkus(skus);

                    products.add(product);
                }
                sale.setProducts(products);
            }
            sales.add(sale);
        }
        
        return sales;
    }
    
    public String getAPIKey() {
        return apiKey;
    }

}
