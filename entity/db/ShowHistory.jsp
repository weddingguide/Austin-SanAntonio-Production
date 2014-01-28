<%@ include file="Header.jsp" %>
<% History theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> eventId = <%= theObject.getEventId() %>
  <li> eventType = <%= theObject.getEventType() %>
  <li> date = <%= theObject.getDate() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> description = <%= theObject.getDescription() %>
  <li> comment = <%= theObject.getComment() %>
  <li> originator = <%= theObject.getOriginator() %>
  <li> reference = <%= theObject.getReference() %>
</ul>
<%@ include file="Footer.jsp" %>
