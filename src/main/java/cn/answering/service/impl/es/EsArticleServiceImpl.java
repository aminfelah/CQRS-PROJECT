package cn.answering.service.impl.es;

import cn.answering.domain.Tag;
import cn.answering.domain.User;
import cn.answering.domain.es.EsArticle;
import cn.answering.repository.es.EsArticleRepository;
import cn.answering.service.es.EsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EsArticleServiceImpl implements EsArticleService{

    @Autowired
    private EsArticleRepository esArticleRepository;

    @Override
    public EsArticle saveOrUpdate(EsArticle esArticle) {
        return esArticleRepository.save(esArticle);
    }

    @Override
    public void delete(String id) {
        esArticleRepository.delete(id);
    }
    
    @Override
    public void deleteall() {
        esArticleRepository.deleteAll();;
    }

    @Override
    public Page<EsArticle> queryArticle(String content, Pageable pageable) {
        return esArticleRepository.findDistinctByTitleContainingOrContentContaining(content,content,pageable);
    }

    @Override
    public Page<EsArticle> queryArticle(String title, String content, User author, List<Tag> tags, Pageable pageable) {
        return esArticleRepository.findDistinctByTitleContainingOrContentContainingOrAuthorContainingOrTagsContaining(title,content,author,tags,pageable);
    }

    @Override
    public void deleteByArticleId(String id) {
        esArticleRepository.deleteEsArticleByArticleId(id);
    }

    @Override
    public Page<EsArticle> findAll(Pageable pageable) {
        return (Page<EsArticle>) esArticleRepository.findAll();
    }
}
