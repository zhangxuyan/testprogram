package com.cuiyongzhi.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * ClassName: InterfaceUrlIntiServlet
 * @Description: ��Ŀ������ʼ�� servlet
 * @author dapengniao
 * @date 2016 �� 3 �� 10 �� ���� 4:08:43
 */
public class InterfaceUrlIntiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        InterfaceUrlInti.init();
    }

}