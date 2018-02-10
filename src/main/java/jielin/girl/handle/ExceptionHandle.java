package jielin.girl.handle;

import jielin.girl.domain.Result;
import jielin.girl.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
    private Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){

        if (e instanceof GirlException)
        return ResultUtil.fail(((GirlException) e).getCode(),e.getMessage());
        else {
            logger.error("系统异常{}",e);
            return ResultUtil.fail(300,"未知错误");

        }
    }
}
