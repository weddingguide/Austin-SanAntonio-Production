<% BGContractList theObjectList = (BGContractList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       ownerId
    </th>
    <th>
       contractDate
    </th>
    <th>
       contractTerm
    </th>
    <th>
       regionGroupId
    </th>
    <th>
       initialWGEdition
    </th>
    <th>
       fullMktPkg
    </th>
    <th>
       adProd
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% BGContract theObject = (BGContract) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getContractDate() %>
    </td>
    <td>
       <%= theObject.getContractTerm() %>
    </td>
    <td>
       <%= theObject.getRegionGroupId() %>
    </td>
    <td>
       <%= theObject.getInitialWGEdition() %>
    </td>
    <td>
       <%= theObject.getFullMktPkg() %>
    </td>
    <td>
       <%= theObject.getAdProd() %>
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
