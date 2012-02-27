package com.nitindhar.giltjava;

import java.util.List;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import com.nitindhar.giltjava.Endpoint;
import com.nitindhar.giltjava.GiltAPI;
import com.nitindhar.giltjava.model.Product;
import com.nitindhar.giltjava.model.Sale;
import com.nitindhar.giltjava.model.Store;

public class GiltAPITests {
    
    private Sale saleForSaleDetailsTest;
    private Sale saleForProductDetailsTest;
    
    /*
     * NOTE: replace "YOUR GILT API KEY" with your Gilt API Key before running the tests
     */

    @Test (groups={"skip"})
    public void testGetActiveSales() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        List<Sale> sales = api.getActiveSales();
        TestCase.assertNotNull(sales);
        TestCase.assertTrue(sales.size() > 0 ? true : false);
        TestCase.assertNotNull(sales.get(0).getImageUrls());
        
        saleForSaleDetailsTest = sales.get(0);
        
        for(Sale sale : sales) {
            if(sale.getProducts() != null && sale.getProducts().size() > 0) {
                saleForProductDetailsTest = sale;
                break;
            }
        }
    }
    
    @Test (groups={"skip"})
    public void testGetActiveSalesByStoreKey() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        List<Sale> sales = api.getActiveSales(Store.MEN);
        TestCase.assertNotNull(sales);
        TestCase.assertTrue(sales.size() > 0 ? true : false);
        TestCase.assertNotNull(sales.get(0).getImageUrls());
    }
    
    @Test (groups={"skip"})
    public void testGetUpcomingSales() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        List<Sale> sales = api.getUpcomingSales();
        TestCase.assertNotNull(sales);
        TestCase.assertTrue(sales.size() > 0 ? true : false);
        TestCase.assertNotNull(sales.get(0).getImageUrls());
    }
    
    @Test (groups={"skip"})
    public void testGetUpcomingSalesByStoreKey() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        List<Sale> sales = api.getUpcomingSales(Store.WOMEN);
        TestCase.assertNotNull(sales);
        TestCase.assertTrue(sales.size() > 0 ? true : false);
        TestCase.assertNotNull(sales.get(0).getImageUrls());
    }
    
    @Test (groups={"skip"}, dependsOnMethods = { "testGetActiveSales" })
    public void testGetSaleDetails() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        Sale sale = api.getSaleDetails(saleForSaleDetailsTest.getStoreKey(), saleForSaleDetailsTest.getSaleKey());
        TestCase.assertNotNull(sale);
        TestCase.assertNotNull(sale.getImageUrls());
    }
    
    @Test (groups={"skip"}, dependsOnMethods = { "testGetActiveSales" })
    public void testGetProductDetails() {
        GiltAPI api = new GiltAPI("YOUR GILT API KEY");
        String productId = saleForProductDetailsTest.getProducts().get(0)
                                                    .replace(Endpoint.BASE_URI + "products/", "")
                                                    .replace("/detail.json", "");
        Product product = api.getProductDetails(Integer.parseInt(productId));
        TestCase.assertNotNull(product);
        TestCase.assertNotNull(product.getImageUrls());
        TestCase.assertTrue(product.getSkus().size() > 0 ? true : false);
    }

}
