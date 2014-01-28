<%@ include file="Header.jsp" %>
<% Customer theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> groupId = <%= theObject.getGroupId() %>
  <li> createDate = <%= theObject.getCreateDate() %>
  <li> lastUpdate = <%= theObject.getLastUpdate() %>
  <li> notifyChange = <%= theObject.getNotifyChange() %>
</ul>
<%@ include file="Footer.jsp" %>
