# Changelog

## Version 2.2.0
- Incorporate changes for App Store Server API v1.12 and App Store Server Notifications v2.12 [https://github.com/apple/app-store-server-library-java/pull/103]
- Handle null appAccountToken appropriately in PromotionalOfferSignatureCreator [https://github.com/apple/app-store-server-library-java/pull/100]

## Version 2.1.0
- Incorporate changes for App Store Server API v1.11 and App Store Server Notifications v2.11 [https://github.com/apple/app-store-server-library-java/pull/94]
- Add proxy authenticator support [https://github.com/apple/app-store-server-library-java/pull/93]
- Various documentation and quality of life improvements, including contributions from @hakusai22

## Version 2.0.0
- Incorporate changes for App Store Server API v1.10.1 [https://github.com/apple/app-store-server-library-java/pull/77]
  - This change is a breaking change, as the datatype of the price field has changed from Integer to Long

## Version 1.1.0
- Support App Store Server Notifications v2.10 [https://github.com/apple/app-store-server-library-java/pull/74]
- Require appAppleId in SignedDataVerifier for the Production environment [https://github.com/apple/app-store-server-library-java/pull/68]

## Version 1.0.0
- Switch from GSON to Jackson for parsing [https://github.com/apple/app-store-server-library-java/pull/58]
- Rename Status to VerificationStatus [https://github.com/apple/app-store-server-library-java/pull/59]
- Add message to APIException and update JavaDocs [https://github.com/apple/app-store-server-library-java/pull/60]

## Version 0.2.0
- Significantly increase unit test coverage [https://github.com/apple/app-store-server-library-java/pull/51]
- Add support for Xcode and LocalTesting environments [https://github.com/apple/app-store-server-library-java/pull/49]
- Allow parsing unknown Enum values [https://github.com/apple/app-store-server-library-java/pull/50]
- Add support for testing in Java 21 [https://github.com/apple/app-store-server-library-java/pull/48]
- Add error codes from App Store Server API v1.9 [https://github.com/apple/app-store-server-library-java/pull/43]
- Add new fields from App Store Server API v1.10 [https://github.com/apple/app-store-server-library-java/pull/53]
- Fix private key parsing on Windows from @vpavic [https://github.com/apple/app-store-server-library-java/pull/41]

## Version 0.1.3

- Add status field to Data [https://github.com/apple/app-store-server-library-java/pull/34]
- Publish JavaDocs

## Version 0.1.2

- Make SignedDataVerifier::decodeSignedObject protected

## Version 0.1.1

- Move release to Maven Central
- The additional repository is no longer needed in a Gradle/Maven config
