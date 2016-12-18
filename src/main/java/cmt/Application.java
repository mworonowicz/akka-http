package cmt;

import cmt.cm.ChannelManagerProtocol;
import cmt.infra.Queue;
import cmt.infra.QueueImpl;

public interface Application {

    Queue queue = new QueueImpl();
    ChannelManagerProtocol channelManagerProtocol = new ChannelManagerProtocol(queue);

}
