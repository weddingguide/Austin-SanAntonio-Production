<%@ include file="Header.jsp" %>
<% ContactStatusCategory theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> name = <%= theObject.getName() %>
  <li> css = <%= theObject.getCss() %>
</ul>
<%@ include file="Footer.jsp" %>
