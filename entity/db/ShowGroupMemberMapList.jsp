<% GroupMemberMapList theObjectList = (GroupMemberMapList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       groupNum
    </th>
    <th>
       memberType
    </th>
    <th>
       memberId
    </th>
    <th>
       memberRole
    </th>
    <th>
       memberRoleText
    </th>
    <th>
       associatedWithOwnerType
    </th>
    <th>
       associatedWithOwnerId
    </th>
    <th>
       primaryMember
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% GroupMemberMap theObject = (GroupMemberMap) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getGroupNum() %>
    </td>
    <td>
       <%= theObject.getMemberType() %>
    </td>
    <td>
       <%= theObject.getMemberId() %>
    </td>
    <td>
       <%= theObject.getMemberRole() %>
    </td>
    <td>
       <%= theObject.getMemberRoleText() %>
    </td>
    <td>
       <%= theObject.getAssociatedWithOwnerType() %>
    </td>
    <td>
       <%= theObject.getAssociatedWithOwnerId() %>
    </td>
    <td>
       <%= theObject.getPrimaryMember() %>
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
