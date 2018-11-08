package com.bluelotussoftware.tomcat.security.valves;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * <p>
 * This {@link Valve} is designed to add an {@literal Referrer-Policy: strict-origin-when-cross-origin} header to the
 * {@link Response} object.</p>
 * <p>
 * This is configured in the {@literal context.xml}, or {@literal server.xml} file using the following syntax:</p>
 * <pre>
 * &lt;valve&gt;
 *   &lt;class-name&gt;com.bluelotussoftware.tomcat.security.valves.ReferrerPolicyValve&lt;/class-name&gt;
 * &lt;/valve&gt;
 * </pre>
 *
 * @author Oliver Kohll
 * @version 1.0.0
 */
public class ReferrerPolicyValve extends ValveBase {

    /**
     * {@inheritDoc}
     * <p>
     * Adds {@literal Referrer-Policy: strict-origin-when-cross-origin} header to the {@link Response} object.</p>
     */
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        response.addHeader("Referrer-Policy", "strict-origin-when-cross-origin");
        getNext().invoke(request, response);
    }

}
