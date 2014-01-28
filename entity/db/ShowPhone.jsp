<%@ include file="Header.jsp" %>
<% Phone theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> phoneId = <%= theObject.getPhoneId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> phoneNumber = <%= theObject.getPhoneNumber() %>
  <li> phoneNumberType = <%= theObject.getPhoneNumberType() %>
</ul>
<%@ include file="Footer.jsp" %>
