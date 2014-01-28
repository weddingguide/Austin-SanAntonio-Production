<% GroupCategoryList theObjectList = (GroupCategoryList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       contains
    </th>
    <th>
       detailsURL
    </th>
    <th>
       status
    </th>
    <th>
       updateType
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% GroupCategory theObject = (GroupCategory) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getContains() %>
    </td>
    <td>
       <%= theObject.getDetailsURL() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getUpdateType() %>
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
