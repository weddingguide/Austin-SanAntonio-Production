<%@ include file="Header.jsp" %>
<% BGContract theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> contractDate = <%= theObject.getContractDate() %>
  <li> contractTerm = <%= theObject.getContractTerm() %>
  <li> regionGroupId = <%= theObject.getRegionGroupId() %>
  <li> initialWGEdition = <%= theObject.getInitialWGEdition() %>
  <li> fullMktPkg = <%= theObject.getFullMktPkg() %>
  <li> adProd = <%= theObject.getAdProd() %>
</ul>
<%@ include file="Footer.jsp" %>
