package com.snhu.sslserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;

@RestController
public class HashController {

    @GetMapping("/hash")
    public String getHash(@RequestParam("data") String data) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        byte[] digest = md.digest();

        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            hexString.append(String.format("%02x", b));
        }

        return "Name: Matthew Willhite\n"
                + "Data: " + data + "\n"
                + "SHA-256 Hash: " + hexString.toString();
    }
}
