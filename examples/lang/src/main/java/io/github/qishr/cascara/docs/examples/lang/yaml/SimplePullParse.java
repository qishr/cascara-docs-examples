package io.github.qishr.cascara.docs.examples.lang.yaml;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.streaming.Event;
import io.github.qishr.cascara.common.lang.streaming.EventType;
import io.github.qishr.cascara.lang.yaml.processor.YamlPullParser;

@Example
public class SimplePullParse {
    public static void main(String args[]) {
        InputStream is = SimplePullParse.class.getResourceAsStream("subject.yaml");
        try (YamlPullParser parser = new YamlPullParser(is)) {
            while (parser.hasNext()) {
                Event event = parser.next();
                if (event.getType() == EventType.FIELD_NAME) {
                    String fieldName = event.getContent();
                    if ("name".equals(fieldName)) {
                        while (parser.hasNext()) {
                            Event subEvent = parser.next();
                            if (subEvent.getType() == EventType.END_OBJECT) break;
                            if (subEvent.getType() == EventType.VALUE_SCALAR) {
                                System.out.println(subEvent.getContent());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
