package com.gupaovip.sentinel.sentinelservice;

import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Collections;

@SpringBootApplication
public class SentinelServiceApplication {

    public static void main(String[] args) throws IOException {
        // 表示当前的节点是集群客户端
        ClusterStateManager.applyState(ClusterStateManager.CLUSTER_CLIENT);

        //initFlow();
        SpringApplication.run(SentinelServiceApplication.class, args);
        System.in.read();
    }

/*    private static void initFlow() {
        FlowRule flowRule=new FlowRule();
        flowRule.setResource("com.gupaovip.sentinel.ISayService:say(java.lang.String)");
        flowRule.setCount(10);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // QPS流量控制 直接拒绝
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        //流控针对的调用来源
        flowRule.setLimitApp("Sentinel-web");
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }*/

}
