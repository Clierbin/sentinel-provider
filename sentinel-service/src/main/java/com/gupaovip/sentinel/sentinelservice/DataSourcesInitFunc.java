package com.gupaovip.sentinel.sentinelservice;

import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientAssignConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfigManager;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * ClassName:DataSourcesInitFunc
 * Package:com.gupaovip.sentinel.sentinelservice
 * description
 * Created by zhangbin on 2019/8/13.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/13 19:25
 */
public class DataSourcesInitFunc  implements InitFunc{
    // token-server 的地址
    private final String CLUSTER_SERVER_HOST="localhost";
    // 端口号
    private final int CLUSTER_SERVER_PORT=9999;
    // 请求超时时间
    private final int REQUEST_TIME_OUT=30000;
    // `namespace`
    private final String APP_NAME="App-Zb";

    // naocs 的配置
    private final String remoteAddress="192.168.5.178";//nacos 远程地址
    private final String groupId="SENTINEL_GROUP";// group ID
    private final String FLOW_POSTFIX="-flow-rules";// namespace+ FLOW_POSTFIX = dataId
    @Override
    public void init() throws Exception {
        // 加载集群信息
        loadClusterClientConfig();
        registryClusterFlowRuleProperty();
    }

    private void loadClusterClientConfig(){
        //群集客户端分配配置
        ClusterClientAssignConfig clusterClientAssignConfig = new ClusterClientAssignConfig();
        clusterClientAssignConfig.setServerHost(CLUSTER_SERVER_HOST);// 设置集群客户端host
        clusterClientAssignConfig.setServerPort(CLUSTER_SERVER_PORT);// 设置集群客户端port
        ClusterClientConfigManager.applyNewAssignConfig(clusterClientAssignConfig);

        ClusterClientConfig clusterClientConfig=new ClusterClientConfig();
        clusterClientConfig.setRequestTimeout(REQUEST_TIME_OUT);
        ClusterClientConfigManager.applyNewConfig(clusterClientConfig);
    }
    // 注册动态数据规则
    private void registryClusterFlowRuleProperty(){
        ReadableDataSource<String, List<FlowRule>> rds=
                new NacosDataSource<>(remoteAddress,groupId,APP_NAME+FLOW_POSTFIX,
                        source-> JSON.parseObject(source,new TypeReference<List<FlowRule>>(){}));
        FlowRuleManager.register2Property(rds.getProperty());
    }
}
