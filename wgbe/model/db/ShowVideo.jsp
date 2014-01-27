<%@ include file="Header.jsp" %>
<% Video theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
</ul>
<%@ include file="Footer.jsp" %>
