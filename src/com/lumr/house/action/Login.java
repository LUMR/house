package com.lumr.house.action;

import com.lumr.house.entity.Users;
import com.lumr.house.service.UserService;
import com.lumr.house.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by fsweb on 17-4-17.
 */
public class Login extends ActionSupport {
    private String name;
    private String password;
    @Override
    public String execute() throws Exception {
        UserService service = new UserServiceImpl();
        Users login_user = new Users(name,password);
        Users user = service.login(login_user);
        if (user!=null){
            Map<String,Object> session = ActionContext.getContext().getSession();
            session.put("user",user);
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (name.equals("")||name.length()==0)
            addFieldError("name","用户名为空");
        if (password.equals("")||password.length()==0)
            addFieldError("password","密码为空");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
