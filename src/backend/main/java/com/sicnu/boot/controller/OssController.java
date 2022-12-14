package com.sicnu.boot.controller;

import com.sicnu.boot.service.OssService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.StsTokenVo;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.Pattern;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/19 14:44
 */
@RestController
@Validated
@RequestMapping("/oss")
public class OssController {

    @Resource
    private OssService ossService;

    /**
     * description: 用户上传头像的代理
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 21:48
     */
    @CrossOrigin
    @GetMapping("/policy/user/{fileName}")
    public ServerResponse<Map<String, String>> getUserPolicy(
            @Pattern(regexp = "^(\\s|\\S)+(jpg|png|JPG|PNG)+$",
                    message = "图片格式必须为jpg或者png类型") @PathVariable String fileName){
        return ossService.getUserPolicy(fileName);
    }

    /**
     * description: 题库上传的代理
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 21:48
     */
    @CrossOrigin
    @GetMapping("/policy/question/{fileName}-{dir}")
    public ServerResponse<Map<String, String>> getQuestionPolicy(
            @Pattern(regexp = "^(\\s|\\S)+(jpg|png|JPG|PNG)+$",
                    message = "图片格式必须为jpg或者png类型") @PathVariable String fileName,
            @Length(min = 5,max = 9,message = "dir的范围必须为5-9") @PathVariable String dir){
        return ossService.getQuestionPolicy(fileName,dir);
    }

    /**
     * description: 视频图片上传的代理
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 21:48
     */
    @CrossOrigin
    @GetMapping("/policy/video/{fileName}")
    public ServerResponse<Map<String, String>> getVideoPolicy(
            @Pattern(regexp = "^(\\s|\\S)+(jpg|png|JPG|PNG)+$",
                    message = "图片格式必须为jpg或者png类型") @PathVariable String fileName){
        return ossService.getVideoPolicy(fileName);
    }

    /**
     * description: 动态图片上传的代理
     *
     * @param fileName:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/19 21:48
     */
    @CrossOrigin
    @GetMapping("/policy/dynamic/{fileName}")
    public ServerResponse<Map<String, String>> getDynamicPolicy(
            @Pattern(regexp = "^(\\s|\\S)+(jpg|png|JPG|PNG)+$",
                    message = "图片格式必须为jpg或者png类型") @PathVariable String fileName){
        return ossService.getDynamicPolicy(fileName);
    }

    @GetMapping("/sts")
    public ServerResponse<StsTokenVo> getStsToken(){
        return ossService.getStsToken();
    }
}
