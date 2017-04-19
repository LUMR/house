<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-19
  Time: 下午1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script src="scripts/jquery-3.2.1.js"></script>
    <script src="scripts/check.js"></script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新房屋信息发布</DT>
            <DD class=past>填写房屋信息</DD>
        </DL>
        <s:fielderror></s:fielderror>
        <s:actionerror></s:actionerror>
        <s:debug></s:debug>
        <DIV class=box>
            <FORM id=add_action method="post" name="update.action" action="/update">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <input name="hid" type="password" value="${house.id}" hidden/>
                        <TR>
                            <TD class=field>标　　题：</TD>
                            <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD>
                                <SELECT id="types" class=text name=type_id>
                                    <OPTION selected value="${house.typeId}">${house.types.name}</OPTION>
                                </SELECT>
                                &nbsp;<input type="button" onclick="get_types()" value="获取">
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text name=floorage value="${house.floorage}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>房产证日期：</TD>
                            <TD><INPUT class=text type="datetime" name=houseDate value="${house.pubdate}" contenteditable="true"></TD>
                        </TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：<input type="button" onclick="get_dist()" value="获取">&nbsp;
                                <SELECT id="district" class=text name=district_id onchange="get_street(this)">
                                    <OPTION selected value="${house.street.districtId}">${house.street.district.name}</OPTION>
                                </SELECT>
                                街：
                                <SELECT id="street" class=text name=street_id >
                                    <OPTION selected value="${house.streetId}">${house.street.name}</OPTION>
                                </SELECT>
                            </TD>
                        </TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
                        <TR>
                            <TD class=field>联系方式：</TD>
                            <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"></TD>
                        </TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons><INPUT value="确认修改" type="submit">
                    </DIV>
                </DIV>
            </FORM>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
