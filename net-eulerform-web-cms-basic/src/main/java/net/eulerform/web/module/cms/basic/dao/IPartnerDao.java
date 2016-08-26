package net.eulerform.web.module.cms.basic.dao;

import java.util.List;

import net.eulerform.web.core.base.dao.IBaseDao;
import net.eulerform.web.core.base.entity.PageResponse;
import net.eulerform.web.core.base.entity.QueryRequest;
import net.eulerform.web.module.cms.basic.entity.Partner;

public interface IPartnerDao extends IBaseDao<Partner> {

    public int findMaxOrder();

    public PageResponse<Partner> findPartnerByPage(QueryRequest queryRequest, int pageIndex, int pageSize);

    public List<Partner> loadPartners();

}