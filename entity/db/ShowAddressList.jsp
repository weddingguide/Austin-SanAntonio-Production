<% AddressList theObjectList = (AddressList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       addressId
    </th>
    <th>
       ownerId
    </th>
    <th>
       ownerType
    </th>
    <th>
       addressType
    </th>
    <th>
       addressLine1
    </th>
    <th>
       addressLine2
    </th>
    <th>
       addressLine3
    </th>
    <th>
       city
    </th>
    <th>
       state
    </th>
    <th>
       country
    </th>
    <th>
       postalCode
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% Address theObject = (Address) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getAddressId() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getAddressType() %>
    </td>
    <td>
       <%= theObject.getAddressLine1() %>
    </td>
    <td>
       <%= theObject.getAddressLine2() %>
    </td>
    <td>
       <%= theObject.getAddressLine3() %>
    </td>
    <td>
       <%= theObject.getCity() %>
    </td>
    <td>
       <%= theObject.getState() %>
    </td>
    <td>
       <%= theObject.getCountry() %>
    </td>
    <td>
       <%= theObject.getPostalCode() %>
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
