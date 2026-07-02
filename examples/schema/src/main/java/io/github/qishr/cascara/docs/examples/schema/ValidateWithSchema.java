package io.github.qishr.cascara.docs.examples.schema;

import java.io.InputStream;

import io.github.qishr.cascara.common.diagnostic.LocalizableException;
import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.json.ast.JsonNode;
import io.github.qishr.cascara.lang.json.processor.JsonAstParser;
import io.github.qishr.cascara.schema.Schema;
import io.github.qishr.cascara.schema.exception.ValidationException;
import io.github.qishr.cascara.schema.util.SchemaCompiler;

@Example
public class ValidateWithSchema {
    public static void main(String args[]) throws LocalizableException {
        // Load the schema from resources
        InputStream is = ValidateWithSchema.class.getResourceAsStream("schema.json");
        JsonNode schemaAst = new JsonAstParser().parse(is);

        // Compile the schema
        Schema schema = new SchemaCompiler().compile(schemaAst);

        try {
            // Validate valid JSON
            is = ValidateWithSchema.class.getResourceAsStream("valid.json");
            JsonNode validData = new JsonAstParser().parse(is);
            schema.validate(validData);

            // Validate invalid JSON
            is = ValidateWithSchema.class.getResourceAsStream("invalid.json");
            JsonNode invalidData = new JsonAstParser().parse(is);
            schema.validate(invalidData);
        } catch (ValidationException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}