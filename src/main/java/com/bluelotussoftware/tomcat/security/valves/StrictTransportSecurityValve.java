package com.bluelotussoftware.tomcat.security.valves;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * <p>
 * This {@link Valve} is designed to add an {@literal Strict-Transport-Security: max-age=2592000; includeSubDomains}
 * header to the {@link Response} object. The max-age value represents 30 days.</p>
 * <p>
 * This is configured in the {@literal context.xml}, or {@literal server.xml} file using the following syntax:</p>
 * <pre>
 * &lt;valve&gt;
 *   &lt;class-name&gt;com.bluelotussoftware.tomcat.security.valves.StrictTransportSecurityValve&lt;/class-name&gt;
 * &lt;/valve&gt;
 * </pre>
 *
 * @author Oliver Kohll
 * @author John Yeary
 * @version 1.0.1
 */
public class StrictTransportSecurityValve extends ValveBase {

    /**
     * Set the default max age to 30 days in seconds.
     */
    private static final long DEFAULT_MAX_AGE = 2592000;
    
    /**
     * {@inheritDoc}
     * <p>
     * Adds {@literal Strict-Transport-Security: max-age=2592000; includeSubDomains} header to the {@link Response}
     * object.</p>
     */
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        response.addHeader("Strict-Transport-Security", "max-age="+ DEFAULT_MAX_AGE +"; includeSubDomains");
        getNext().invoke(request, response);
    }

}
