<%@ include file="Header.jsp" %>
<% EntityCustomText theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> entityType = <%= theObject.getEntityType() %>
  <li> objectType = <%= theObject.getObjectType() %>
  <li> instance = <%= theObject.getInstance() %>
  <li> longName = <%= theObject.getLongName() %>
  <li> shortName = <%= theObject.getShortName() %>
</ul>
<%@ include file="Footer.jsp" %>
