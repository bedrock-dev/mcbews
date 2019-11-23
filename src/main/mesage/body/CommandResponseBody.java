package mesage.body;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 命令执行反馈信息的body字段
 * @author AgNO3
 */
public class CommandResponseBody extends Body{
    private int statusCode;
    private Object extra;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public CommandResponseBody(int statusCode,Object extra) {
        this.statusCode = statusCode;
        this.extra = extra;
    }
}
