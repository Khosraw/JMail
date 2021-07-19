package me.khosraw;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Credentials {
    private String email;
    private String password;
    String to;
    String subject;
    String content;

    Credentials (String email, String password) {
        this.email = email;
        this.password = password;
    }

    Credentials (String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    private static String credentials (String email, String password, String to, String subject, String content) {
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));

            byte[] resultByArray = messageDigest.digest();
            for (byte b : resultByArray) {
                sb.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return email + "\n" + sb + "\n" + to + "\n" + subject + "\n" + content;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPass() {
        return this.password;
    }
}