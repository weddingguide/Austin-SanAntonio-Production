<%@ include file="Header.jsp" %>
<% GroupValidMembership theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> groupNum = <%= theObject.getGroupNum() %>
  <li> allowsMemberType = <%= theObject.getAllowsMemberType() %>
</ul>
<%@ include file="Footer.jsp" %>
