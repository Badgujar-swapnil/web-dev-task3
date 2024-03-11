package model;

public class Response {
    private String respondentName;
    private String responseText;

    public Response(String respondentName, String responseText) {
        this.respondentName = respondentName;
        this.responseText = responseText;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}
