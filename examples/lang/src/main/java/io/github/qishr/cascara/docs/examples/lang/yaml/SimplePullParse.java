package io.github.qishr.cascara.docs.examples.lang.yaml;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.streaming.StreamingEvent;
import io.github.qishr.cascara.common.lang.streaming.StreamingEventType;
import io.github.qishr.cascara.lang.yaml.processor.YamlPullParser;

@Example
public class SimplePullParse {
    public static void main(String args[]) {
        InputStream is = SimplePullParse.class.getResourceAsStream("subject.yaml");
        try (YamlPullParser parser = new YamlPullParser(is)) {
            while (parser.hasNext()) {
                StreamingEvent event = parser.next();
                if (event.getType() == StreamingEventType.FIELD_NAME) {
                    String fieldName = event.getContent();
                    if ("name".equals(fieldName)) {
                        while (parser.hasNext()) {
                            StreamingEvent subEvent = parser.next();
                            if (subEvent.getType() == StreamingEventType.END_OBJECT) break;
                            if (subEvent.getType() == StreamingEventType.VALUE_SCALAR) {
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
