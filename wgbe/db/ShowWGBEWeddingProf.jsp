<%@ include file="Header.jsp" %>
<% WGBEWeddingProf theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> groupId = <%= theObject.getGroupId() %>
  <li> weddingProfId = <%= theObject.getWeddingProfId() %>
  <li> summaryText = <%= theObject.getSummaryText() %>
  <li> description = <%= theObject.getDescription() %>
  <li> image1 = <%= theObject.getImage1() %>
  <li> image2 = <%= theObject.getImage2() %>
  <li> image3 = <%= theObject.getImage3() %>
</ul>
<%@ include file="Footer.jsp" %>
