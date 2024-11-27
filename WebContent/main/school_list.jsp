<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.School" %>
<html>
<head>
    <title>学校一覧</title>
    <link rel="stylesheet" href="user.css">
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

                        <!-- 学校情報を表示するボタンを含むフォーム -->
                        <div class="button-container">
                            <!-- マップボタンにクラス名を追加 -->
                            <form action="Map.action" method="get" style="display: inline;">
                                <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                                <button type="submit" class="map-button">マップ</button>
                            </form>

                            <!-- 口コミ閲覧ボタンにクラス名を追加 -->
                            <form action="Kuchikomi.action" method="get" style="display: inline;">
                                <input type="hidden" name="schoolCd" value="<%= school.getSchoolCd() %>">
                                <button type="submit" class="review-button">口コミ閲覧</button>
                            </form>
                        </div>
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

