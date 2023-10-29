package com.example.project6.modle;

public class EmailRequest {
    private String to;
    private String subject;
    private String message;

    public EmailRequest() {
    }

    @Override
    public String toString() {
        return "EmailRequest{" + "from='" + to + '\'' + ", subject='" + subject + '\'' + ", message='" + message + '\'' + '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String to) {
        this.to = to;
    }
}
