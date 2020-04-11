package org.jenkinsci.plugins.pipeline.yaml.exceptions;

public class PipelineAsYamlNodeNotFoundException extends PipelineAsYamlException {
    public PipelineAsYamlNodeNotFoundException(String nodeName) {
        super(String.format("%s - yaml definition not found.", nodeName));
    }
}
