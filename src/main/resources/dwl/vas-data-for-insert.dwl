%dw 1.0
%output application/json skipNullOn="everywhere"
---
{
        LocationCode: payload.LocationCode,
        Brand: payload.Brand,
        RateIdentification: payload.RateIdentification,
        RateType: payload.RateType,
        Description: payload.Description,
        GDDRateIdentification: payload.GDDRateIdentification,
        OTAValue: payload.OTAValue,
        CMDRValue: payload.CMDRValue[0 .. 29]
}
