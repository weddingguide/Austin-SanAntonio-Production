<% SegmentDefList theObjectList = (SegmentDefList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       ownerType
    </th>
    <th>
       ownerId
    </th>
    <th>
       name
    </th>
    <th>
       status
    </th>
    <th>
       ndx
    </th>
    <th>
       displayName
    </th>
    <th>
       description
    </th>
    <th>
       type
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% SegmentDef theObject = (SegmentDef) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getNdx() %>
    </td>
    <td>
       <%= theObject.getDisplayName() %>
    </td>
    <td>
       <%= theObject.getDescription() %>
    </td>
    <td>
       <%= theObject.getType() %>
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
