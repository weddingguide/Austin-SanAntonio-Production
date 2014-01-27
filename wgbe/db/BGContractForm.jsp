  <tr><td>id</td><td><input type=text name='id' id='id' value='<%= theObject.getId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>ownerId</td><td><input type=text name='ownerId' id='ownerId' value='<%= theObject.getOwnerId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>contractDate</td><td><input type=text name='contractDate' id='contractDate' value='<%= theObject.getContractDate() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>contractTerm</td><td><input type=text name='contractTerm' id='contractTerm' value='<%= theObject.getContractTerm() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>regionGroupId</td><td><input type=text name='regionGroupId' id='regionGroupId' value='<%= theObject.getRegionGroupId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>initialWGEdition</td><td><input type=text name='initialWGEdition' id='initialWGEdition' value='<%= theObject.getInitialWGEdition() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>fullMktPkg</td><td><input type=checkbox name='fullMktPkg' id='fullMktPkg' value='true'<% if ( theObject.getFullMktPkg() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>adProd</td><td><input type=text name='adProd' id='adProd' value='<%= theObject.getAdProd() %>' size= maxchars=></td></tr></td></tr>
