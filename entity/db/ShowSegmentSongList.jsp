<% SegmentSongList theObjectList = (SegmentSongList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       ownerType
    </th>
    <th>
       ownerId
    </th>
    <th>
       segment
    </th>
    <th>
       songLength
    </th>
    <th>
       song
    </th>
    <th>
       artist
    </th>
    <th>
       details
    </th>
    <th>
       location
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% SegmentSong theObject = (SegmentSong) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getOwnerType() %>
    </td>
    <td>
       <%= theObject.getOwnerId() %>
    </td>
    <td>
       <%= theObject.getSegment() %>
    </td>
    <td>
       <%= theObject.getSongLength() %>
    </td>
    <td>
       <%= theObject.getSong() %>
    </td>
    <td>
       <%= theObject.getArtist() %>
    </td>
    <td>
       <%= theObject.getDetails() %>
    </td>
    <td>
       <%= theObject.getLocation() %>
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
