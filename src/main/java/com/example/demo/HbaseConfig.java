package com.example.demo;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
public class HbaseConfig {

    @Bean
    public HbaseTemplate hbaseTemplate() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", "127.0.0.1:16010");
        configuration.set("hbase.rootdir", "/hbase");
        configuration.set("zookeeper.znode.parent", "C:\\winutils\\bin\\hadoop-3.0.0");
        return new HbaseTemplate(configuration);
    }

}
