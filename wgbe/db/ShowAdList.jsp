<% AdList theObjectList = (AdList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       ownerId
    </th>
    <th>
       orderNumber
    </th>
    <th>
       parentGroup
    </th>
    <th>
       adType
    </th>
    <th>
       approval
    </th>
    <th>
       adPlacement
    </th>
    <th>
       adNotes
    </th>
    <th>
       status
    </th>
    <th>
       premiumPlacement
    </th>
    <th>
       optionalPlacement
    </th>
    <th>
       currentStateDueDate
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% Ad theObject = (Ad) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getOrderNumber() %>
    </td>
    <td>
       <%= theObject.getParentGroup() %>
    </td>
    <td>
       <%= theObject.getAdType() %>
    </td>
    <td>
       <%= theObject.getApproval() %>
    </td>
    <td>
       <%= theObject.getAdPlacement() %>
    </td>
    <td>
       <%= theObject.getAdNotes() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getPremiumPlacement() %>
    </td>
    <td>
       <%= theObject.getOptionalPlacement() %>
    </td>
    <td>
       <%= theObject.getCurrentStateDueDate() %>
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
