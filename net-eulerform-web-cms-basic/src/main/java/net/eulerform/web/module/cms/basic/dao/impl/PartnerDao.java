package net.eulerform.web.module.cms.basic.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import net.eulerform.common.StringTool;
import net.eulerform.web.core.base.dao.impl.hibernate5.BaseDao;
import net.eulerform.web.core.base.entity.PageResponse;
import net.eulerform.web.core.base.entity.QueryRequest;
import net.eulerform.web.core.extend.hibernate5.RestrictionsX;
import net.eulerform.web.module.cms.basic.dao.IPartnerDao;
import net.eulerform.web.module.cms.basic.entity.Partner;

public class PartnerDao extends BaseDao<Partner> implements IPartnerDao {

    @Override
    public int findMaxOrder() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);        
        detachedCriteria.addOrder(Order.desc("order"));
        List<Partner> result = this.findByWithMaxResults(detachedCriteria, 1);
        if(result == null || result.isEmpty())
            return 0;
        
        return result.get(0).getOrder();
    }

    @Override
    public PageResponse<Partner> findPartnerByPage(QueryRequest queryRequest, int pageIndex, int pageSize) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
        try {
            String queryValue = null;
            queryValue = queryRequest.getQueryValue("name");
            if (!StringTool.isNull(queryValue)) {
                detachedCriteria.add(RestrictionsX.like("name", queryValue, MatchMode.ANYWHERE).ignoreCase());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        detachedCriteria.addOrder(Order.asc("order"));
        
        PageResponse<Partner> result = this.findPageBy(detachedCriteria, pageIndex, pageSize);
        
        return result;
    }

    @Override
    public List<Partner> loadPartners() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);        
        detachedCriteria.addOrder(Order.asc("order"));
        return this.findBy(detachedCriteria);
    }

}
