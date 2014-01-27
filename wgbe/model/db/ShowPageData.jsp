<%@ include file="Header.jsp" %>
<% PageData theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> pageDescription = <%= theObject.getPageDescription() %>
  <li> keywords = <%= theObject.getKeywords() %>
  <li> googleVerify = <%= theObject.getGoogleVerify() %>
  <li> bingVerify = <%= theObject.getBingVerify() %>
  <li> homePageFeaturedSliderInt = <%= theObject.getHomePageFeaturedSliderInt() %>
  <li> urlPrefix = <%= theObject.getUrlPrefix() %>
  <li> googleAnalytics = <%= theObject.getGoogleAnalytics() %>
  <li> cssName = <%= theObject.getCssName() %>
</ul>
<%@ include file="Footer.jsp" %>
