<% WGBEWeddingProfList theObjectList = (WGBEWeddingProfList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       groupId
    </th>
    <th>
       weddingProfId
    </th>
    <th>
       summaryText
    </th>
    <th>
       description
    </th>
    <th>
       image1
    </th>
    <th>
       image2
    </th>
    <th>
       image3
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% WGBEWeddingProf theObject = (WGBEWeddingProf) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getGroupId() %>
    </td>
    <td>
       <%= theObject.getWeddingProfId() %>
    </td>
    <td>
       <%= theObject.getSummaryText() %>
    </td>
    <td>
       <%= theObject.getDescription() %>
    </td>
    <td>
       <%= theObject.getImage1() %>
    </td>
    <td>
       <%= theObject.getImage2() %>
    </td>
    <td>
       <%= theObject.getImage3() %>
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
