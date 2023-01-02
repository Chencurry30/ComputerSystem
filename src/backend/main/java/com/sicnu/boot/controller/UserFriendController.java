package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.FriendExamine;
import com.sicnu.boot.service.UserFriendService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/12/03 16:21
 */
@RestController
@RequestMapping("/friends")
@Validated
public class UserFriendController {
    @Resource
    private UserFriendService userFriendService;

    /**
     * description: 获取用户的好友列表
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/3 16:31
     */
    @GetMapping
    public ServerResponse<List<UserDetail>> getFriends(){
        return userFriendService.getFriends();
    }

    /**
     * description: 获取小红点
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/8 10:52
     */
    @GetMapping("/redSpot")
    public ServerResponse<Boolean> getRedSpot(){
        return userFriendService.getRedSpot();
    }

    /**
     * description: 搜索好友
     *
     * @param nickname:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 15:15
     */
    @GetMapping("/search")
    public ServerResponse<List<UserDetail>> getUserListByNickname(@Length(max = 10,message = "搜索长度范围为0-10")
            @RequestParam("nickname") String nickname){
        return userFriendService.getUserListByNickname(nickname);
    }

    /**
     * description: 添加好友
     *
     * @param friendExamine:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 16:05
     */
    @PostMapping
    public ServerResponse<String> addFriend(@Validated(Insert.class) @RequestBody FriendExamine friendExamine){
        return userFriendService.addFriend(friendExamine);
    }

    /**
     * description: 审核好友
     *
     * @param friendExamine:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 16:56
     */
    @PutMapping
    public ServerResponse<String> examineFriend(@Validated(Update.class) @RequestBody FriendExamine friendExamine){
        return userFriendService.examineFriend(friendExamine);
    }

    /**
     * description: 查看好友申请列表
     *
     * @param type:0为查看该用户的申请列表，1为查看申请该用户的列表
     * @param status:申请状态，-1为全部，0为等待验证，1为通过验证，2为拒绝
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/12/6 20:09
     */
    @GetMapping("/examine/{status}-{type}-{pageNum}")
    public ServerResponse<PageInfo<FriendExamine>> getExamineList(
            @Range(min = -1,max = 2,message = "status必须为-1到2") @PathVariable Integer status,
            @Range(min = 0,max = 1,message = "type必须为1或2") @PathVariable Integer type,
            @Min(value = 1,message = "pageNum最小为1") @PathVariable Integer pageNum){
        return userFriendService.getExamineList(status,type,pageNum);
    }

    /**
     * description: 删除指定好友申请
     *
     * @param friendId:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2023/1/2 20:56
     */
    @DeleteMapping("/{friendId}")
    public ServerResponse<String> cancelExamine(@Min(value = 1,message = "friendId最小为1") @PathVariable Integer friendId){
        return userFriendService.cancelExamine(friendId);
    }

    /**
     * description: 删除指定好友
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2023/1/2 20:59
     */
    @DeleteMapping("/delete/{friendId}")
    public ServerResponse<String> deleteFriend(@Min(value = 1,message = "friendId最小为1") @PathVariable Integer friendId){
        return userFriendService.deleteFriend(friendId);
    }
}
