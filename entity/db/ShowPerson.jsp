<%@ include file="Header.jsp" %>
<% Person theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> personId = <%= theObject.getPersonId() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> lastName = <%= theObject.getLastName() %>
  <li> firstName = <%= theObject.getFirstName() %>
  <li> middleName = <%= theObject.getMiddleName() %>
  <li> title = <%= theObject.getTitle() %>
  <li> nickName = <%= theObject.getNickName() %>
  <li> suffix = <%= theObject.getSuffix() %>
  <li> preferredName = <%= theObject.getPreferredName() %>
  <li> sex = <%= theObject.getSex() %>
  <li> age = <%= theObject.getAge() %>
  <li> createDate = <%= theObject.getCreateDate() %>
  <li> lastUpdate = <%= theObject.getLastUpdate() %>
  <li> status = <%= theObject.getStatus() %>
  <li> recordType = <%= theObject.getRecordType() %>
  <li> comment = <%= theObject.getComment() %>
  <li> url = <%= theObject.getUrl() %>
  <li> siteDefEntityType = <%= theObject.getSiteDefEntityType() %>
  <li> birthDate = <%= theObject.getBirthDate() %>
</ul>
<%@ include file="Footer.jsp" %>
