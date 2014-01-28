<% MailTemplateList theObjectList = (MailTemplateList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       name
    </th>
    <th>
       description
    </th>
    <th>
       body
    </th>
    <th>
       subject
    </th>
    <th>
       qualifier
    </th>
    <th>
       toStatus
    </th>
    <th>
       toFollowup
    </th>
    <th>
       statusBatch
    </th>
    <th>
       groupBatch
    </th>
    <th>
       individual
    </th>
    <th>
       preventDuplicates
    </th>
    <th>
       onlyToResponseDue
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% MailTemplate theObject = (MailTemplate) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getDescription() %>
    </td>
    <td>
       <%= theObject.getBody() %>
    </td>
    <td>
       <%= theObject.getSubject() %>
    </td>
    <td>
       <%= theObject.getQualifier() %>
    </td>
    <td>
       <%= theObject.getToStatus() %>
    </td>
    <td>
       <%= theObject.getToFollowup() %>
    </td>
    <td>
       <%= theObject.getStatusBatch() %>
    </td>
    <td>
       <%= theObject.getGroupBatch() %>
    </td>
    <td>
       <%= theObject.getIndividual() %>
    </td>
    <td>
       <%= theObject.getPreventDuplicates() %>
    </td>
    <td>
       <%= theObject.getOnlyToResponseDue() %>
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
