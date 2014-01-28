<% NNWedCoupleListList theObjectList = (NNWedCoupleListList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       status
    </th>
    <th>
       coupleId
    </th>
    <th>
       hisEmilAddress
    </th>
    <th>
       hisName
    </th>
    <th>
       herEmailAddress
    </th>
    <th>
       herName
    </th>
    <th>
       hisLastName
    </th>
    <th>
       hisFirstName
    </th>
    <th>
       herLastName
    </th>
    <th>
       herFirstName
    </th>
    <th>
       dateAdded
    </th>
    <th>
       dateRemoved
    </th>
    <th>
       weddingDate
    </th>
    <th>
       hisAddressLine1
    </th>
    <th>
       hisAddressLine2
    </th>
    <th>
       hisAddressLine3
    </th>
    <th>
       herAddressLine1
    </th>
    <th>
       herAddressLine2
    </th>
    <th>
       herAddressLine3
    </th>
    <th>
       hisPhone
    </th>
    <th>
       herPhone
    </th>
    <th>
       notes
    </th>
    <th>
       hisWorkPhone
    </th>
    <th>
       herWorkPhone
    </th>
    <th>
       hisBirthDate
    </th>
    <th>
       herBirthDate
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% NNWedCoupleList theObject = (NNWedCoupleList) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getCoupleId() %>
    </td>
    <td>
       <%= theObject.getHisEmilAddress() %>
    </td>
    <td>
       <%= theObject.getHisName() %>
    </td>
    <td>
       <%= theObject.getHerEmailAddress() %>
    </td>
    <td>
       <%= theObject.getHerName() %>
    </td>
    <td>
       <%= theObject.getHisLastName() %>
    </td>
    <td>
       <%= theObject.getHisFirstName() %>
    </td>
    <td>
       <%= theObject.getHerLastName() %>
    </td>
    <td>
       <%= theObject.getHerFirstName() %>
    </td>
    <td>
       <%= theObject.getDateAdded() %>
    </td>
    <td>
       <%= theObject.getDateRemoved() %>
    </td>
    <td>
       <%= theObject.getWeddingDate() %>
    </td>
    <td>
       <%= theObject.getHisAddressLine1() %>
    </td>
    <td>
       <%= theObject.getHisAddressLine2() %>
    </td>
    <td>
       <%= theObject.getHisAddressLine3() %>
    </td>
    <td>
       <%= theObject.getHerAddressLine1() %>
    </td>
    <td>
       <%= theObject.getHerAddressLine2() %>
    </td>
    <td>
       <%= theObject.getHerAddressLine3() %>
    </td>
    <td>
       <%= theObject.getHisPhone() %>
    </td>
    <td>
       <%= theObject.getHerPhone() %>
    </td>
    <td>
       <%= theObject.getNotes() %>
    </td>
    <td>
       <%= theObject.getHisWorkPhone() %>
    </td>
    <td>
       <%= theObject.getHerWorkPhone() %>
    </td>
    <td>
       <%= theObject.getHisBirthDate() %>
    </td>
    <td>
       <%= theObject.getHerBirthDate() %>
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
