<% GroupTypeList theObjectList = (GroupTypeList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       groupType
    </th>
    <th>
       grouptTypeName
    </th>
    <th>
       implicitGroupType
    </th>
    <th>
       acceptPersonMembers
    </th>
    <th>
       acceptBusinessMembers
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% GroupType theObject = (GroupType) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getGroupType() %>
    </td>
    <td>
       <%= theObject.getGrouptTypeName() %>
    </td>
    <td>
       <%= theObject.getImplicitGroupType() %>
    </td>
    <td>
       <%= theObject.getAcceptPersonMembers() %>
    </td>
    <td>
       <%= theObject.getAcceptBusinessMembers() %>
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
