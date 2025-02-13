package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class KuchikomiPostAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 学校コードをリクエストから取得
        String schoolCd = request.getParameter("schoolCd");

        // 口コミ投稿ページに学校コードを渡す
        request.setAttribute("schoolCd", schoolCd);
        request.getRequestDispatcher("/main/kuchikomi_post.jsp").forward(request, response);
    }
}




