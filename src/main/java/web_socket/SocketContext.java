package web_socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocketContext {
    public String getURI() {
        return URI;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public Integer getStatusCode() {
        return StatusCode;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public String getBody() {
        return body;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    private String URI;
    private String expectedMessage;

    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setExpectedMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public void setStatusCode(Integer statusCode) {
        StatusCode = statusCode;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    private Map<String, String> requestHeaders = new HashMap<>();
    private List<String> messageList = new ArrayList<>();
    private Integer StatusCode;
    private Integer timeOut = 10;
    private Integer timeTaken;
    private String body;
    private Runnable runnable;
}
