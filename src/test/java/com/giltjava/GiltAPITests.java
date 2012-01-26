package com.giltjava;

import java.util.List;

import org.testng.annotations.Test;

import com.giltjava.model.Sale;
import com.giltjava.model.Store;

public class GiltAPITests {

    @Test (groups={"skip"})
    public void testGetSales() {
        GiltAPI api = new GiltAPI("2a79c53507fe657d88a685380bf46021");
        
        List<Sale> sales = api.getSales(Store.KIDS, Sale.ACTIVE, null);
        for(Sale sale : sales) {
            System.out.println(sale.getName());
        }
    }

}
