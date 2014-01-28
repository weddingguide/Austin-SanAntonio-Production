<% EntityGroupList theObjectList = (EntityGroupList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       aliasOf
    </th>
    <th>
       type
    </th>
    <th>
       name
    </th>
    <th>
       extName
    </th>
    <th>
       description
    </th>
    <th>
       status
    </th>
    <th>
       category
    </th>
    <th>
       notifyGroup
    </th>
    <th>
       createDate
    </th>
    <th>
       lastUpdate
    </th>
    <th>
       notifyChange
    </th>
    <th>
       followUpStatusCache
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% EntityGroup theObject = (EntityGroup) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getAliasOf() %>
    </td>
    <td>
       <%= theObject.getType() %>
    </td>
    <td>
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getExtName() %>
    </td>
    <td>
       <%= theObject.getDescription() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getCategory() %>
    </td>
    <td>
       <%= theObject.getNotifyGroup() %>
    </td>
    <td>
       <%= theObject.getCreateDate() %>
    </td>
    <td>
       <%= theObject.getLastUpdate() %>
    </td>
    <td>
       <%= theObject.getNotifyChange() %>
    </td>
    <td>
       <%= theObject.getFollowUpStatusCache() %>
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
