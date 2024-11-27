package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KuchikomiPostDao;
import tool.Action;

public class KuchikomiPostExeAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // リクエストの文字エンコーディングをUTF-8に設定
        request.setCharacterEncoding("UTF-8");

        // 入力された学校コードと口コミ内容を取得
        int schoolCd = Integer.parseInt(request.getParameter("schoolCd"));
        String kuchikomiContent = request.getParameter("kuchikomiContent");

        // Daoを利用して口コミを投稿
        KuchikomiPostDao dao = new KuchikomiPostDao();
        boolean success = dao.insertKuchikomi(schoolCd, kuchikomiContent);

        // 成功した場合、口コミ一覧画面にリダイレクト
        if (success) {
            response.sendRedirect("Kuchikomi.action?schoolCd=" + schoolCd);  // 学校コードを付加して口コミ一覧画面にリダイレクト
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}

