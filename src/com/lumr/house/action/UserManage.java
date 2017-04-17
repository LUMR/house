package com.lumr.house.action;

import com.lumr.house.entity.Users;
import com.lumr.house.service.UserService;
import com.lumr.house.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * Created by lumr on 2017/4/17.
 */
public class UserManage implements Action {
    @Override
    public String execute() throws Exception {
        Map<String,Object> session = ActionContext.getContext().getSession();
        Users user = (Users)session.get("user");
        if (user == null)
            return ERROR;
        else{
            UserService service = new UserServiceImpl();
            Users newUser = service.getUser(user);
            session.put("user",newUser);
            return SUCCESS;
        }
    }
}
