/*
 *
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.videobridge.groovysh;

import org.jitsi.util.*;
import org.jitsi.videobridge.*;
import org.osgi.framework.*;

/**
 * Created by gp on 20/11/14.
 */
public class GroovyShellState
{
    /**
     * The <tt>Logger</tt> used by the <tt>GroovyShellState</tt> class and
     * its instances to print debug information.
     */
    private static final Logger logger
            = Logger.getLogger(GroovyShellState.class);

    public GroovyShellState(BundleContext bundleContext)
    {
        this.bundleContext = bundleContext;

        this.initialize();
    }

    // Exposed variables.
    public final BundleContext bundleContext;
    public Videobridge videobridge;
    public Conference conference;
    public ConferenceSpeechActivity speechActivity;

    public void initialize()
    {
        ServiceReference<?>[] refs;

        try
        {
            refs = bundleContext.getServiceReferences(
                    "org.jitsi.videobridge.Videobridge", null);
        }
        catch (InvalidSyntaxException e)
        {
            logger.error(e.getMessage(), e);
            return;
        }

        if (refs == null || refs.length == 0)
        {
            return;
        }

        videobridge
                    = (Videobridge) bundleContext.getService(refs[0]);

        Conference[] conferences = videobridge.getConferences();
        if (conferences != null && conferences.length != 0)
        {
            conference = conferences[0];
        }
    }

    public void switchConference(int idx)
    {
        conference = videobridge.getConferences()[idx];
    }
}
