package bid.adonis.lau.controller;

import bid.adonis.lau.constant.CityErrorInfoEnum;
import bid.adonis.lau.entity.City;
import bid.adonis.lau.result.GlobalErrorInfoException;
import bid.adonis.lau.result.ResultBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误码案例
 *
 * @Author Adonis Lau
 * @Eamil adonis.lau.dev@gmail.com
 * @Date Created in 2017/9/4 16:33
 */
@RestController
@RequestMapping("/api")
public class ErrorJsonController {

    /**
     * 获取城市接口
     *
     * @param cityName
     * @return
     * @throws GlobalErrorInfoException
     */
    @GetMapping("/city")
    public ResultBody findOneCity(@RequestParam("cityName") String cityName) throws GlobalErrorInfoException {
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        return new ResultBody(new City(1L, 2L, "温岭", "是我的故乡"));
    }
}