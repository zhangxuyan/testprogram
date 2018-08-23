package com.cuiyongzhi.wechat.message.resp;

import java.util.List;

/**
 * ClassName: NewsMessage
 * @Description: ��ͼ����Ϣ
 * @author dapengniao
 * @date 2016 �� 3 �� 7 �� ���� 3:52:18
 */
public class NewsMessage extends BaseMessage {  
    // ͼ����Ϣ����������Ϊ 10 ������   
    private int ArticleCount;  
    // ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ�� item Ϊ��ͼ   
    private List<Article> Articles;  

    public int getArticleCount() {  
        return ArticleCount;  
    }  

    public void setArticleCount(int articleCount) {  
        ArticleCount = articleCount;  
    }  

    public List<Article> getArticles() {  
        return Articles;  
    }  

    public void setArticles(List<Article> articles) {  
        Articles = articles;  
    }  
}