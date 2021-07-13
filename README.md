# cap-tapdaq-ad

capacitor plugin for tapdaq ad network.

## Install

```bash
npm install cap-tapdaq-ad
npx cap sync
```

## API

<docgen-index>

* [`initialize(...)`](#initialize)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initialize(...)

```typescript
initialize(options: CapTapdaqAdInitializationOptions) => any
```

| Param         | Type                                                                                          |
| ------------- | --------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#captapdaqadinitializationoptions">CapTapdaqAdInitializationOptions</a></code> |

**Returns:** <code>any</code>

--------------------


### Interfaces


#### CapTapdaqAdInitializationOptions

| Prop                               | Type                 | Description                                            | Default            |
| ---------------------------------- | -------------------- | ------------------------------------------------------ | ------------------ |
| **`requestTrackingAuthorization`** | <code>boolean</code> | Use or not requestTrackingAuthorization in iOS(&gt;14) |                    |
| **`testingDevices`**               | <code>{}</code>      |                                                        |                    |
| **`initializeForTesting`**         | <code>boolean</code> |                                                        | <code>false</code> |

</docgen-api>
