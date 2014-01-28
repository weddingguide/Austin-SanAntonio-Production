<%@ include file="Header.jsp" %>
<% SiteDefEntityType theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> entityType = <%= theObject.getEntityType() %>
  <li> name = <%= theObject.getName() %>
  <li> searchDefault = <%= theObject.getSearchDefault() %>
  <li> matchEntityStatus = <%= theObject.getMatchEntityStatus() %>
</ul>
<%@ include file="Footer.jsp" %>
