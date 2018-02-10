package jielin.girl.exception;

import jielin.girl.enums.ResultEnum;

/**
 * spring只对RuntimeException进行事务回滚
 * 如果是Exception则不进行事务回滚
 */
public class GirlException extends RuntimeException{
    private int code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
