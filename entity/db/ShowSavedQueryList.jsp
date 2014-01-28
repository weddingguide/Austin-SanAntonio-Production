<% SavedQueryList theObjectList = (SavedQueryList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       queryId
    </th>
    <th>
       name
    </th>
    <th>
       queryString
    </th>
    <th>
       queryType
    </th>
    <th>
       sortWeight
    </th>
    <th>
       selected
    </th>
    <th>
       view
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% SavedQuery theObject = (SavedQuery) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getQueryId() %>
    </td>
    <td>
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getQueryString() %>
    </td>
    <td>
       <%= theObject.getQueryType() %>
    </td>
    <td>
       <%= theObject.getSortWeight() %>
    </td>
    <td>
       <%= theObject.getSelected() %>
    </td>
    <td>
       <%= theObject.getView() %>
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
