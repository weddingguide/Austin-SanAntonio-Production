  <tr><td>ownerType</td><td><input type=text name='ownerType' id='ownerType' value='<%= theObject.getOwnerType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>ownerId</td><td><input type=text name='ownerId' id='ownerId' value='<%= theObject.getOwnerId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>status</td><td><input type=text name='status' id='status' value='<%= theObject.getStatus() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>musicReceived</td><td><input type=text name='musicReceived' id='musicReceived' value='<%= theObject.getMusicReceived() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>musicInfoDetails</td><td><input type=text name='musicInfoDetails' id='musicInfoDetails' value='<%= theObject.getMusicInfoDetails() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>invitationReceived</td><td><input type=text name='invitationReceived' id='invitationReceived' value='<%= theObject.getInvitationReceived() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>invitationInfoDetails</td><td><input type=text name='invitationInfoDetails' id='invitationInfoDetails' value='<%= theObject.getInvitationInfoDetails() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>programReceived</td><td><input type=text name='programReceived' id='programReceived' value='<%= theObject.getProgramReceived() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>programInfoDetails</td><td><input type=text name='programInfoDetails' id='programInfoDetails' value='<%= theObject.getProgramInfoDetails() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>priceListVersion</td><td><input type=text name='priceListVersion' id='priceListVersion' value='<%= theObject.getPriceListVersion() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>hoursOnSite</td><td><input type=text name='hoursOnSite' id='hoursOnSite' value='<%= theObject.getHoursOnSite() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>loveStory</td><td><input type=checkbox name='loveStory' id='loveStory' value='true'<% if ( theObject.getLoveStory() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>photoMontage</td><td><input type=checkbox name='photoMontage' id='photoMontage' value='true'<% if ( theObject.getPhotoMontage() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>completeCeremony</td><td><input type=checkbox name='completeCeremony' id='completeCeremony' value='true'<% if ( theObject.getCompleteCeremony() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>numberOfDVDs</td><td><input type=text name='numberOfDVDs' id='numberOfDVDs' value='<%= theObject.getNumberOfDVDs() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>negotiatedItems</td><td><input type=text name='negotiatedItems' id='negotiatedItems' value='<%= theObject.getNegotiatedItems() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>webPublication</td><td><input type=checkbox name='webPublication' id='webPublication' value='true'<% if ( theObject.getWebPublication() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>catalog</td><td><input type=text name='catalog' id='catalog' value='<%= theObject.getCatalog() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>createDate</td><td><input type=text name='createDate' id='createDate' value='<%= theObject.getCreateDate() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>registryCatalog</td><td><input type=text name='registryCatalog' id='registryCatalog' value='<%= theObject.getRegistryCatalog() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>project</td><td><input type=text name='project' id='project' value='<%= theObject.getProject() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>titleText</td><td><input type=text name='titleText' id='titleText' value='<%= theObject.getTitleText() %>' size= maxchars=></td></tr></td></tr>
