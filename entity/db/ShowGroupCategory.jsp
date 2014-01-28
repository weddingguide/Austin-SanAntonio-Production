<%@ include file="Header.jsp" %>
<% GroupCategory theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> name = <%= theObject.getName() %>
  <li> description = <%= theObject.getDescription() %>
  <li> contains = <%= theObject.getContains() %>
  <li> detailsURL = <%= theObject.getDetailsURL() %>
  <li> status = <%= theObject.getStatus() %>
  <li> updateType = <%= theObject.getUpdateType() %>
</ul>
<%@ include file="Footer.jsp" %>
