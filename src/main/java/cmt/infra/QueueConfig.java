package cmt.infra;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class QueueConfig {


    private final String name;

    public QueueConfig(){
        Config config = ConfigFactory.load().getConfig("queue");
        name = config.getString("name");
    }

}
