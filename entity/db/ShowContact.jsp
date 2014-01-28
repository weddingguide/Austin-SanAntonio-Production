<%@ include file="Header.jsp" %>
<% Contact theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> name = <%= theObject.getName() %>
  <li> createDate = <%= theObject.getCreateDate() %>
  <li> lastUpdate = <%= theObject.getLastUpdate() %>
</ul>
<%@ include file="Footer.jsp" %>
