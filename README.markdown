# Spring Android and Robolectric Sample

This is a simple application that showcases how to use [Robolectric](http://robolectric.org) to test [Android](http://android.com) applications with [Spring Android](http://springsource.org/spring-android).  Robolectric includes shadows for most of Android's API, but it does not cover the [Apache HttpComponents](http://hc.apache.org/) classes that Spring Android makes use of.

I originally tried to create shadows, but found out that Robolectric does not shadow those classes, as it only restricts shadows to certain packages as seen in [AndroidTranslator](https://github.com/pivotal/robolectric/blob/5c6bc1da0de828e640fcbf1a2b6bcf1a4d956a1f/src/main/java/com/xtremelabs/robolectric/bytecode/AndroidTranslator.java#L42).

Amazingly, the solution is to simply mock [RestTemplate](http://static.springsource.org/spring-android/docs/1.0.x/api/org/springframework/web/client/RestTemplate.html).  This simple application adds a layer of indirection to RestTemplate so it can be mocked using [Mockito](http://code.google.com/p/mockito).

Note that when using [IntelliJ IDEA](http://jetbrains.com/idea) you will need to rearrange the dependency order in order to run the test in the IDE.  This is because the Android dependency is listed first, and it includes stubbed implementations as well as an older [JUnit](http://junit.org) (3.x) library.  The following libraries should be moved up before Android:

* junit-4.10.jar
* httpcore-4.0.1.jar