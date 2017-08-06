# tomcat-security-valves
This provides [Valve](https://tomcat.apache.org/tomcat-8.5-doc/api/org/apache/catalina/Valve.html) implementations to add response security headers to container managed security on Apache Tomcat. The valves may be implemented by adding them to the **conf/context.xml** file for all deployements on Apache Tomcat, or to the project **context.xml** as shown below:
```
    <!-- These can be replaced with the org.apache.catalina.filters.HttpHeaderSecurityFilter. -->
    <!-- However it does not secure container-managed-security. You must use a Valve to handle that case. -->

    <Valve className="com.bluelotussoftware.tomcat.security.valves.XContentTypeOptionsValve" />
    <Valve className="com.bluelotussoftware.tomcat.security.valves.XFrameOptionsValve" />
    <Valve className="com.bluelotussoftware.tomcat.security.valves.XSSProtectionValve" />
```
The binaries are deployed to Maven Central at the following coordinates:
```
<dependency>
  <groupId>com.bluelotussoftware</groupId>
  <artifactId>tomcat-security-valves</artifactId>
  <version>1.0.0</version>
</dependency>
```
