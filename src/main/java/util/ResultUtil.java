package util;

import jielin.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result fail(int code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result success(){
        return success(null);
    }
}
