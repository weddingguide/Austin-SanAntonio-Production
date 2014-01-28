<% CoupleGroupInfoList theObjectList = (CoupleGroupInfoList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       ownerType
    </th>
    <th>
       ownerId
    </th>
    <th>
       status
    </th>
    <th>
       musicReceived
    </th>
    <th>
       musicInfoDetails
    </th>
    <th>
       invitationReceived
    </th>
    <th>
       invitationInfoDetails
    </th>
    <th>
       programReceived
    </th>
    <th>
       programInfoDetails
    </th>
    <th>
       priceListVersion
    </th>
    <th>
       hoursOnSite
    </th>
    <th>
       loveStory
    </th>
    <th>
       photoMontage
    </th>
    <th>
       completeCeremony
    </th>
    <th>
       numberOfDVDs
    </th>
    <th>
       negotiatedItems
    </th>
    <th>
       webPublication
    </th>
    <th>
       catalog
    </th>
    <th>
       createDate
    </th>
    <th>
       registryCatalog
    </th>
    <th>
       project
    </th>
    <th>
       titleText
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% CoupleGroupInfo theObject = (CoupleGroupInfo) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getStatus() %>
    </td>
    <td>
       <%= theObject.getMusicReceived() %>
    </td>
    <td>
       <%= theObject.getMusicInfoDetails() %>
    </td>
    <td>
       <%= theObject.getInvitationReceived() %>
    </td>
    <td>
       <%= theObject.getInvitationInfoDetails() %>
    </td>
    <td>
       <%= theObject.getProgramReceived() %>
    </td>
    <td>
       <%= theObject.getProgramInfoDetails() %>
    </td>
    <td>
       <%= theObject.getPriceListVersion() %>
    </td>
    <td>
       <%= theObject.getHoursOnSite() %>
    </td>
    <td>
       <%= theObject.getLoveStory() %>
    </td>
    <td>
       <%= theObject.getPhotoMontage() %>
    </td>
    <td>
       <%= theObject.getCompleteCeremony() %>
    </td>
    <td>
       <%= theObject.getNumberOfDVDs() %>
    </td>
    <td>
       <%= theObject.getNegotiatedItems() %>
    </td>
    <td>
       <%= theObject.getWebPublication() %>
    </td>
    <td>
       <%= theObject.getCatalog() %>
    </td>
    <td>
       <%= theObject.getCreateDate() %>
    </td>
    <td>
       <%= theObject.getRegistryCatalog() %>
    </td>
    <td>
       <%= theObject.getProject() %>
    </td>
    <td>
       <%= theObject.getTitleText() %>
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
