<%@ include file="Header.jsp" %>
<% BlogPost theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
</ul>
<%@ include file="Footer.jsp" %>
