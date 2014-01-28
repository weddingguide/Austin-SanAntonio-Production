<%@ include file="Header.jsp" %>
<% EntityGroup theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> groupNum = <%= theObject.getGroupNum() %>
  <li> aliasOf = <%= theObject.getAliasOf() %>
  <li> type = <%= theObject.getType() %>
  <li> name = <%= theObject.getName() %>
  <li> extName = <%= theObject.getExtName() %>
  <li> description = <%= theObject.getDescription() %>
  <li> status = <%= theObject.getStatus() %>
  <li> category = <%= theObject.getCategory() %>
  <li> notifyGroup = <%= theObject.getNotifyGroup() %>
  <li> createDate = <%= theObject.getCreateDate() %>
  <li> lastUpdate = <%= theObject.getLastUpdate() %>
  <li> notifyChange = <%= theObject.getNotifyChange() %>
  <li> followUpStatusCache = <%= theObject.getFollowUpStatusCache() %>
</ul>
<%@ include file="Footer.jsp" %>
