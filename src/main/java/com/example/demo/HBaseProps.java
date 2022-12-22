package com.example.demo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HBaseProps {

  @Value("${hbase.master.port}")
  public String masterPort;

  @Value("${hbase.master.info.port}")
  public String masterInfoPort;

  @Value("${hbase.regionserver.port}")
  public String regionServerPort;

  @Value("${hbase.regionserver.info.port}")
  public String regionServerInfoPort;

  @Value("${hbase.zookeeper.quorum}")
  public String zookeeperQuorum;

  @Value("${hbase.localcluster.port.ephemeral}")
  public String isLocalCluserPortEphemeral;

  @Value("${hbase.client.retries.number}")
  public String clientRetriesNumber;

  @Value("${hbase.rpc.timeout}")
  public String rpcTimeout;

  @Value("${hbase.rpc.shortoperation.timeout}")
  public String rpcShortoperationTimeout;

}
