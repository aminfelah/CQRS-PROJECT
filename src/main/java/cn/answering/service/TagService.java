package cn.answering.service;

import cn.answering.domain.Tag;


public interface TagService{

    public Tag saveOrUpdateTag(Tag tag);

    public void deleteTag(String id);

    public Tag findTagById(String id);
}
