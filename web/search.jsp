<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-14
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 - 首页</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=navbar class=wrap>
    <DL class="search clearfix">
        <FORM id="sform" method="post" action="/search">
            <DT>
            <UL>
                <LI class=bold>房屋信息</LI>
                <LI>标题：<INPUT class=text type=text name=title> <LABEL class=ui-blue>
                    <INPUT value=搜索房屋 type="submit" name=search></LABEL>
                </LI>
            </UL>
            </DT>
            <DD>
                <UL>
                    <LI class=first>价格</LI>
                    <LI><SELECT name=price>
                        <OPTION selected value="0">不限</OPTION>
                        <OPTION value=1>100元以下</OPTION>
                        <OPTION value=2>100元—200元</OPTION>
                        <OPTION value=3>200元以上</OPTION>
                    </SELECT></LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>房屋位置</LI>
                    <LI><SELECT id=street name=street_id>
                        <OPTION selected value="0">不限</OPTION>
                        <c:forEach var="district" items="${districts}">
                            <OPTION value="${district.id}">${district.name}</OPTION>
                        </c:forEach>

                    </SELECT></LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>房型</LI>
                    <LI><SELECT name=type_id>
                        <OPTION selected value="0">不限</OPTION>
                        <c:forEach var="type" items="${types}">
                            <OPTION value="${type.id}">${type.name}</OPTION>
                        </c:forEach>

                    </SELECT>
                    </LI>
                </UL>
            </DD>
            <DD>
                <UL>
                    <LI class=first>面积</LI>
                    <LI><SELECT name=floorage>
                        <OPTION selected value="0">不限</OPTION>
                        <OPTION value=1>40以下</OPTION>
                        <OPTION value=2>40-500</OPTION>
                        <OPTION value=3>500以上</OPTION>
                    </SELECT></LI>
                </UL>
            </DD>
        </FORM>
    </DL>
</DIV>
<DIV class="main wrap">
    <TABLE class=house-list>
        <TBODY>

        <c:forEach var="house" items="${houses}" varStatus="stats">
            <TR <c:if test="${stats.count%2==0}">class="odd" </c:if>>
                <TD class=house-thumb><span><A href="details.htm" target="_blank">
                <img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
                <TD>
                    <DL>
                        <DT><A href="/details?hid=${house.id}" target="_blank">${house.title}</A></DT>
                        <DD>${house.description}<BR>联系方式：${house.contact}</DD>
                    </DL>
                </TD>
                <TD class=house-type>${house.types.name}</TD>
                <TD class=house-price><SPAN>${house.price}</SPAN>元/月</TD>
            </TR>
        </c:forEach>

        </TBODY>
    </TABLE>
    <DIV class=pager>
        <UL>
            <LI class=current><A href="/index">首页</A></LI>
            <LI><A href="/search?page=${page-1}">上一页</A></LI>
            <LI><A href="/search?page=${page+1}">下一页</A></LI>
            <LI><A href="/search?page=-1">末页</A></LI>
        </UL>
        <SPAN
                class=total>1/2页</SPAN></DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
