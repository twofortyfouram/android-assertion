[![Build Status](https://travis-ci.org/twofortyfouram/android-assertion.png?branch=master)](https://travis-ci.org/twofortyfouram/android-assertion)
# Overview
The android-assert-lib implements runtime assertions for Android application development.  Although it is possible to use Java's ```assert``` mechanism on Android, it is disabled by default and enabling it requires physical access to the device.  The benefit of this library is that the developer has direct control over whether assertions are enabled or not.  For example, assertions could be enabled for debug builds and stripped out with ProGuard for release builds.


# API Reference
JavaDocs for the library are published [here](http://twofortyfouram.github.io/android-assertion).


# Compatibility
The library is compatible and optimized for Android API Level 8 and above.


# Download
## Gradle
The library is published as an artifact to the two forty four a.m. maven repository.  To use the library, the two forty four a.m. maven repository and the artifact need to be added to your build script.

The build.gradle repositories section would look something like the following:

    repositories {
        mavenCentral()
        maven { url 'https://dl.bintray.com/twofortyfouram/maven' }
    }

And the dependencies section would look something like this:
    
    dependencies {
        compile group:'com.twofortyfouram', name:'android-assertion', version:'1.0.0+', ext:'aar'
    }
