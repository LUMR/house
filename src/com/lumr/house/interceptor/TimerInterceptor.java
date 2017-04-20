package com.lumr.house.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 记录运行时间
 * Created by fsweb on 17-4-20.
 */
public class TimerInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //获取开始执行时间
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:"+startTime);

        String result = actionInvocation.invoke();

        long endTime = System.currentTimeMillis();
        long execTime = endTime - startTime;
        System.out.println("结束时间:"+endTime+"\t耗时:"+execTime);

        return result;
    }
}
