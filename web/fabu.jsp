<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-6
  Time: 下午3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script src="scripts/jquery-3.2.1.js"></script>
    <script src="scripts/check.js"></script>
    <script>
        $(document).ready(
            function () {
                $("#types").load("/get_types");
                $("#district").load("/get_dist");
            }
        );
    </script>
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
        <DIV class=box>
            <FORM id=add_action method=post name=add.action action="/fabu">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD class=field>标　　题：</TD>
                            <TD><INPUT id=add_action_title class=text type=text name=title></TD>
                        </TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD>
                                <SELECT id="types" class=text name=type_id>
                                    <OPTION selected value=1000>一室一厅</OPTION>
                                </SELECT>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text name=floorage></TD>
                        </TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text name=price></TD>
                        </TR>
                        <TR>
                            <TD class=field>房产证日期：</TD>
                            <TD><INPUT class=text type="date" name=houseDate></TD>
                        </TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：
                                <SELECT id="district" class=text name=district_id onchange="get_street(this)">
                                    <OPTION selected value=1004>海淀区</OPTION>
                                </SELECT>
                                街：
                                <SELECT id="street" class=text name=street_id >
                                    <OPTION selected value=1001>中关村大街</OPTION>
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
                            <TD><INPUT id=add_action_contact class=text type=text name=contact></TD>
                        </TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description></TEXTAREA></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons><INPUT value=立即发布 type="submit">
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
