Introduction
============

This project provides allows the use of PicoContainer-managed instances as Jersey resources.

The Jersey project provides bindings for springframework and google-guice, but I wanted to see what
it required to use PicoContainer as an IoC container within Jersey.

Dependencies
------------

* jersey APIs - see http://jersey.java.net/
* picocontainer.jar - see http://picocontainer.codehaus.org/

Alternatively you can use the [archives.watchitlater.com](http://archives.watchitlater.com/maven) maven
repository to fetch the latest binary, source and javadoc JARs.

```groovy
repositories {
  mavenCentral()
  maven { url "http://archives.watchitlater.com/maven" }
}

dependencies {
  compile 'com.watchitlater:jersey-pico:1.2.1'
}
```

Examples
--------

Please take a look at `src/test/webapp/WEB-INF/web.xml` for examples of how to configure the PicoServlet.
All the example code is located in the `com.sun.jersey.spi.pico.container.servlet.example` package in `src/test/java`.

In addition you can look at the https://github.com/tomcz/jersey-webapps project to see how I wire up
a Jersey web application using either jersey-pico or guice as the IoC container.
