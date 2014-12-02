package shell

def refs = context.getServiceReferences("org.jitsi.videobridge.Videobridge", null)
def videobridge = context.getService(refs[0])
videobridge.getConferenceCount()
