# Location Demo

A simple demo to demonstrate handling duplicate input values

## Endpoints
- saveCountry [POST] http://localhost:8080/country
- getCountryById [GET] http://localhost:8080/country/0
- updateCountry [PUT] http://localhost:8080/country
- deleteCountry [DELETE] http://localhost:8080/country/0
- saveCity [POST] http://localhost:8080/city
- getCityById [GET] http://localhost:8080/city/0
- updateCity [PUT] http://localhost:8080/city
- deleteCityById [DELETE] http://localhost:8080/city/0
- throwException [GET] http://localhost:8080/throw

## Examples

[saveCountry](http://localhost:8080/country) JSON body input
```json
{
  "name": "Australia",
  "code": "AUS"
}
```
[saveCity](http://localhost:8080/city) JSON body input
```json
{
    "name": "Brisbane",
    "plateNumber": "5",
    "country": {
        "name": "Australia",
        "code": "AUS"
    }
}
```
[findCityById/2](http://localhost:8080/city/2) Would return the following JSON
```json
{
    "id": 2,
    "name": "Brisbane",
    "plateNumber": 5,
    "country": {
        "id": 1,
        "name": "Australia",
        "code": "AUS"
    }
}
```
http://localhost:8080/throw will return the following
```text
This exception was thrown intentionally by the endpoint "/throw"
```

[AussieDev81](https://github.com/AussieDev81)