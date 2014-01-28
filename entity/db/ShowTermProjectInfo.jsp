<%@ include file="Header.jsp" %>
<% TermProjectInfo theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> ownerType = <%= theObject.getOwnerType() %>
  <li> ownerId = <%= theObject.getOwnerId() %>
  <li> title = <%= theObject.getTitle() %>
  <li> overview = <%= theObject.getOverview() %>
  <li> scenario = <%= theObject.getScenario() %>
  <li> profRole = <%= theObject.getProfRole() %>
  <li> teamRole = <%= theObject.getTeamRole() %>
  <li> actionRequest = <%= theObject.getActionRequest() %>
  <li> reportURL = <%= theObject.getReportURL() %>
  <li> feedback = <%= theObject.getFeedback() %>
  <li> evaluation = <%= theObject.getEvaluation() %>
  <li> presentationSection = <%= theObject.getPresentationSection() %>
  <li> reportDoc = <%= theObject.getReportDoc() %>
  <li> grade = <%= theObject.getGrade() %>
  <li> createDate = <%= theObject.getCreateDate() %>
</ul>
<%@ include file="Footer.jsp" %>
