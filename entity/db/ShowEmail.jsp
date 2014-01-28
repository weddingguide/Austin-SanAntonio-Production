<%@ include file="Header.jsp" %>
<% Email theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> emailId = <%= theObject.getEmailId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> subscribe = <%= theObject.getSubscribe() %>
  <li> emailAddress = <%= theObject.getEmailAddress() %>
  <li> emailAddressType = <%= theObject.getEmailAddressType() %>
  <li> refKey = <%= theObject.getRefKey() %>
</ul>
<%@ include file="Footer.jsp" %>
