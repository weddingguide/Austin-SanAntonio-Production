<%@ include file="Header.jsp" %>
<% PersonEmailMap theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> personId = <%= theObject.getPersonId() %>
  <li> emailId = <%= theObject.getEmailId() %>
</ul>
<%@ include file="Footer.jsp" %>
