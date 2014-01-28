<%@ include file="Header.jsp" %>
<% Address theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> addressId = <%= theObject.getAddressId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> addressType = <%= theObject.getAddressType() %>
  <li> addressLine1 = <%= theObject.getAddressLine1() %>
  <li> addressLine2 = <%= theObject.getAddressLine2() %>
  <li> addressLine3 = <%= theObject.getAddressLine3() %>
  <li> city = <%= theObject.getCity() %>
  <li> state = <%= theObject.getState() %>
  <li> country = <%= theObject.getCountry() %>
  <li> postalCode = <%= theObject.getPostalCode() %>
</ul>
<%@ include file="Footer.jsp" %>
