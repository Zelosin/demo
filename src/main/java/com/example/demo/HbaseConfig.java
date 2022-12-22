package com.example.demo;

import com.google.protobuf.ServiceException;
import java.io.IOException;
import java.util.UUID;
import lombok.Getter;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

@Configuration
public class HbaseConfig {

  @Getter
  private Admin admin;

  @Getter
  @Autowired
  private HBaseProps hBaseProps;

  private org.apache.hadoop.conf.Configuration configuration;

  @Bean
  public HbaseTemplate createHbaseAdmin() throws IOException, ServiceException {
    configuration = HBaseConfiguration.create();

    configuration.set("hbase.master.port", hBaseProps.getMasterPort());
    configuration.set("hbase.master.info.port", hBaseProps.getMasterInfoPort());
    configuration.set("hbase.regionserver.port", hBaseProps.getRegionServerPort());
    configuration.set("hbase.regionserver.info.port", hBaseProps.getRegionServerInfoPort());
    configuration.set("hbase.zookeeper.quorum", hBaseProps.getZookeeperQuorum());
    configuration.set("hbase.localcluster.port.ephemeral", hBaseProps.getIsLocalCluserPortEphemeral());

    configuration.set("hbase.client.retries.number", hBaseProps.getClientRetriesNumber());
    configuration.set("hbase.rpc.timeout", hBaseProps.getRpcTimeout());
    configuration.set("hbase.rpc.shortoperation.timeout", hBaseProps.getRpcShortoperationTimeout());

    Connection connection = ConnectionFactory.createConnection(configuration);
    admin = connection.getAdmin();

    HBaseAdmin.checkHBaseAvailable(configuration);

    HTableDescriptor descriptor = new HTableDescriptor(UUID.randomUUID().toString());
    descriptor.addFamily(new HColumnDescriptor(UUID.randomUUID().toString()));
    admin.createTable(descriptor);

    return new HbaseTemplate(configuration);
  }

}
