package me.khosraw;

public class Credentials {
    String email;
    String password;
    String to;
    String subject;
    String content;

    Credentials (String email, String password, String to, String subject, String content) {
        this.email = email;
        this.password = password;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPass () {
        return this.password;
    }

    public String getTo () {
        return this.to;
    }

    public String getSubject () {
        return this.subject;
    }

    public String getContent () {
        return this.content;
    }
}
