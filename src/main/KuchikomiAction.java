package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kuchikomi;
import dao.KuchikomiDao;
import tool.Action;

public class KuchikomiAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // schoolCd パラメータを取得
            String schoolCdStr = request.getParameter("schoolCd");

            // schoolCd が空でないことを確認し、整数に変換
            if (schoolCdStr != null && !schoolCdStr.isEmpty()) {
                int schoolCd = Integer.parseInt(schoolCdStr);

                // KuchikomiDao を使って口コミリストを取得
                KuchikomiDao kuchikomiDao = new KuchikomiDao();
                List<Kuchikomi> kuchikomiList = kuchikomiDao.getKuchikomiBySchoolCd(schoolCd);

                // 口コミリストをリクエストにセット
                request.setAttribute("kuchikomiList", kuchikomiList);

                // 口コミ一覧ページにフォワード
                request.getRequestDispatcher("kuchikomi_list.jsp").forward(request, response);
            } else {
                // schoolCd が不正な場合はエラーメッセージを設定
                request.setAttribute("error", "学校コードが無効です");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // エラー処理
            e.printStackTrace();
            request.setAttribute("error", "エラーが発生しました。もう一度試してください。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

