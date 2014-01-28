<% HistoryList theObjectList = (HistoryList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       eventId
    </th>
    <th>
       eventType
    </th>
    <th>
       date
    </th>
    <th>
       ownerId
    </th>
    <th>
       ownerType
    </th>
    <th>
       description
    </th>
    <th>
       comment
    </th>
    <th>
       originator
    </th>
    <th>
       reference
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% History theObject = (History) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getEventId() %>
    </td>
    <td>
       <%= theObject.getEventType() %>
    </td>
    <td>
       <%= theObject.getDate() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getDescription() %>
    </td>
    <td>
       <%= theObject.getComment() %>
    </td>
    <td>
       <%= theObject.getOriginator() %>
    </td>
    <td>
       <%= theObject.getReference() %>
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
