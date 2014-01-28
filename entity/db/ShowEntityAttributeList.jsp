<% EntityAttributeList theObjectList = (EntityAttributeList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       version
    </th>
    <th>
       ownerType
    </th>
    <th>
       ownerId
    </th>
    <th>
       attributeDefId
    </th>
    <th>
       attributeDefSubId
    </th>
    <th>
       attributeData
    </th>
    <th>
       ndx
    </th>
    <th>
       bgnDate
    </th>
    <th>
       endDate
    </th>
    <th>
       lastChange
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% EntityAttribute theObject = (EntityAttribute) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getVersion() %>
    </td>
    <td>
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getAttributeDefId() %>
    </td>
    <td>
       <%= theObject.getAttributeDefSubId() %>
    </td>
    <td>
       <%= theObject.getAttributeData() %>
    </td>
    <td>
       <%= theObject.getNdx() %>
    </td>
    <td>
       <%= theObject.getBgnDate() %>
    </td>
    <td>
       <%= theObject.getEndDate() %>
    </td>
    <td>
       <%= theObject.getLastChange() %>
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
