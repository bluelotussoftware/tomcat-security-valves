/*
 * Copyright 2017-2018 John Yeary <jyeary@bluelotussoftware.com>.
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
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * <p>
 * This {@link Valve} is designed to add an
 * {@literal X-XSS-Protection : 1; mode=block} header to the {@link Response}
 * object.</p>
 * <p>
 * This is configured in the {@literal context.xml}, or {@literal server.xml}
 * file using the following syntax:</p>
 * <pre>
 * &lt;valve&gt;
 *   &lt;class-name&gt;com.bluelotussoftware.tomcat.security.valves.XSSProtectionValve&lt;/class-name&gt;
 * &lt;/valve&gt;
 * </pre>
 *
 * @author John Yeary
 * @version 1.0.0
 */
public class XSSProtectionValve extends ValveBase {

    /**
     * {@inheritDoc}
     * <p>
     * Adds {@literal X-XSS-Protection : 1; mode=block} header to the
     * {@link Response} object.</p>
     */
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        response.addHeader("X-XSS-Protection", "1; mode=block");
        getNext().invoke(request, response);
    }

}
