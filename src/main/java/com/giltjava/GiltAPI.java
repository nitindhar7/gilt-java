package com.giltjava;

import java.util.List;
import java.util.Map;

import com.giltjava.model.Resource;
import com.giltjava.model.Sale;
import com.giltjava.util.URIBuilder;

public class GiltAPI {

    private String apiKey;
    
    public GiltAPI(String apiKey) {
        this.apiKey = apiKey;
    }
    
    public List<Sale> getSales(String action, Map<String,String> params) {
        return null;
    }

    public List<Sale> getSales(String store, String action, Map<String,String> params) {
        if(action == null || action.length() == 0)
            action = Sale.ACTIVE;
        
        URIBuilder builder = new URIBuilder();
        builder.resource(Resource.SALES);
        builder.store(store);
        builder.action(action);
        builder.apikey(apiKey);
        builder.params(URIBuilder.parametrizeMap(params));
        builder.build();
        
        return null;
    }

}
