package com.hkmx.kafka.spingkafka;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class CustomeMessage implements Serializable {

    private String title;
    private String content;

    public static void main(String[] args) {
        CustomeMessage message = new CustomeMessage("", "");
    }

}
