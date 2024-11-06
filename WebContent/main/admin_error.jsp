<%@ page pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<p>エラーが発生しました</p>
<button onclick="goBack()">戻る</button>

<script>
    function goBack() {
        window.history.back();
    }
</script>

<%@ include file="footer.jsp" %>
