Gilt-Java
=========
A simple (unofficial) Java client library for the Gilt API(v1). Currently this provides basic support for fetching current and upcoming sales. gilt-java has minimal dependencies and is aimed to be easy to use.

Android
-------
Android platform to be tested soon!

Download Latest
---------------
Download the latest jar [here](https://github.com/nitindhar7/gilt-java/raw/master/dist/gilt-java-1.0.0.jar)

Build & Use
-----------
Please check [Gilt API documentation](https://api.gilt.com) for the official API descriptions and to get your private API key (required for use).
To build:

    $ ant

Examples:

``` java
GiltAPI gilt = new GiltAPIClient(API_KEY);

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
gilt.getProductDetails(productId);

// Get all available product categories
gilt.getProductCategories();
```

NOTE: gilt-java includes software from [codehaus.org](http://jackson.codehaus.org/) & [testng.org](http://testng.org/).

TODO
----

- Ensure that all the data available via Gilt API is accessible
- Return timestamps as java.sql.Timestamp instead of java.lang.String
- Convert store key to enums

Contribute
------------
Submit well documented code with unit tests and I will merge your changes in as long as your code does not break the build.

Gilt API Endpoints
--------------------
Currently there are 2 API endpoints available:

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
  - `products/categories.json => List<String> getProductCategories()`

Copyright
---------
Copyright (c) 2013 Nitin Dhar. See [MIT-LICENSE](MIT-LICENSE) for details.

Author
------

My aim is to make Forrst integration into Java applications as easy as possible. I have tried my best to provide in-code documentation for each method.

- Nitin Dhar

  - Forrst: https://forrst.com/people/nitindhar7
  - Site: http://softwarebynitin.com
  - Twitter: @nitin_dhar