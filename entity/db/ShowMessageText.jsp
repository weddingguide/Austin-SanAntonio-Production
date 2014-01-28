<%@ include file="Header.jsp" %>
<% MessageText theObject = (RECORDNNOE) requestData.getRequest().getSession().getValue( "theObject" ); %>
<ul>
  <li> msgId = <%= theObject.getMsgId() %>
  <li> label = <%= theObject.getLabel() %>
  <li> text = <%= theObject.getText() %>
</ul>
<%@ include file="Footer.jsp" %>
