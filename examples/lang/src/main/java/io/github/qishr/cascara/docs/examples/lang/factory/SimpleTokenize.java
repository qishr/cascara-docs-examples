package io.github.qishr.cascara.docs.examples.lang.factory;

import java.io.InputStream;
import java.util.List;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.processor.ProcessorFactory;
import io.github.qishr.cascara.common.lang.processor.Tokenizer;
import io.github.qishr.cascara.common.lang.token.Token;

@Example
public class SimpleTokenize {
    public static void main(String args[]) {
        InputStream is = SimpleAstParse.class.getResourceAsStream("subject.yaml");
        Tokenizer<?> tokenizer = new ProcessorFactory().createTokenizer("text/yaml");
        List<? extends Token> tokens = tokenizer.tokenize(is);
        for (Token token : tokens) {
            System.out.println(token.getType() + " " + token.getLexeme());
        }
    }
}
