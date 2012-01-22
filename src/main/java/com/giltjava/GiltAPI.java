package com.giltjava;

import java.util.Map;

import com.giltjava.model.Resource;
import com.giltjava.model.Sale;
import com.giltjava.util.HttpUtil;
import com.giltjava.util.URIBuilder;

public class GiltAPI {

    private String apiKey;
    
    public GiltAPI(String apiKey) {
        this.apiKey = apiKey;
    }
    
    public String getSales(String store, String action, Map<String,String> params) {
        if(action == null || action.length() == 0)
            action = Sale.ACTIVE;
        
        String uri = new URIBuilder()
                        .resource(Resource.SALES)
                        .store(store)
                        .action(action)
                        .apikey(apiKey)
                        .params(URIBuilder.parametrizeMap(params))
                        .build();

        return HttpUtil.get(uri);
    }

}
