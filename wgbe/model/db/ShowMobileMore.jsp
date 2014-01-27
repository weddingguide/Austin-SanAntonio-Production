<%@ include file="Header.jsp" %>
<% MobileMore theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
</ul>
<%@ include file="Footer.jsp" %>
