package cmt.infra;

import akka.NotUsed;
import akka.stream.alpakka.amqp.AmqpConnectionDetails;
import akka.stream.alpakka.amqp.AmqpSinkSettings;
import akka.stream.alpakka.amqp.DefaultAmqpConnection;
import akka.stream.alpakka.amqp.javadsl.AmqpSink;
import akka.stream.javadsl.Sink;
import akka.util.ByteString;

public class QueueImpl implements Queue {


    public QueueImpl(final QueueConfig  config){
        final Sink<ByteString, NotUsed> amqpSink = AmqpSink.createSimple(
                AmqpSinkSettings.create(DefaultAmqpConnection.getInstance())
                        .withRoutingKey(queueName)
                        .withDeclarations(queueDeclaration)
        );
    }


    @Override
    public boolean push(final String message) {
        return false;
    }
}
