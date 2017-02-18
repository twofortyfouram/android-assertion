[![CircleCI](https://circleci.com/gh/twofortyfouram/android-assertion.svg?style=svg)](https://circleci.com/gh/twofortyfouram/android-assertion)

# Overview
The android-assertion-lib implements runtime assertions for Android application development.  Java's ```assert``` mechanism does not work consistently on Android and Google has lint checks to look for this Android antipattern.  Although ```assert``` can sometimes be used on Android, it is disabled by default and enabling it requires physical access to the device.

The benefit of this library is that the developer has direct control over whether assertions are enabled or not.  For example, assertions could be enabled for debug builds and stripped out with ProGuard for release builds.


# API Reference
JavaDocs for the library are published [here](https://twofortyfouram.github.io/android-assertion).


# Compatibility
The library is compatible and optimized for Android API Level 8 and above.


# Download
## Gradle
The library is published as an artifact to jCenter.  To use the library, the jCenter repository and the artifact need to be added to your build script.

The build.gradle repositories section would look something like the following:

    repositories {
        jcenter()
    }

And the dependencies section would look something like this:
    
    dependencies {
        compile group:'com.twofortyfouram', name:'android-assertion', version:'[1.1.1,2.0['
    }

# History
* 1.0.0: Initial release
* 1.0.1: Update Android Gradle plugin, which changed the generated BuildConfig
* 1.0.2: Replace two forty four a.m. nullness annotations with Android support annotations
* 1.0.4: Reupload artifacts with source and JavaDoc for inclusion in jCenter
* 1.1.0: Added assertions for Maps
* 1.1.1: Fix infinite loop in BundleAssertions.  Thanks @csibesz07 for reporting this issue
