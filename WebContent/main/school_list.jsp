<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.School" %>
<html>
<head>
    <title>学校一覧</title>
</head>
<body>
    <h2>学校一覧</h2>
    <ul>
        <%
            // "schools" 属性から学校リストを取得
            List<School> schools = (List<School>) request.getAttribute("schools");
            if (schools != null && !schools.isEmpty()) {
                for (School school : schools) {
        %>
                    <li>
                        <span><%= school.getSchoolName() %></span>
                        <!-- 口コミボタンのフォーム -->
                        <form action="Kuchikomi.action" method="get" style="display: inline;">
                            <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                            <button type="submit">口コミ</button>
                        </form>
                    </li>
        <%
                }
            } else {
        %>
            <li>学校情報が見つかりません。</li>
        <%
            }
        %>
    </ul>
</body>
</html>
