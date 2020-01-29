# Currency-Converter
With Spring Microservices

### Important Url's

* http://localhost:8080/limits -> Limits/service
* http://localhost:8888/limits-service/dev -> verifying from spring-cloud
* http://localhost:8000/currency-exchange/from/USD/to/INR -> currency Exchange
* http://localhost:8100/currency-exchange/from/USD/to/INR/quantity/1000 -> currency conversion
* http://localhost:8100/currency-exchange-feign/from/EUR/to/INR/quantity/1000 -> conversion using feign
* http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR -> with Zuul currency exchange
* http://localhost:8765/currency-conversion-service/currency-exchange-feign/from/EUR/to/INR/quantity/1000 -> with zuul currency conversion
* http://localhost:8080/actuator/bus-refresh
* http://localhost:8081/limits
