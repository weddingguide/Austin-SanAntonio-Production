<%@ include file="Header.jsp" %>
<% SegmentDef theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> name = <%= theObject.getName() %>
  <li> status = <%= theObject.getStatus() %>
  <li> ndx = <%= theObject.getNdx() %>
  <li> displayName = <%= theObject.getDisplayName() %>
  <li> description = <%= theObject.getDescription() %>
  <li> type = <%= theObject.getType() %>
</ul>
<%@ include file="Footer.jsp" %>
