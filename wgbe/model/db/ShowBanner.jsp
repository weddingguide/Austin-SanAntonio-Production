<%@ include file="Header.jsp" %>
<% Banner theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> owner = <%= theObject.getOwner() %>
  <li> link = <%= theObject.getLink() %>
  <li> target = <%= theObject.getTarget() %>
  <li> image = <%= theObject.getImage() %>
  <li> description = <%= theObject.getDescription() %>
  <li> ndx = <%= theObject.getNdx() %>
</ul>
<%@ include file="Footer.jsp" %>
