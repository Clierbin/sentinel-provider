package com.gupaovip.sentinel.sentinelapp;

import com.gupaovip.sentinel.ISayService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:SentinelController
 * Package:com.gupaovip.sentinel.sentinelapp
 * description
 * Created by zhangbin on 2019/8/13.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/13 17:06
 */
@RestController
public class SentinelController {
    @Reference(timeout = 3000)
    private ISayService iSayService;
    @RequestMapping("/say")
    public String say(){
        //RpcContext.getContext().setAttachment("dubboApplication","Sentinel-web");
        return iSayService.say("Mic");
    }
//    @RequestMapping("/say2")
//    public String say2(){
//        return iSayService.say("Mic");
//    }
}
