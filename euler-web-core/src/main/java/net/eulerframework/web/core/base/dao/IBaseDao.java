package net.eulerframework.web.core.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import net.eulerframework.web.core.base.entity.BaseEntity;
import net.eulerframework.web.core.base.request.PageQueryRequest;
import net.eulerframework.web.core.base.response.easyuisupport.EasyUIPageResponse;

public interface IBaseDao<T extends BaseEntity<?>>{

    T load(Serializable id);

    List<T> load(Collection<Serializable> ids);

    List<T> load(Serializable[] idArray);
    
    Serializable save(T entity);
    
    void update(T entity);
    
    void saveOrUpdate(T entity);
    
    void saveOrUpdateBatch(Collection<T> entities);

    void delete(T entity);
    
    void deleteById(Serializable id);

    void deleteBatch(Collection<T> entities);

    void deleteByIds(Collection<Serializable> ids);

    void deleteByIds(Serializable[] idArray);
    
    List<T> queryByEntity(T entity);
    
    List<T> queryAll();
    
    long countAll();
    
    EasyUIPageResponse<T> pageQuery(PageQueryRequest pageQueryRequest);
    
    public EasyUIPageResponse<T> pageQuery(PageQueryRequest pageQueryRequest, String... propertySetToSelectMode);

    void flushSession();

    public boolean isMyEntity(Class<? extends T> clazz);
}
