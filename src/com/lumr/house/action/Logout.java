package com.lumr.house.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by lumr on 2017/4/17.
 */
public class Logout implements Action {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }
}
