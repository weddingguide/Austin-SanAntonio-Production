<%@ include file="Header.jsp" %>
<% ContactStatus theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> category = <%= theObject.getCategory() %>
  <li> name = <%= theObject.getName() %>
  <li> sortWeight = <%= theObject.getSortWeight() %>
  <li> trackContactActivity = <%= theObject.getTrackContactActivity() %>
  <li> listContacts = <%= theObject.getListContacts() %>
  <li> displayInReport = <%= theObject.getDisplayInReport() %>
</ul>
<%@ include file="Footer.jsp" %>
