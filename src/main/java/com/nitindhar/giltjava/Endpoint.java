package com.nitindhar.giltjava;

public class Endpoint {

    /**
     * All calls should be made using https://api.gilt.com/v1/
     * as the endpoint (e.g. calling sales/active.json would be
     * https://api.gilt.com/v1/sales/active.json?apikey=...).
     */
    public static final String BASE_URI = "https://api.gilt.com/v1/";

    public final String ACTIVE_SALES_URI = BASE_URI + "sales/active.json";
    public final String ACTIVE_SALES_BY_STORE_URI = BASE_URI + "sales/{store_key}/active.json";
    public final String UPCOMING_SALES_URI = BASE_URI + "sales/upcoming.json";
    public final String UPCOMING_SALES_BY_STORE_URI = BASE_URI + "sales/{store_key}/upcoming.json";
    public final String SALE_DETAIL_URI = BASE_URI + "sales/{store_key}/{sale_key}/detail.json";
    public final String PRODUCT_DETAIL_URI = BASE_URI + "products/{product_id}/detail.json";
    public final String PRODUCT_CATEGORIES_URI = BASE_URI + "/products/categories.json";

    private static Endpoint endpoint = new Endpoint();

    /**
     * Returns an instance of the endpoint singleton
     * @return endpoint
     */
    public static Endpoint getInstance() {
        return endpoint;
    }

}