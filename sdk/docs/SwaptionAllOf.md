

# SwaptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**swap** | [**SwapInstrument**](SwapInstrument.md) |  | 
**payOrReceiveFixed** | [**PayOrReceiveFixedEnum**](#PayOrReceiveFixedEnum) | The available values are: NotDefined, Pay, Receive | 
**deliveryMethod** | [**DeliveryMethodEnum**](#DeliveryMethodEnum) | The available values are: Cash, Physical | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | The available values are: QuotedSecurity, InterestRateSwap, FxForward, Exotic, FxOption, CreditDefaultSwap, InterestRateSwaption, Bond, EquityOption, FixedRateLeg, FloatingRateLeg, BespokeCashflowLeg, Unknown | 



## Enum: PayOrReceiveFixedEnum

Name | Value
---- | -----
NOTDEFINED | &quot;NotDefined&quot;
PAY | &quot;Pay&quot;
RECEIVE | &quot;Receive&quot;



## Enum: DeliveryMethodEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



## Enum: InstrumentTypeEnum

Name | Value
---- | -----
QUOTEDSECURITY | &quot;QuotedSecurity&quot;
INTERESTRATESWAP | &quot;InterestRateSwap&quot;
FXFORWARD | &quot;FxForward&quot;
EXOTIC | &quot;Exotic&quot;
FXOPTION | &quot;FxOption&quot;
CREDITDEFAULTSWAP | &quot;CreditDefaultSwap&quot;
INTERESTRATESWAPTION | &quot;InterestRateSwaption&quot;
BOND | &quot;Bond&quot;
EQUITYOPTION | &quot;EquityOption&quot;
FIXEDRATELEG | &quot;FixedRateLeg&quot;
FLOATINGRATELEG | &quot;FloatingRateLeg&quot;
BESPOKECASHFLOWLEG | &quot;BespokeCashflowLeg&quot;
UNKNOWN | &quot;Unknown&quot;


