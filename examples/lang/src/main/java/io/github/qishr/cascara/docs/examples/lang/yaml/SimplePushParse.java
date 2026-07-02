package io.github.qishr.cascara.docs.examples.lang.yaml;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.streaming.Event;
import io.github.qishr.cascara.common.lang.streaming.StreamHandler;
import io.github.qishr.cascara.lang.yaml.processor.YamlPushParser;

@Example
public class SimplePushParse implements StreamHandler {
    public static void main(String args[]) {
        SimplePushParse handler = new SimplePushParse();
        InputStream is = SimplePushParse.class.getResourceAsStream("subject.yaml");
        YamlPushParser parser = new YamlPushParser();
            // .setReporter(new StandardReporter().setLevel(Level.TRACE));

        parser.parse(is, handler);
    }

    @Override
    public void onEvent(Event event) {
        if (event != null) {
            switch(event.getType()) {
                case FIELD_NAME:
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
