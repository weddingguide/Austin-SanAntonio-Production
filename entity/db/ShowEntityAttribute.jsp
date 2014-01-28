<%@ include file="Header.jsp" %>
<% EntityAttribute theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> version = <%= theObject.getVersion() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> attributeDefId = <%= theObject.getAttributeDefId() %>
  <li> attributeDefSubId = <%= theObject.getAttributeDefSubId() %>
  <li> attributeData = <%= theObject.getAttributeData() %>
  <li> ndx = <%= theObject.getNdx() %>
  <li> bgnDate = <%= theObject.getBgnDate() %>
  <li> endDate = <%= theObject.getEndDate() %>
  <li> lastChange = <%= theObject.getLastChange() %>
</ul>
<%@ include file="Footer.jsp" %>
