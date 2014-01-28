<% ContactStatusList theObjectList = (ContactStatusList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       category
    </th>
    <th>
       name
    </th>
    <th>
       sortWeight
    </th>
    <th>
       trackContactActivity
    </th>
    <th>
       listContacts
    </th>
    <th>
       displayInReport
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% ContactStatus theObject = (ContactStatus) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getCategory() %>
    </td>
    <td>
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getSortWeight() %>
    </td>
    <td>
       <%= theObject.getTrackContactActivity() %>
    </td>
    <td>
       <%= theObject.getListContacts() %>
    </td>
    <td>
       <%= theObject.getDisplayInReport() %>
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
