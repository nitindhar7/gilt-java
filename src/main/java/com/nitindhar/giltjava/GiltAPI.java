package com.nitindhar.giltjava;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.nitindhar.giltjava.model.Product;
import com.nitindhar.giltjava.model.Sale;
import com.nitindhar.giltjava.util.HttpUtil;

public class GiltAPI {
    
    private static final HttpUtil http = new HttpUtil();
    private static final ObjectMapper mapper = new ObjectMapper();

    private String apiKey;

    public GiltAPI(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Get active sales for all Gilt stores
     * @return List of sale beans
     */
    public List<Sale> getActiveSales() {
        List<Sale> sales = new ArrayList<Sale>();
        
        try {
            String activeSales = http.get(Endpoint.getInstance().ACTIVE_SALES_URI + http.appendAPIKey(getAPIKey()));
            
            JsonNode root = mapper.readTree(activeSales);
            for (JsonNode saleNode : root.get("sales")) {
                Sale sale = mapper.readValue(saleNode.toString(), Sale.class);
                sales.add(sale);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching active sales from Gilt", e);
        }
        
        return sales;
    }
    
    /**
     * Get active sales for the given store
     * @param storeKey 
     * @see com.nitindhar.giltjava.model.Store
     * @return List of sale beans
     */
    public List<Sale> getActiveSales(String storeKey) {
        List<Sale> sales = new ArrayList<Sale>();
        
        try {
            String activeSales = http.get(Endpoint.getInstance().ACTIVE_SALES_BY_STORE_URI.replace("{store_key}", storeKey) + http.appendAPIKey(getAPIKey()));
            
            JsonNode root = mapper.readTree(activeSales);
            for (JsonNode saleNode : root.get("sales")) {
                Sale sale = mapper.readValue(saleNode.toString(), Sale.class);
                sales.add(sale);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching active sales from Gilt for store: " + storeKey, e);
        }
        
        return sales;
    }

    /**
     * Get upcoming sales for all Gilt stores
     * @return List of sale beans
     */
    public List<Sale> getUpcomingSales() {
        List<Sale> sales = new ArrayList<Sale>();
        
        try {
            String upcomingSales = http.get(Endpoint.getInstance().UPCOMING_SALES_URI + http.appendAPIKey(getAPIKey()));
            
            JsonNode root = mapper.readTree(upcomingSales);
            for (JsonNode saleNode : root.get("sales")) {
                Sale sale = mapper.readValue(saleNode.toString(), Sale.class);
                sales.add(sale);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching upcoming sales from Gilt", e);
        }
        
        return sales;
    }

    /**
     * Get upcoming sales for the given store
     * @param storeKey
     * @see com.nitindhar.giltjava.model.Store
     * @return List of sale beans
     */
    public List<Sale> getUpcomingSales(String storeKey) {
        List<Sale> sales = new ArrayList<Sale>();
        
        try {
            String upcomingSales = http.get(Endpoint.getInstance().UPCOMING_SALES_BY_STORE_URI.replace("{store_key}", storeKey) + http.appendAPIKey(getAPIKey()));
            
            JsonNode root = mapper.readTree(upcomingSales);
            for (JsonNode saleNode : root.get("sales")) {
                Sale sale = mapper.readValue(saleNode.toString(), Sale.class);
                sales.add(sale);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching upcoming sales from Gilt for store: " + storeKey, e);
        }
        
        return sales;
    }
    
    /**
     * Get sale details for specific sale
     * @param storeKey
     * @param saleKey
     * @see com.nitindhar.giltjava.model.Store
     * @return Sale bean
     */
    public Sale getSaleDetails(String storeKey, String saleKey) {
        Sale sale = null;
        
        try {
            String saleData = http.get(Endpoint.getInstance().SALE_DETAIL_URI
                                                             .replace("{store_key}", storeKey)
                                                             .replace("{sale_key}", saleKey) + 
                                                             http.appendAPIKey(getAPIKey()));
            sale = mapper.readValue(saleData, Sale.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching sale details from Gilt for store/sale: " + storeKey + "/" + saleKey, e);
        }
        
        return sale;
    }
    
    /**
     * Get product details for specific product id
     * @param productId
     * @return Product bean
     */
    public Product getProductDetails(int productId) {
        Product product = null;
        
        try {
            String productData = http.get(Endpoint.getInstance().PRODUCT_DETAIL_URI.replace("{product_id}", Integer.toString(productId)) + http.appendAPIKey(getAPIKey()));
            product = mapper.readValue(productData, Product.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product details from Gilt for product: " + productId, e);
        }
        
        return product;
    }
    
    public String getAPIKey() {
        return apiKey;
    }

}
