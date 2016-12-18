package cmt.cm;

import cmt.core.Protocol;
import cmt.lang.Reader;
import cmt.infra.Queue;
import org.immutables.value.Value;

public class ChannelManagerProtocol implements Protocol<ChannelManagerConfig> {

    public ChannelManagerProtocol(Queue queue){

    }

    @Override
    public <S> S run(Reader<ChannelManagerConfig, S> reader) {
        return reader.apply(ImmutableChannelManagerConfig.builder().build());
    }
}

@Value.Immutable
interface ChannelManagerConfig {
    Queue queue();
}