<%@ include file="Header.jsp" %>
<% SegmentSong theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> segment = <%= theObject.getSegment() %>
  <li> songLength = <%= theObject.getSongLength() %>
  <li> song = <%= theObject.getSong() %>
  <li> artist = <%= theObject.getArtist() %>
  <li> details = <%= theObject.getDetails() %>
  <li> location = <%= theObject.getLocation() %>
</ul>
<%@ include file="Footer.jsp" %>
