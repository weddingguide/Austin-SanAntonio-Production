  <tr><td>groupNum</td><td><input type=text name='groupNum' id='groupNum' value='<%= theObject.getGroupNum() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>memberType</td><td><input type=text name='memberType' id='memberType' value='<%= theObject.getMemberType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>memberId</td><td><input type=text name='memberId' id='memberId' value='<%= theObject.getMemberId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>memberRole</td><td><input type=text name='memberRole' id='memberRole' value='<%= theObject.getMemberRole() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>memberRoleText</td><td><input type=text name='memberRoleText' id='memberRoleText' value='<%= theObject.getMemberRoleText() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>associatedWithOwnerType</td><td><input type=text name='associatedWithOwnerType' id='associatedWithOwnerType' value='<%= theObject.getAssociatedWithOwnerType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>associatedWithOwnerId</td><td><input type=text name='associatedWithOwnerId' id='associatedWithOwnerId' value='<%= theObject.getAssociatedWithOwnerId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>primaryMember</td><td><input type=checkbox name='primaryMember' id='primaryMember' value='true'<% if ( theObject.getPrimaryMember() == 1 ) out.print( " CHECKED " ); %>></td></tr>
