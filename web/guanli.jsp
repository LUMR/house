<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-6
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <TITLE>青鸟租房 - 用户管理</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="css/style.css">

    <META name=GENERATOR>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
    <DIV class=search>
        <label class="ui-blue"><code>你好! ${user.name}</code></label>
        <LABEL class="ui-green searchs"><a href="fabu.jsp" title="">发布房屋信息</a></LABEL>
        <LABEL class="ui-green searchs"><a href="logout.action" title="">注销</a></LABEL>
    </DIV>
</DIV>
<s:actionerror></s:actionerror>
<s:debug></s:debug>
<DIV class="main wrap">
    <DIV id=houseArea>
        <TABLE class=house-list>
            <TBODY>
            <c:forEach var="house" items="${user.houses}" varStatus="status">
                <TR <c:if test="${status.count%2==0}">class="odd" </c:if> >
                <TD class=house-thumb><SPAN><A href="details.htm" target="_blank">
                    <img src="../images/thumb_house.gif" width="100" height="75" alt=""></A></SPAN></TD>
                <TD>
                    <DL>
                        <DT><A href="/details?hid=${house.id}" target="_blank">${house.title}</A></DT>
                        <DD>${house.street.district.name}${house.street.name},${house.floorage}平米<BR>联系方式：${house.contact}</DD>
                    </DL>
                </TD>
                <TD class=house-type><LABEL class=ui-green>
                    <a href="updateform.action?hid=${house.id}" ><INPUT  value="修    改" type=button name=search></a></LABEL>
                </TD>
                <TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search></LABEL></TD>
            </TR>
            </c:forEach>

            </TBODY>
        </TABLE>
    </DIV>
    <DIV class=pager>
        <UL>
            <LI class=current><A id=widget_338868862
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">1</A>
            </LI>
            <LI class=current><A id=widget_1160989910
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">2</A>
            </LI>
        </UL>
        <SPAN class=total>1/2页</SPAN></DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
