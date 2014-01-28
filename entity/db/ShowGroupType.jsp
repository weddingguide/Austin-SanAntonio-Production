<%@ include file="Header.jsp" %>
<% GroupType theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> groupType = <%= theObject.getGroupType() %>
  <li> grouptTypeName = <%= theObject.getGrouptTypeName() %>
  <li> implicitGroupType = <%= theObject.getImplicitGroupType() %>
  <li> acceptPersonMembers = <%= theObject.getAcceptPersonMembers() %>
  <li> acceptBusinessMembers = <%= theObject.getAcceptBusinessMembers() %>
</ul>
<%@ include file="Footer.jsp" %>
