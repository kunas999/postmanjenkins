%dw 1.0
%output application/java
---
{
        LocationCode: payload.LocationCode,
        Brand: payload.Brand,
        RateIdentification: payload.RateIdentification
}
