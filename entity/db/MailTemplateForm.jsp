  <tr><td>id</td><td><input type=text name='id' id='id' value='<%= theObject.getId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>name</td><td><input type=text name='name' id='name' value='<%= theObject.getName() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>description</td><td><input type=text name='description' id='description' value='<%= theObject.getDescription() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>body</td><td><input type=text name='body' id='body' value='<%= theObject.getBody() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>subject</td><td><input type=text name='subject' id='subject' value='<%= theObject.getSubject() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>qualifier</td><td><input type=text name='qualifier' id='qualifier' value='<%= theObject.getQualifier() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>toStatus</td><td><input type=text name='toStatus' id='toStatus' value='<%= theObject.getToStatus() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>toFollowup</td><td><input type=text name='toFollowup' id='toFollowup' value='<%= theObject.getToFollowup() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>statusBatch</td><td><input type=checkbox name='statusBatch' id='statusBatch' value='true'<% if ( theObject.getStatusBatch() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>groupBatch</td><td><input type=checkbox name='groupBatch' id='groupBatch' value='true'<% if ( theObject.getGroupBatch() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>individual</td><td><input type=checkbox name='individual' id='individual' value='true'<% if ( theObject.getIndividual() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>preventDuplicates</td><td><input type=checkbox name='preventDuplicates' id='preventDuplicates' value='true'<% if ( theObject.getPreventDuplicates() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>onlyToResponseDue</td><td><input type=checkbox name='onlyToResponseDue' id='onlyToResponseDue' value='true'<% if ( theObject.getOnlyToResponseDue() == 1 ) out.print( " CHECKED " ); %>></td></tr>
