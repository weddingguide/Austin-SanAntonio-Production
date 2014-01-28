<%@ include file="Header.jsp" %>
<% SavedQuery theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> queryId = <%= theObject.getQueryId() %>
  <li> name = <%= theObject.getName() %>
  <li> queryString = <%= theObject.getQueryString() %>
  <li> queryType = <%= theObject.getQueryType() %>
  <li> sortWeight = <%= theObject.getSortWeight() %>
  <li> selected = <%= theObject.getSelected() %>
  <li> view = <%= theObject.getView() %>
</ul>
<%@ include file="Footer.jsp" %>
