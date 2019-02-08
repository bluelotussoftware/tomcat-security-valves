/*
 * Copyright 2019 Blue Lotus Software, LLC..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bluelotussoftware.tomcat.security.valves;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * <p>
 * The container managed security implementation using {@literal j_security_check} does not return Cache-Control headers
 * to the client. This Valve will add {@literal Cache-Control: no-cache, no-store, must-revalidate} and
 * {@literal Pragma: no-cache} headers to the {@literal j_security_check} response.</p>
 * <p>
 * This is configured in the {@literal context.xml}, or {@literal server.xml} file using the following syntax:</p>
 * <pre>
 * &lt;valve&gt;
 *   &lt;class-name&gt;com.bluelotussoftware.tomcat.security.valves.JSecurityCheckNoCacheValve&lt;/class-name&gt;
 * &lt;/valve&gt;
 * </pre>
 *
 * @author <a href="mailto:jyeary@bluelotussoftware.com">John Yeary</a>
 * @version 2.2.0
 * @since 2.2.0
 */
public class JSecurityCheckNoCacheValve extends ValveBase {

    /**
     * {@inheritDoc}
     * <p>
     * Adds {@literal Cache-Control: no-cache, no-store, must-revalidate} and {@literal Pragma: no-cache} headers to the
     * {@literal j_security_check} response.
     * </p>
     */
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("j_security_check")) {
            response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.addHeader("Pragma", "no-cache");
        }
        getNext().invoke(request, response);
    }

}
