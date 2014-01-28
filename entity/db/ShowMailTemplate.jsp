<%@ include file="Header.jsp" %>
<% MailTemplate theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> id = <%= theObject.getId() %>
  <li> name = <%= theObject.getName() %>
  <li> description = <%= theObject.getDescription() %>
  <li> body = <%= theObject.getBody() %>
  <li> subject = <%= theObject.getSubject() %>
  <li> qualifier = <%= theObject.getQualifier() %>
  <li> toStatus = <%= theObject.getToStatus() %>
  <li> toFollowup = <%= theObject.getToFollowup() %>
  <li> statusBatch = <%= theObject.getStatusBatch() %>
  <li> groupBatch = <%= theObject.getGroupBatch() %>
  <li> individual = <%= theObject.getIndividual() %>
  <li> preventDuplicates = <%= theObject.getPreventDuplicates() %>
  <li> onlyToResponseDue = <%= theObject.getOnlyToResponseDue() %>
</ul>
<%@ include file="Footer.jsp" %>
