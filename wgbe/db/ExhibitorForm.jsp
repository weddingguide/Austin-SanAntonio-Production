  <tr><td>id</td><td><input type=text name='id' id='id' value='<%= theObject.getId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>orderNumber</td><td><input type=text name='orderNumber' id='orderNumber' value='<%= theObject.getOrderNumber() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>ownerId</td><td><input type=text name='ownerId' id='ownerId' value='<%= theObject.getOwnerId() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>parentGroup</td><td><input type=text name='parentGroup' id='parentGroup' value='<%= theObject.getParentGroup() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>booth</td><td><input type=text name='booth' id='booth' value='<%= theObject.getBooth() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>corner</td><td><input type=checkbox name='corner' id='corner' value='true'<% if ( theObject.getCorner() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>table4Ft</td><td><input type=text name='table4Ft' id='table4Ft' value='<%= theObject.getTable4Ft() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>table6Ft</td><td><input type=text name='table6Ft' id='table6Ft' value='<%= theObject.getTable6Ft() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>table8Ft</td><td><input type=text name='table8Ft' id='table8Ft' value='<%= theObject.getTable8Ft() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>electricity</td><td><input type=checkbox name='electricity' id='electricity' value='true'<% if ( theObject.getElectricity() == 1 ) out.print( " CHECKED " ); %>></td></tr>
  <tr><td>carpet</td><td><input type=text name='carpet' id='carpet' value='<%= theObject.getCarpet() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>dueMoney</td><td><input type=text name='dueMoney' id='dueMoney' value='<%= theObject.getDueMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>totalMoney</td><td><input type=text name='totalMoney' id='totalMoney' value='<%= theObject.getTotalMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>boothMoney</td><td><input type=text name='boothMoney' id='boothMoney' value='<%= theObject.getBoothMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>elecMoney</td><td><input type=text name='elecMoney' id='elecMoney' value='<%= theObject.getElecMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>carpetMoney</td><td><input type=text name='carpetMoney' id='carpetMoney' value='<%= theObject.getCarpetMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>tableMoney</td><td><input type=text name='tableMoney' id='tableMoney' value='<%= theObject.getTableMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>showSign</td><td><input type=text name='showSign' id='showSign' value='<%= theObject.getShowSign() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>miscMoney</td><td><input type=text name='miscMoney' id='miscMoney' value='<%= theObject.getMiscMoney() %>' size= maxchars=></td></tr></td></tr>
  <tr><td>showNotes</td><td><input type=text name='showNotes' id='showNotes' value='<%= theObject.getShowNotes() %>' size= maxchars=></td></tr></td></tr>
