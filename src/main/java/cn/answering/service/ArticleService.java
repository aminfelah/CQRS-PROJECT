package cn.answering.service;

import cn.answering.domain.Article;


public interface ArticleService {

    
    public Article saveOrUpdateArticle(Article article);

    
    public void deleteArticle(String id);

   
    public Article findArticleById(String id);
}
