package com.nitindhar.giltjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.nitindhar.giltjava.model.Product;
import com.nitindhar.giltjava.model.ProductCategoryWrapper;
import com.nitindhar.giltjava.model.Sale;
import com.nitindhar.giltjava.model.SaleWrapper;

public class GiltAPIClient implements GiltAPI {

    private static final HttpRequest http = new HttpRequest();
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String API_KEY_PARAM = "apikey";

    private final Map<String,Object> params = new HashMap<String,Object>();

    public GiltAPIClient(String apiKey) {
        params.put(API_KEY_PARAM, apiKey);
    }

    @Override
    public List<Sale> getActiveSales() {
        SaleWrapper sales = null;

        try {
            String json = http.get(Endpoint.getInstance().ACTIVE_SALES_URI, params);
            sales = mapper.readValue(json, SaleWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching active sales from Gilt", e);
        }

        return sales.getSales();
    }

    @Override
    public List<Sale> getActiveSales(String storeKey) {
        SaleWrapper sales = null;

        try {
            String json = http.get(Endpoint.getInstance().ACTIVE_SALES_BY_STORE_URI.replace("{store_key}", storeKey), params);
            sales = mapper.readValue(json, SaleWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching active sales from Gilt for store: " + storeKey, e);
        }

        return sales.getSales();
    }

    @Override
    public List<Sale> getUpcomingSales() {
        SaleWrapper sales = null;

        try {
            String json = http.get(Endpoint.getInstance().UPCOMING_SALES_URI, params);
            sales = mapper.readValue(json, SaleWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching upcoming sales from Gilt", e);
        }

        return sales.getSales();
    }

    @Override
    public List<Sale> getUpcomingSales(String storeKey) {
        SaleWrapper sales = null;

        try {
            String json = http.get(Endpoint.getInstance().UPCOMING_SALES_BY_STORE_URI.replace("{store_key}", storeKey), params);
            sales = mapper.readValue(json, SaleWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching upcoming sales from Gilt for store: " + storeKey, e);
        }

        return sales.getSales();
    }

    @Override
    public Sale getSaleDetails(String storeKey, String saleKey) {
        Sale sale = null;

        try {
            String json = http.get(Endpoint.getInstance().SALE_DETAIL_URI
                                                             .replace("{store_key}", storeKey)
                                                             .replace("{sale_key}", saleKey), params);
            sale = mapper.readValue(json, Sale.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching sale details from Gilt for store/sale: " + storeKey + "/" + saleKey, e);
        }

        return sale;
    }

    @Override
    public Product getProductDetails(int productId) {
        Product product = null;

        try {
            String json = http.get(Endpoint.getInstance().PRODUCT_DETAIL_URI.replace("{product_id}", Integer.toString(productId)), params);
            product = mapper.readValue(json, Product.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product details from Gilt for product: " + productId, e);
        }

        return product;
    }

    @Override
    public List<String> getProductCategories() {
        ProductCategoryWrapper categories = null;

        try {
            String json = http.get(Endpoint.getInstance().PRODUCT_CATEGORIES_URI, params);
            categories = mapper.readValue(json, ProductCategoryWrapper.class);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching product categories from Gilt", e);
        }

        return categories.getCategories();
    }

}