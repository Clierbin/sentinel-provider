package com.gupaovip.sentinel.sentinelservice;

import com.gupaovip.sentinel.ISayService;
import org.apache.dubbo.config.annotation.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * ClassName:SayServiceImpl
 * Package:com.gupaovip.sentinel.sentinelservice
 * description
 * Created by zhangbin on 2019/8/13.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/8/13 16:18
 */
@Service
public class SayServiceImpl implements ISayService {
    @Override
    public String say(String txt) {
        return "Hello word :" +
                txt +
                ":" + LocalDateTime.now();
    }
}
