package net.eulerframework.web.module.oauth2.service;


import java.util.List;

import net.eulerframework.web.module.oauth2.entity.Scope;
import org.springframework.security.access.prepost.PreAuthorize;

import net.eulerframework.web.core.base.request.QueryRequest;
import net.eulerframework.web.core.base.response.PageResponse;
import net.eulerframework.web.core.base.service.IBaseService;
import net.eulerframework.web.module.oauth2.entity.Client;
import net.eulerframework.web.module.oauth2.entity.Resource;

public interface IClientService extends IBaseService {

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    PageResponse<Client> findClientByPage(QueryRequest queryRequest, int pageIndex, int pageSize);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    PageResponse<Resource> findResourceByPage(QueryRequest queryRequest, int pageIndex, int pageSize);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    PageResponse<Scope> findScopeByPage(QueryRequest queryRequest, int pageIndex, int pageSize);

    /**
     * 保存或更新Client,如果关联表对应属性为空不删除关联关系
     * @param client
     */
    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void saveClient(Client client);

    /**
     * 保存或更新Client以及关联信息
     * @param client
     */
    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void saveClient(Client client, String[] grantType, String scopesIds, String resourceIds, String redirectUris);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void saveResource(Resource resource);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void saveScope(Scope scope);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void enableClientsRWT(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void disableClientsRWT(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void deleteResources(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    void deleteScopes(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    List<Scope> findScopesByIdArray(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    List<Resource> findResourceByIdArray(String[] idArray);

    @PreAuthorize("isFullyAuthenticated() and hasAnyAuthority('ADMIN','ROOT')")
    Client findClientByClientId(String clientId);    
}
