package cn.answering.repository.es;

import cn.answering.domain.Tag;
import cn.answering.domain.User;
import cn.answering.domain.es.EsArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsArticleRepository extends ElasticsearchRepository<EsArticle,String> {

    Page<EsArticle> findDistinctByTitleContainingOrContentContainingOrAuthorContainingOrTagsContaining(String title, String content, User Author, List<Tag> Tags, Pageable pageable);

    Page<EsArticle> findDistinctByTitleContainingOrContentContaining(String title,String content, Pageable pageable);

    void deleteEsArticleByArticleId(String id);


}
