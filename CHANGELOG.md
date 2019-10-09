# Change Log
## v4.1.1.0 (2019/09/26)
* Updated to AdColony SDK 4.1.1 (iOS).

## v4.1.0.0 (2019/09/26)
* Updated to AdColony SDK 4.1.1 (iOS) and 4.1.0 (Android).
* Added support for banners.

## v3.3.11 (2019/07/15)
* Updated to AdColony SDK 3.3.11 (Android)
* [Android] Fixed ConcurrentModificationException that was exposed with a server-side update.
* [Android] Fixed an issue related to partial downloads that potentially caused AdColony to become disabled.

## v3.3.10 (2019/06/12)
* Updated to AdColony SDK 3.3.8.1 (iOS) and 3.3.10 (Android)
* [iOS] Fixed a bug where click action for some of the ads was not working.
* [Android] Improved WebView behavior for duties previously handled by our shared object libraries.

## v3.3.9 (2019/03/20)
* Updated to AdColony SDK 3.3.9 (Android)
* [Android] Fixed NullPointerException that stopped ads from being served on Android Lollipop devices with the 3.3.7 and 3.3.8 SDKs.

## v3.3.8 (2019/01/25)
* Updated to AdColony SDK 3.3.7 (iOS) and 3.3.8 (Android)
* [iOS] Fixed a CPU watchdog transgression.
* [iOS] Fixed a memory leak that could cause UIView objects to stay in memory past their lifetime.
* [iOS] Added advanced logging for inconsistent view controller orientations.
* [iOS] Several other bug fixes and stability improvements.
* [Android] Handled RuntimeExceptions that can occur during WebView initialization if the device reports that it is missing the WebView package.

## v3.3.7 (2018/12/06)
* Updated to AdColony SDK 3.3.7 (Android)
* [Android] Significant stability improvements related to memory consumption.
* [Android] Reduced ad request response times.
* [Android] Removed shared object (.so) libraries, reducing the size of our SDK distribution by 94% in the process, as well as addressing issues [#25](https://github.com/AdColony/AdColony-Android-SDK-3/issues/25), [#33](https://github.com/AdColony/AdColony-Android-SDK-3/issues/33), and [#38](https://github.com/AdColony/AdColony-Android-SDK-3/issues/38).

## v3.3.6 (2018/11/19)
* Updated to AdColony SDK 3.3.6 (iOS) and 3.3.4 (Android)
* [iOS] Added support for silencing audio with the Ringer/Silent switch. This is configurable on the clients.adcolony.com dashboard.
* [iOS] Audio session will not activate until an ad plays.
* [Android] Added additional configure() signatures that accept an Application context instead of Activity.
* [Android] Deprecated AdColonyAdViewActivity, AdColonyNativeAdView, and onAudioStarted/onAudioStopped() callbacks.
* [Android] Handle API level 28 changes for [default cleartext traffic behavior](https://developer.android.com/about/versions/pie/android-9.0-changes-28#framework-security-changes).
* [All] Several bug fixes and stability improvements.

## v3.3.5 (2018/07/06)
* Officially open sourced Unity plugin

## v3.3.4 (2018/05/25)
* Updated to AdColony SDK 3.3.4 (iOS) and 3.3.4 (Android)
* [iOS] Fixed a bug where advertisement video's close button was not easily tappable because of the status bar overlapping.
* [iOS] Fixed a bug where unsafe access to the device's battery level was causing a crash mentioned in [iOS SDK issue #49](https://github.com/AdColony/AdColony-iOS-SDK-3/issues/49).
* [Android] Fixed new NullPointerException mentioned in [Android SDK issue #29](https://github.com/AdColony/AdColony-Android-SDK-3/issues/29#issuecomment-381380548).
* [Unity] Added a new API to pass user consent as required for compliance with the European Union's General Data Protection Regulation (GDPR). If you are collecting consent from your users, you can make use of this new API to inform AdColony and all downstream consumers of the consent. Please see our GDPR FAQ for more information and our GDPR wiki for implementation details.
* [Unity] Removed symbolic links from within native SDK
* [Unity] Fixed missing zone ID in some log statements
* [Unity] Fixed exception during OnRequestInterstitialFailed callback mentioned in [Unity Plugin issue #42](https://github.com/AdColony/AdColony-Unity-SDK-3/issues/42)
* [All] Several bug fixes and stability improvements.

## v3.3.0 (2018/02/02)
* Updated to AdColony SDK 3.3.0 (iOS) and 3.3.0 (Android)
* Added Integral Ad Science (IAS) for viewability measurement
* Better iPhone X compatibility (iOS)
* Fixed storage overuse issue reported by a small number of publishers upgrading from 2.x -> 3.x (Android)
* Several bug fixes, memory usage optimizations, and stability improvements

## v3.2.1 (2017/09/20)
* Updated to AdColony SDK 3.2.1 (iOS) and 3.2.0 (Android).
* Support for iOS 11 and Android O
* Added onLeftApplication and onClicked callbacks
* Various bugfixes from support channels

## v3.1.0 (2017/04/07)
* Updated to AdColony SDK 3.1.1 (iOS) and 3.1.2 (Android).
* Updated to Google PlayServicesResolver 1.2.15
* Support for thin/fat Android builds
* Removed AdColony Compass™ public API
* Added OnRequestInterstitialFailedWithZone event
* Deprecating OnRequestInterstitialFailed event
* Adds -ObjC linker flag to iOS builds for Aurora SDK 3.0 ads
* Misc cleanup and bugfixes

## 3.0.6 (2016/12/16)
* Updated the Unity SDK package to use iOS and Android SDK 3.0.6.

## 3.0.0 (2016/11/04)
* Initial upload of the Unity plugin and sample app.
