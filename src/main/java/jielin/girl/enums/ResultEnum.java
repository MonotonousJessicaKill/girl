package jielin.girl.enums;

public enum  ResultEnum {

    UnKNOW_ERROR(-1,"未知错误"),
    PRIMARY_ERROR(100,"上小学"),
    SECOND_ERROR(101,"上初中"),
    SUCCESS(0,"success");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}
