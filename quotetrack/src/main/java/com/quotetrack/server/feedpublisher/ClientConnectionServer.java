package com.quotetrack.server.feedpublisher;

import java.util.Set;

interface ClientConnectionServer {
    void publishMessage(Message message);
}
