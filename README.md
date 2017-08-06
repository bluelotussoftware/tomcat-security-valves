# tomcat-security-valves
This provides [Valve](https://tomcat.apache.org/tomcat-8.5-doc/api/org/apache/catalina/Valve.html) implementations to add response security headers to container managed security on Apache Tomcat. The valves may be implemented by adding them to the **conf/context.xml** file as shown below:
```
    <!-- These can be replaced with the org.apache.catalina.filters.HttpHeaderSecurityFilter. -->
    <!-- However it does not secure container-managed-security. You must use a Valve to handle that case. -->

    <Valve className="com.bluelotussoftware.tomcat.security.valves.XContentTypeOptionsValve" />
    <Valve className="com.bluelotussoftware.tomcat.security.valves.XFrameOptionsValve" />
    <Valve className="com.bluelotussoftware.tomcat.security.valves.XSSProtectionValve" />
```
