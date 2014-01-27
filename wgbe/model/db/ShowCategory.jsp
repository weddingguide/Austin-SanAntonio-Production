<%@ include file="Header.jsp" %>
<% Category theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
  <li> keywords = <%= theObject.getKeywords() %>
  <li> imageTag = <%= theObject.getImageTag() %>
  <li> url = <%= theObject.getUrl() %>
  <li> selectedText = <%= theObject.getSelectedText() %>
</ul>
<%@ include file="Footer.jsp" %>
