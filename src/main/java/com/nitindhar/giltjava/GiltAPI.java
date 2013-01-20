package com.nitindhar.giltjava;

import java.util.List;

import com.nitindhar.giltjava.model.Product;
import com.nitindhar.giltjava.model.Sale;

public interface GiltAPI {

    /**
     * Get active sales for all Gilt stores
     *
     * @return List of sale beans
     */
    public List<Sale> getActiveSales();

    /**
     * Get active sales for the given store
     *
     * @param storeKey
     * @see com.nitindhar.giltjava.model.Store
     * @return List of sale beans
     */
    public List<Sale> getActiveSales(String storeKey);

    /**
     * Get upcoming sales for all Gilt stores
     *
     * @return List of sale beans
     */
    public List<Sale> getUpcomingSales();

    /**
     * Get upcoming sales for the given store
     *
     * @param storeKey
     * @see com.nitindhar.giltjava.model.Store
     * @return List of sale beans
     */
    public List<Sale> getUpcomingSales(String storeKey);

    /**
     * Get sale details for specific sale
     *
     * @param storeKey
     * @param saleKey
     * @see com.nitindhar.giltjava.model.Store
     * @return Sale bean
     */
    public Sale getSaleDetails(String storeKey, String saleKey);

    /**
     * Get product details for specific product id
     *
     * @param productId
     * @return Product bean
     */
    public Product getProductDetails(int productId);

    /**
     * Get all product categories available
     *
     * @return List of all product categories
     */
    public List<String> getProductCategories();

}