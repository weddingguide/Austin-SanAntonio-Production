<%@ include file="Header.jsp" %>
<% GroupMemberMap theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> groupNum = <%= theObject.getGroupNum() %>
  <li> memberType = <%= theObject.getMemberType() %>
  <li> memberId = <%= theObject.getMemberId() %>
  <li> memberRole = <%= theObject.getMemberRole() %>
  <li> memberRoleText = <%= theObject.getMemberRoleText() %>
  <li> associatedWithOwnerType = <%= theObject.getAssociatedWithOwnerType() %>
  <li> associatedWithOwnerId = <%= theObject.getAssociatedWithOwnerId() %>
  <li> primaryMember = <%= theObject.getPrimaryMember() %>
</ul>
<%@ include file="Footer.jsp" %>
