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

package io.github.qishr.cascara.docs.examples.schema;

import java.io.IOException;
import java.io.InputStream;

import io.github.qishr.cascara.common.diagnostic.report.SilentCollectingReporter;
import io.github.qishr.cascara.common.io.IOUtils;
import io.github.qishr.cascara.common.util.UriScheme;
import io.github.qishr.cascara.common.io.provider.ResResourceProvider;
import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.lang.json.ast.JsonNode;
import io.github.qishr.cascara.lang.json.processor.JsonAstParser;
import io.github.qishr.cascara.schema.util.SchemaValidator;

@Example
public class ValidateWithCollector {
    public static void main(String args[]) throws IOException {
        // Tell IOUtils to use this class when reading resources
        IOUtils.setResourceProvider(UriScheme.RES, new ResResourceProvider(AgnosticValidationExample.class));

        SilentCollectingReporter reporter = new SilentCollectingReporter();
        reporter.setDiagnosticConsumer(problem -> {
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