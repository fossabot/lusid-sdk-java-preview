

# ValuationsReconciliationRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**left** | [**ValuationReconciliationRequest**](ValuationReconciliationRequest.md) |  | 
**right** | [**ValuationReconciliationRequest**](ValuationReconciliationRequest.md) |  | 
**leftToRightMapping** | [**List&lt;ReconciliationLeftRightAddressKeyPair&gt;**](ReconciliationLeftRightAddressKeyPair.md) | The mapping from property keys requested by left aggregation to property keys on right hand side |  [optional]
**preserveKeys** | **List&lt;String&gt;** | List of keys to preserve (from rhs) in the diff. Used in conjunction with filtering/grouping |  [optional]



