<%@ include file="Header.jsp" %>
<% ProfileContactInfo theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> address = <%= theObject.getAddress() %>
</ul>
<%@ include file="Footer.jsp" %>
