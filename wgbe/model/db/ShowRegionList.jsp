<% RegionList theObjectList = (RegionList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       name
    </th>
    <th>
       group
    </th>
    <th>
       featuredVendorGroupId
    </th>
    <th>
       businessId
    </th>
    <th>
       texasWeddingsBusinessId
    </th>
    <th>
       texasWeddingsGroup
    </th>
    <th>
       mobileDomain
    </th>
    <th>
       faceBook
    </th>
    <th>
       twitter
    </th>
    <th>
       mySpace
    </th>
    <th>
       pinterest
    </th>
    <th>
       phone
    </th>
    <th>
       email
    </th>
    <th>
       virtualBookLink
    </th>
    <th>
       siteSpecificAttributeSubId
    </th>
    <th>
       blog
    </th>
    <th>
       bridalExtravaganza
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% Region theObject = (Region) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getName() %>
    </td>
    <td>
       <%= theObject.getGroup() %>
    </td>
    <td>
       <%= theObject.getFeaturedVendorGroupId() %>
    </td>
    <td>
       <%= theObject.getBusinessId() %>
    </td>
    <td>
       <%= theObject.getTexasWeddingsBusinessId() %>
    </td>
    <td>
       <%= theObject.getTexasWeddingsGroup() %>
    </td>
    <td>
       <%= theObject.getMobileDomain() %>
    </td>
    <td>
       <%= theObject.getFaceBook() %>
    </td>
    <td>
       <%= theObject.getTwitter() %>
    </td>
    <td>
       <%= theObject.getMySpace() %>
    </td>
    <td>
       <%= theObject.getPinterest() %>
    </td>
    <td>
       <%= theObject.getPhone() %>
    </td>
    <td>
       <%= theObject.getEmail() %>
    </td>
    <td>
       <%= theObject.getVirtualBookLink() %>
    </td>
    <td>
       <%= theObject.getSiteSpecificAttributeSubId() %>
    </td>
    <td>
       <%= theObject.getBlog() %>
    </td>
    <td>
       <%= theObject.getBridalExtravaganza() %>
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
