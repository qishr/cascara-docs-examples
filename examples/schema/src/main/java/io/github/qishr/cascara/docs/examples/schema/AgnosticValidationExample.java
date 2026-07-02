package io.github.qishr.cascara.docs.examples.schema;

import io.github.qishr.cascara.common.diagnostic.LocalizableException;
import io.github.qishr.cascara.common.diagnostic.LocalizableIOException;
import io.github.qishr.cascara.common.diagnostic.SilentCollectingReporter;
import io.github.qishr.cascara.common.io.IOUtils;
import io.github.qishr.cascara.common.io.ResourceStream;
import io.github.qishr.cascara.common.io.UriScheme;
import io.github.qishr.cascara.common.io.provider.ResResourceProvider;
import io.github.qishr.cascara.common.lang.ast.AstNode;
import io.github.qishr.cascara.common.lang.processor.AstParser;
import io.github.qishr.cascara.common.lang.processor.ProcessorFactory;
import io.github.qishr.cascara.schema.Schema;
import io.github.qishr.cascara.schema.exception.ValidationException;
import io.github.qishr.cascara.schema.util.SchemaCompiler;
import io.github.qishr.cascara.schema.util.SchemaValidator;

public class AgnosticValidationExample {
    public static void main(String args[]) throws LocalizableException {
        // Tell IOUtils to use this class when reading resources
        IOUtils.setResourceProvider(UriScheme.RES, new ResResourceProvider(AgnosticValidationExample.class));

        // Parse a valid file
        ResourceStream res = IOUtils.getResourceAsStream("res://valid.json");
        AstParser<?,?> parser = new ProcessorFactory().createAstParser(res.contentType);
        AstNode validData = parser.parse(res.stream);

        // Parse an invalid file
        res = IOUtils.getResourceAsStream("res://invalid.json");
        parser = new ProcessorFactory().createAstParser(res.contentType);
        AstNode invalidData = parser.parse(res.stream);

        // Validate the valid data in 3 different ways
        validate(validData);
        validateWithCollector(validData);
        validateWithSpecifiedSchema(validData);

        // Validate the invalid data in 3 different ways
        validate(invalidData);
        validateWithCollector(invalidData);
        validateWithSpecifiedSchema(invalidData);
    }

    private static void validate(AstNode data) {
        SchemaValidator validator = new SchemaValidator();
        try {
            validator.validate(data);
        } catch (ValidationException e) {
            System.err.println("validate error: " + e.getMessage());
        }
    }

    private static void validateWithCollector(AstNode data) {
        SilentCollectingReporter reporter = new SilentCollectingReporter();
        reporter.setDiagnosticCollector(problem -> {
            System.err.println("validateWithCollector error: " + problem.getMessage());
        });
        SchemaValidator validator = new SchemaValidator(reporter);
        validator.validate(data);
    }

    private static void validateWithSpecifiedSchema(AstNode data) {
        // Load the schema from resources
        ResourceStream res;
        try {
            res = IOUtils.getResourceAsStream("res://schema.json");
        } catch (LocalizableIOException e) {
            System.err.println("Failed to load schema: " + e.getMessage());
            return;
        }

        // Parse the schema
        AstParser<?,?> parser = new ProcessorFactory().createAstParser(res.contentType);
        AstNode schemaAst = parser.parse(res.stream);

        // Compile the schema
        Schema schema = new SchemaCompiler().compile(schemaAst);

        // Validate
        try {
            schema.validate(data);
        } catch (ValidationException e) {
            System.err.println("validateWithSpecifiedSchema error: " + e.getMessage());
        }
    }
}