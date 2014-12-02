jitsi-videobridge-groovysh is an OSGi bundle that gives full access to the
Jitsi Videobridge internals through a Groovy Shell.

To build the bundle run

    mvn package

Alternatively, you can drop [org.jitsi.videobridge.groovysh-1.0-SNAPSHOT.jar](target/org.jitsi.videobridge.groovysh-1.0-SNAPSHOT.jar)
somewhere in your classpath and tell the bridge to launch

    org.jitsi.videobridge.groovysh.GroovyShellActivator

To tell the bridge to launch the groovy shell activator, put the [bundles.txt](resources/bundles.txt) file under ~/.sip-communicator

To access the groovy shell run

    socat -,raw,echo=0,opost TCP:127.0.0.1:6869

If you wish to run it in a production environment you'll need to wrap it around
an ssh shell.
