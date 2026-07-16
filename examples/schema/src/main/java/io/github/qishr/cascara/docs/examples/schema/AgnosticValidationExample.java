// # License & Terms
//
// This file is part of **Cascara**.
//
// **Cascara** is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program. If not, see <https://www.gnu.org/licenses/>.
//
// ---
//
// ## Special Runtime Exception
//
// As a special exception, the copyright holders of this library give you
// permission to link this library with independent modules to produce an
// executable, regardless of the license terms of these independent modules,
// and to copy and distribute the resulting executable under terms of your
// choice, provided that you also meet, for each linked independent module,
// the terms and conditions of the license of that module.
//
// An independent module is a module which is not derived from or based on
// this library. If you modify this library, you may extend this exception
// to your version of the library, but you are not obligated to do so. If
// you do not wish to do so, delete this exception statement from your
// version.


package io.github.qishr.cascara.docs.examples.schema;

import java.io.IOException;

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
    public static void main(String args[]) throws IOException {
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