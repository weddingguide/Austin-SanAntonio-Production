<%@ include file="Header.jsp" %>
<% Ad theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> orderNumber = <%= theObject.getOrderNumber() %>
  <li> parentGroup = <%= theObject.getParentGroup() %>
  <li> adType = <%= theObject.getAdType() %>
  <li> approval = <%= theObject.getApproval() %>
  <li> adPlacement = <%= theObject.getAdPlacement() %>
  <li> adNotes = <%= theObject.getAdNotes() %>
  <li> status = <%= theObject.getStatus() %>
  <li> premiumPlacement = <%= theObject.getPremiumPlacement() %>
  <li> optionalPlacement = <%= theObject.getOptionalPlacement() %>
  <li> currentStateDueDate = <%= theObject.getCurrentStateDueDate() %>
</ul>
<%@ include file="Footer.jsp" %>
