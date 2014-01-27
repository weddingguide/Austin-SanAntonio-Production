<%@ include file="Header.jsp" %>
<% Exhibitor theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> orderNumber = <%= theObject.getOrderNumber() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> parentGroup = <%= theObject.getParentGroup() %>
  <li> booth = <%= theObject.getBooth() %>
  <li> corner = <%= theObject.getCorner() %>
  <li> table4Ft = <%= theObject.getTable4Ft() %>
  <li> table6Ft = <%= theObject.getTable6Ft() %>
  <li> table8Ft = <%= theObject.getTable8Ft() %>
  <li> electricity = <%= theObject.getElectricity() %>
  <li> carpet = <%= theObject.getCarpet() %>
  <li> dueMoney = <%= theObject.getDueMoney() %>
  <li> totalMoney = <%= theObject.getTotalMoney() %>
  <li> boothMoney = <%= theObject.getBoothMoney() %>
  <li> elecMoney = <%= theObject.getElecMoney() %>
  <li> carpetMoney = <%= theObject.getCarpetMoney() %>
  <li> tableMoney = <%= theObject.getTableMoney() %>
  <li> showSign = <%= theObject.getShowSign() %>
  <li> miscMoney = <%= theObject.getMiscMoney() %>
  <li> showNotes = <%= theObject.getShowNotes() %>
</ul>
<%@ include file="Footer.jsp" %>
