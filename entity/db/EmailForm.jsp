  <tr><td>emailId</td><td><input type=text name='emailId' id='emailId' value='<%= theObject.getEmailId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>ownerId</td><td><input type=text name='ownerId' id='ownerId' value='<%= theObject.getOwnerId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>ownerType</td><td><input type=text name='ownerType' id='ownerType' value='<%= theObject.getOwnerType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>subscribe</td><td><input type=checkbox name='subscribe' id='subscribe' value='true'<% if ( theObject.getSubscribe() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>emailAddress</td><td><input type=text name='emailAddress' id='emailAddress' value='<%= theObject.getEmailAddress() %>' size=40 maxchars=120></td></tr></td></tr>
  <tr><td>emailAddressType</td><td><input type=text name='emailAddressType' id='emailAddressType' value='<%= theObject.getEmailAddressType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>refKey</td><td><input type=text name='refKey' id='refKey' value='<%= theObject.getRefKey() %>' size= maxchars=></td></tr></td></tr>
