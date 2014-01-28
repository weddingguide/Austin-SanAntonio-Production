<% PersonList theObjectList = (PersonList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       personId
    </th>
    <th>
       ownerId
    </th>
    <th>
       ownerType
    </th>
    <th>
       lastName
    </th>
    <th>
       firstName
    </th>
    <th>
       middleName
    </th>
    <th>
       title
    </th>
    <th>
       nickName
    </th>
    <th>
       suffix
    </th>
    <th>
       preferredName
    </th>
    <th>
       sex
    </th>
    <th>
       age
    </th>
    <th>
       createDate
    </th>
    <th>
       lastUpdate
    </th>
    <th>
       status
    </th>
    <th>
       recordType
    </th>
    <th>
       comment
    </th>
    <th>
       url
    </th>
    <th>
       siteDefEntityType
    </th>
    <th>
       birthDate
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% Person theObject = (Person) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getPersonId() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getLastName() %>
    </td>
    <td>
       <%= theObject.getFirstName() %>
    </td>
    <td>
       <%= theObject.getMiddleName() %>
    </td>
    <td>
       <%= theObject.getTitle() %>
    </td>
    <td>
       <%= theObject.getNickName() %>
    </td>
    <td>
       <%= theObject.getSuffix() %>
    </td>
    <td>
       <%= theObject.getPreferredName() %>
    </td>
    <td>
       <%= theObject.getSex() %>
    </td>
    <td>
       <%= theObject.getAge() %>
    </td>
    <td>
       <%= theObject.getCreateDate() %>
    </td>
    <td>
       <%= theObject.getLastUpdate() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getRecordType() %>
    </td>
    <td>
       <%= theObject.getComment() %>
    </td>
    <td>
       <%= theObject.getUrl() %>
    </td>
    <td>
       <%= theObject.getSiteDefEntityType() %>
    </td>
    <td>
       <%= theObject.getBirthDate() %>
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
