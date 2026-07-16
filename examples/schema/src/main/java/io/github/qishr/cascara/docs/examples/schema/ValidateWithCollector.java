package io.github.qishr.cascara.docs.examples.schema;

import java.io.IOException;
import java.io.InputStream;

import io.github.qishr.cascara.common.diagnostic.SilentCollectingReporter;
import io.github.qishr.cascara.common.io.IOUtils;
import io.github.qishr.cascara.common.io.UriScheme;
import io.github.qishr.cascara.common.io.provider.ResResourceProvider;
import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.json.ast.JsonNode;
import io.github.qishr.cascara.lang.json.processor.JsonAstParser;
import io.github.qishr.cascara.schema.util.SchemaValidator;

@Example
public class ValidateWithCollector {
    public static void main(String args[]) throws IOException {
        // Tell IOUtils to use this class when reading resources
        IOUtils.setResourceProvider(UriScheme.RES, new ResResourceProvider(AgnosticValidationExample.class));

        SilentCollectingReporter reporter = new SilentCollectingReporter();
        reporter.setDiagnosticCollector(problem -> {
            System.err.println("Validation error: " + problem.getMessage());
        });

        // Validate valid JSON
        InputStream is = ValidateWithCollector.class.getResourceAsStream("valid.json");
        JsonNode validData = new JsonAstParser().parse(is);
        new SchemaValidator(reporter).validate(validData);

        // Validate invalid JSON
        is = ValidateWithCollector.class.getResourceAsStream("invalid.json");
        JsonNode invalidData = new JsonAstParser().parse(is);
        new SchemaValidator(reporter).validate(invalidData);
    }
}