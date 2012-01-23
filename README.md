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
gilt.getSales(null, Sale.ACTIVE, null);

// Get active sales for the Kids store
gilt.getSales(Store.KIDS, Sale.ACTIVE, null);

// Building a map option parameters
Map<String,String> options = new HashMap<String,String>();
options.put("product_detail", "true");

// Get active sales for the Kids store with full product details (requires options)
gilt.getSales(Store.KIDS, Sale.ACTIVE, options);
```

Currently each API endpoint returns a String object representing the json response. gilt-java also includes software from [codehaus.org](http://jackson.codehaus.org/).

Contribute
------------
Submit well documented code with unit tests and I will merge your changes in as long as your code does not break the build

Gilt API Endpoints
--------------------
Currently there is 1 API endpoint available with the base url being `https://api.gilt.com/v1/`.

- sales
  - Retrieve Gilt sales
  - `https://api.gilt.com/v1/sales`
  - `String getSales(String store, String action, Map<String,String> params)`

Copyright
---------
Copyright (c) 2012 Nitin Dhar. See LICENSE for details.