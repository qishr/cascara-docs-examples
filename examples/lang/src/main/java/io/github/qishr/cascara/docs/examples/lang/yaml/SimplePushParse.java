// License & Terms
//
// This file is part of **Cascara Examples**.
//
// **Cascara Examples** are free software: you can redistribute
// them and/or modify them without restriction under the terms of
// the MIT License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// MIT License for more details.

package io.github.qishr.cascara.docs.examples.lang.yaml;

import java.io.InputStream;

import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.common.lang.streaming.StreamHandler;
import io.github.qishr.cascara.lang.yaml.processor.YamlPushParser;
import io.github.qishr.cascara.lang.yaml.streaming.YamlStreamingEvent;

@Example
public class SimplePushParse implements StreamHandler<YamlStreamingEvent> {
    public static void main(String args[]) {
        SimplePushParse handler = new SimplePushParse();
        InputStream is = SimplePushParse.class.getResourceAsStream("subject.yaml");
        YamlPushParser parser = new YamlPushParser();
        parser.parse(is, handler);
    }

    @Override
    public void onEvent(YamlStreamingEvent event) {
        if (event != null) {
            switch(event.getType()) {
                case KEY:
                    System.out.println("Name: " + event.getContent());
                    break;
                case VALUE_SCALAR:
                    System.out.println("Value: " + event.getContent());
                    break;
                default:
            }
        } else {
            System.err.println("NULL");
        }
    }
}
