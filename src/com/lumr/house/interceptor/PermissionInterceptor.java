package com.lumr.house.interceptor;

import com.lumr.house.entity.Users;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 验证是否已登录
 * Created by fsweb on 17-4-20.
 */
public class PermissionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Users user = (Users) actionInvocation.getInvocationContext().getSession().get("user");
        if (user == null)
            return "login";
        return actionInvocation.invoke();
    }
}
