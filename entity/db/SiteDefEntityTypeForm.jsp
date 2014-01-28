  <tr><td>id</td><td><input type=text name='id' id='id' value='<%= theObject.getId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>entityType</td><td><input type=text name='entityType' id='entityType' value='<%= theObject.getEntityType() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>name</td><td><input type=text name='name' id='name' value='<%= theObject.getName() %>' size=40 maxchars=100></td></tr></td></tr>
  <tr><td>searchDefault</td><td><input type=checkbox name='searchDefault' id='searchDefault' value='true'<% if ( theObject.getSearchDefault() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>matchEntityStatus</td><td><input type=text name='matchEntityStatus' id='matchEntityStatus' value='<%= theObject.getMatchEntityStatus() %>' size= maxchars=></td></tr></td></tr>
