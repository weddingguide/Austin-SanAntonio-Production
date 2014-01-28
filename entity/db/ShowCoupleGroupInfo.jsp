<%@ include file="Header.jsp" %>
<% CoupleGroupInfo theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> status = <%= theObject.getStatus() %>
  <li> musicReceived = <%= theObject.getMusicReceived() %>
  <li> musicInfoDetails = <%= theObject.getMusicInfoDetails() %>
  <li> invitationReceived = <%= theObject.getInvitationReceived() %>
  <li> invitationInfoDetails = <%= theObject.getInvitationInfoDetails() %>
  <li> programReceived = <%= theObject.getProgramReceived() %>
  <li> programInfoDetails = <%= theObject.getProgramInfoDetails() %>
  <li> priceListVersion = <%= theObject.getPriceListVersion() %>
  <li> hoursOnSite = <%= theObject.getHoursOnSite() %>
  <li> loveStory = <%= theObject.getLoveStory() %>
  <li> photoMontage = <%= theObject.getPhotoMontage() %>
  <li> completeCeremony = <%= theObject.getCompleteCeremony() %>
  <li> numberOfDVDs = <%= theObject.getNumberOfDVDs() %>
  <li> negotiatedItems = <%= theObject.getNegotiatedItems() %>
  <li> webPublication = <%= theObject.getWebPublication() %>
  <li> catalog = <%= theObject.getCatalog() %>
  <li> createDate = <%= theObject.getCreateDate() %>
  <li> registryCatalog = <%= theObject.getRegistryCatalog() %>
  <li> project = <%= theObject.getProject() %>
  <li> titleText = <%= theObject.getTitleText() %>
</ul>
<%@ include file="Footer.jsp" %>
