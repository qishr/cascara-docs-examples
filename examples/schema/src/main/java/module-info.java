module cascara.docs.examples.schema {
    requires transitive cascara.common;
    requires cascara.common.io;
    requires cascara.lang.json;
    requires cascara.lang.xml;
    requires cascara.lang.yaml;
    requires cascara.schema;

    // Allow IOUtils to read the resources
    opens io.github.qishr.cascara.docs.examples.schema to cascara.common.io;
}