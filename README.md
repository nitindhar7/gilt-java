Gilt-Java
=========
A simple Java client library for the Gilt API(v1). Currently this library is in development and will provide basic support for fetching current and upcoming
sales. gilt-java has minimal dependencies and is aimed to be easy to use.

Android
-------
Android platform to be tested soon!

Build & Use
-----------
Please check [Gilt API documentation](https://api.gilt.com) for the official API descriptions and to get your private API key (required for use).
To build:

    $ ant

Examples:

``` java
GiltAPI gilt = new GiltAPI(API_KEY);

// Get active sales for all Gilt stores
gilt.getActiveSales();

// Get active sales for the Kids store
gilt.getActiveSales(Store.KIDS);

// Get upcoming sales for all Gilt stores
gilt.getUpcomingSales();

// Get upcoming sales for the Womens store
gilt.getUpcomingSales(Store.WOMEN);

// Get sale details for specific sale
gilt.getSaleDetails(sale.getStoreKey(), sale.getSaleKey());

// Get product details for specific product id
gilt.getProductDetails(productId)
```

NOTE: gilt-java includes software from [codehaus.org](http://jackson.codehaus.org/) & [testng.org](http://testng.org/).

Contribute
------------
Submit well documented code with unit tests and I will merge your changes in as long as your code does not break the build.

Gilt API Endpoints
--------------------
Currently there is 2 API endpoints available:

- Base Url
  - https://api.gilt.com/v1/{endpoint}?apikey={apikey}

- Sales Endpoint
  - `sales/active.json => List<Sale> getActiveSales()`
  - `sales/{store_key}/active.json => List<Sale> getActiveSales(String storeKey)`
  - `sales/upcoming.json => List<Sale> getUpcomingSales()`
  - `sales/{store_key}/upcoming.json => List<Sale> getUpcomingSales(String storeKey)`
  - `sales/{store_key}/{sale_key}/detail.json => List<Sale> getSaleDetails(String storeKey, String saleKey)`

- Products Endpoint
  - `products/{product_id}/detail.json => Product getProductDetails(int productId)`

Copyright
---------
Copyright (c) 2012 Nitin Dhar. See LICENSE for details.