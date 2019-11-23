package mesage.body;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.org.apache.xpath.internal.operations.Or;

public class CommandRequestBody extends Body {
    private static class Origin {
        private String type;

        public Origin(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @JSONField(ordinal = 1)
    private Origin origin;
    @JSONField(ordinal = 2)
    private String commandLine;
    @JSONField(ordinal = 3)
    private int version;


    public CommandRequestBody(String origin, String commandLine, int version) {
        this.origin = new Origin(origin);
        this.commandLine = commandLine;
        this.version = version;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = new Origin(origin);
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static class Builder {
        private CommandRequestBody requestBody;

        {
            requestBody = new CommandRequestBody("player", "/say init command", 1);
        }

        public Builder command(String command) {
            requestBody.setCommandLine(command);
            return this;
        }

        public Builder version(int version) {
            requestBody.setVersion(version);
            return this;
        }

        public Builder origin(String origin) {
            requestBody.setOrigin(origin);
            return this;
        }

        public CommandRequestBody build() {
            return requestBody;
        }

    }

}
