<%@ include file="Header.jsp" %>
<% Region theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> name = <%= theObject.getName() %>
  <li> group = <%= theObject.getGroup() %>
  <li> featuredVendorGroupId = <%= theObject.getFeaturedVendorGroupId() %>
  <li> businessId = <%= theObject.getBusinessId() %>
  <li> texasWeddingsBusinessId = <%= theObject.getTexasWeddingsBusinessId() %>
  <li> texasWeddingsGroup = <%= theObject.getTexasWeddingsGroup() %>
  <li> mobileDomain = <%= theObject.getMobileDomain() %>
  <li> faceBook = <%= theObject.getFaceBook() %>
  <li> twitter = <%= theObject.getTwitter() %>
  <li> mySpace = <%= theObject.getMySpace() %>
  <li> pinterest = <%= theObject.getPinterest() %>
  <li> phone = <%= theObject.getPhone() %>
  <li> email = <%= theObject.getEmail() %>
  <li> virtualBookLink = <%= theObject.getVirtualBookLink() %>
  <li> siteSpecificAttributeSubId = <%= theObject.getSiteSpecificAttributeSubId() %>
  <li> blog = <%= theObject.getBlog() %>
  <li> bridalExtravaganza = <%= theObject.getBridalExtravaganza() %>
</ul>
<%@ include file="Footer.jsp" %>
