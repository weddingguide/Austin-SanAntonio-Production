<%@ include file="Header.jsp" %>
<% EntityAttributeDef theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> subId = <%= theObject.getSubId() %>
  <li> sortWeight = <%= theObject.getSortWeight() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> name = <%= theObject.getName() %>
  <li> prompt = <%= theObject.getPrompt() %>
  <li> type = <%= theObject.getType() %>
  <li> cardinality = <%= theObject.getCardinality() %>
  <li> dateRestricted = <%= theObject.getDateRestricted() %>
  <li> userDefined = <%= theObject.getUserDefined() %>
</ul>
<%@ include file="Footer.jsp" %>
