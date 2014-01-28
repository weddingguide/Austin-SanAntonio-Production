<% EntityAttributeDefList theObjectList = (EntityAttributeDefList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       subId
    </th>
    <th>
       sortWeight
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
       prompt
    </th>
    <th>
       type
    </th>
    <th>
       cardinality
    </th>
    <th>
       dateRestricted
    </th>
    <th>
       userDefined
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% EntityAttributeDef theObject = (EntityAttributeDef) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getSubId() %>
    </td>
    <td>
       <%= theObject.getSortWeight() %>
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
       <%= theObject.getPrompt() %>
    </td>
    <td>
       <%= theObject.getType() %>
    </td>
    <td>
       <%= theObject.getCardinality() %>
    </td>
    <td>
       <%= theObject.getDateRestricted() %>
    </td>
    <td>
       <%= theObject.getUserDefined() %>
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
