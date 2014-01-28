<%@ include file="Header.jsp" %>
<% SavedQueries theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
  <li> SQLString = <%= theObject.getSQLString() %>
</ul>
<%@ include file="Footer.jsp" %>
