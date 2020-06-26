

# FixedLeg

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**notional** | **Double** | scaling factor to apply to leg quantities. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.              For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as              Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**legDefinition** | [**LegDefinition**](LegDefinition.md) |  | 
**overrides** | [**FixedLegAllOfOverrides**](FixedLegAllOfOverrides.md) |  |  [optional]


