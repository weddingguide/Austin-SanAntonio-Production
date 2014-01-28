<% TermProjectInfoList theObjectList = (TermProjectInfoList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       title
    </th>
    <th>
       overview
    </th>
    <th>
       scenario
    </th>
    <th>
       profRole
    </th>
    <th>
       teamRole
    </th>
    <th>
       actionRequest
    </th>
    <th>
       reportURL
    </th>
    <th>
       feedback
    </th>
    <th>
       evaluation
    </th>
    <th>
       presentationSection
    </th>
    <th>
       reportDoc
    </th>
    <th>
       grade
    </th>
    <th>
       createDate
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% TermProjectInfo theObject = (TermProjectInfo) theObjectList.getRecordList()[i]; %> 
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
       <%= theObject.getTitle() %>
    </td>
    <td>
       <%= theObject.getOverview() %>
    </td>
    <td>
       <%= theObject.getScenario() %>
    </td>
    <td>
       <%= theObject.getProfRole() %>
    </td>
    <td>
       <%= theObject.getTeamRole() %>
    </td>
    <td>
       <%= theObject.getActionRequest() %>
    </td>
    <td>
       <%= theObject.getReportURL() %>
    </td>
    <td>
       <%= theObject.getFeedback() %>
    </td>
    <td>
       <%= theObject.getEvaluation() %>
    </td>
    <td>
       <%= theObject.getPresentationSection() %>
    </td>
    <td>
       <%= theObject.getReportDoc() %>
    </td>
    <td>
       <%= theObject.getGrade() %>
    </td>
    <td>
       <%= theObject.getCreateDate() %>
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
