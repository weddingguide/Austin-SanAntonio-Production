<% ExhibitorList theObjectList = (ExhibitorList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
<script>
function selectId( aForm, selectedId )
{
   aForm.selectedIdNumber.value = selectedId;
}
</script>
      <form name=form1 action=ModifyOrDelete.jsp type=post>
         <input type=hidden name=selectedIdNumber id=selectedIdNumber>
 
         <center>
            <p>
         <input type=submit name=action id=action value="Add">
            &nbsp;
<table border=2>
  <tr>
    <th>
    </th>
    <th>
       id
    </th>
    <th>
       orderNumber
    </th>
    <th>
       ownerId
    </th>
    <th>
       parentGroup
    </th>
    <th>
       booth
    </th>
    <th>
       corner
    </th>
    <th>
       table4Ft
    </th>
    <th>
       table6Ft
    </th>
    <th>
       table8Ft
    </th>
    <th>
       electricity
    </th>
    <th>
       carpet
    </th>
    <th>
       dueMoney
    </th>
    <th>
       totalMoney
    </th>
    <th>
       boothMoney
    </th>
    <th>
       elecMoney
    </th>
    <th>
       carpetMoney
    </th>
    <th>
       tableMoney
    </th>
    <th>
       showSign
    </th>
    <th>
       miscMoney
    </th>
    <th>
       showNotes
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% Exhibitor theObject = (Exhibitor) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getId() %>
    </td>
    <td>
       <%= theObject.getOrderNumber() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getParentGroup() %>
    </td>
    <td>
       <%= theObject.getBooth() %>
    </td>
    <td>
       <%= theObject.getCorner() %>
    </td>
    <td>
       <%= theObject.getTable4Ft() %>
    </td>
    <td>
       <%= theObject.getTable6Ft() %>
    </td>
    <td>
       <%= theObject.getTable8Ft() %>
    </td>
    <td>
       <%= theObject.getElectricity() %>
    </td>
    <td>
       <%= theObject.getCarpet() %>
    </td>
    <td>
       <%= theObject.getDueMoney() %>
    </td>
    <td>
       <%= theObject.getTotalMoney() %>
    </td>
    <td>
       <%= theObject.getBoothMoney() %>
    </td>
    <td>
       <%= theObject.getElecMoney() %>
    </td>
    <td>
       <%= theObject.getCarpetMoney() %>
    </td>
    <td>
       <%= theObject.getTableMoney() %>
    </td>
    <td>
       <%= theObject.getShowSign() %>
    </td>
    <td>
       <%= theObject.getMiscMoney() %>
    </td>
    <td>
       <%= theObject.getShowNotes() %>
    </td>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Remove"
          <%= " onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
  </tr>
  <% } %>
</table>
