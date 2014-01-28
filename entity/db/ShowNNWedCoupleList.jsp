<%@ include file="Header.jsp" %>
<% NNWedCoupleList theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> status = <%= theObject.getStatus() %>
  <li> coupleId = <%= theObject.getCoupleId() %>
  <li> hisEmilAddress = <%= theObject.getHisEmilAddress() %>
  <li> hisName = <%= theObject.getHisName() %>
  <li> herEmailAddress = <%= theObject.getHerEmailAddress() %>
  <li> herName = <%= theObject.getHerName() %>
  <li> hisLastName = <%= theObject.getHisLastName() %>
  <li> hisFirstName = <%= theObject.getHisFirstName() %>
  <li> herLastName = <%= theObject.getHerLastName() %>
  <li> herFirstName = <%= theObject.getHerFirstName() %>
  <li> dateAdded = <%= theObject.getDateAdded() %>
  <li> dateRemoved = <%= theObject.getDateRemoved() %>
  <li> weddingDate = <%= theObject.getWeddingDate() %>
  <li> hisAddressLine1 = <%= theObject.getHisAddressLine1() %>
  <li> hisAddressLine2 = <%= theObject.getHisAddressLine2() %>
  <li> hisAddressLine3 = <%= theObject.getHisAddressLine3() %>
  <li> herAddressLine1 = <%= theObject.getHerAddressLine1() %>
  <li> herAddressLine2 = <%= theObject.getHerAddressLine2() %>
  <li> herAddressLine3 = <%= theObject.getHerAddressLine3() %>
  <li> hisPhone = <%= theObject.getHisPhone() %>
  <li> herPhone = <%= theObject.getHerPhone() %>
  <li> notes = <%= theObject.getNotes() %>
  <li> hisWorkPhone = <%= theObject.getHisWorkPhone() %>
  <li> herWorkPhone = <%= theObject.getHerWorkPhone() %>
  <li> hisBirthDate = <%= theObject.getHisBirthDate() %>
  <li> herBirthDate = <%= theObject.getHerBirthDate() %>
</ul>
<%@ include file="Footer.jsp" %>
