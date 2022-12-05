package com.sicnu.boot.mapper;

import com.sicnu.boot.vo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:23
 */
@Mapper
public interface UserFriendMapper {
    /**
     * description: 通过用户id获取用户列表
     *
     * @param userId:
     * @return List<UserDetail>
     * @author 胡建华
     * Date:  2022/12/3 16:27
     */
    List<UserDetail> getFriendsByUserId(Integer userId);
}
