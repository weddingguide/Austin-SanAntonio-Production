<% PageDataList theObjectList = (PageDataList) requestData.getRequest().getSession().getValue( "theObjectList" ); %>
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
       pageDescription
    </th>
    <th>
       keywords
    </th>
    <th>
       googleVerify
    </th>
    <th>
       bingVerify
    </th>
    <th>
       homePageFeaturedSliderInt
    </th>
    <th>
       urlPrefix
    </th>
    <th>
       googleAnalytics
    </th>
    <th>
       cssName
    </th>
    <th>
    </th>
  </tr>
 <% for ( int i=0; i < theObjectList.getRecordList().length; i++ ) { %> 
 <% PageData theObject = (PageData) theObjectList.getRecordList()[i]; %> 
  <tr>
    <td>
          <input class=ButtonText type=submit name=action id=action value="Modify"
          <%=" onClick='selectId( this.form, "
                        +  "\"" + theObject.getId()
                        + "\");return(true);'" %>>
    </td>
    <td>
       <%= theObject.getPageDescription() %>
    </td>
    <td>
       <%= theObject.getKeywords() %>
    </td>
    <td>
       <%= theObject.getGoogleVerify() %>
    </td>
    <td>
       <%= theObject.getBingVerify() %>
    </td>
    <td>
       <%= theObject.getHomePageFeaturedSliderInt() %>
    </td>
    <td>
       <%= theObject.getUrlPrefix() %>
    </td>
    <td>
       <%= theObject.getGoogleAnalytics() %>
    </td>
    <td>
       <%= theObject.getCssName() %>
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
