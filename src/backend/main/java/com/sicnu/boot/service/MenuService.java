package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:17
 */
public interface MenuService {
    /**
     * description: 获取所有的权限树
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 9:21
     */
    ServerResponse<List<Menu>> getMenuTree();
}
