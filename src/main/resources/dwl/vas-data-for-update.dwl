%dw 1.0
%output application/json skipNullOn="everywhere"
---
{
		id: flowVars.record[0].id,
        LocationCode: payload.LocationCode,
        Brand: payload.Brand,
        RateIdentification: payload.RateIdentification,
        RateType: payload.RateType,
        Description: payload.Description,
        GDDRateIdentification: payload.GDDRateIdentification,
        OTAValue: 1,
        CMDRValue: payload.CMDRValue
}
