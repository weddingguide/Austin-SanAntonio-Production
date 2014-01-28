<%@ include file="Header.jsp" %>
<% AttributeVersion theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> name = <%= theObject.getName() %>
  <li> state = <%= theObject.getState() %>
</ul>
<%@ include file="Footer.jsp" %>
