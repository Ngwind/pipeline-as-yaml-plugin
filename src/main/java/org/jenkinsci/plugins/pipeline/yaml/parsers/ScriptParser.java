package org.jenkinsci.plugins.pipeline.yaml.parsers;

import org.jenkinsci.plugins.pipeline.yaml.exceptions.PipelineAsYamlException;
import org.jenkinsci.plugins.pipeline.yaml.interfaces.ParserInterface;
import org.jenkinsci.plugins.pipeline.yaml.models.ScriptModel;
import org.yaml.snakeyaml.Yaml;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class ScriptParser extends AbstractParser implements ParserInterface<ScriptModel> {

    private LinkedHashMap parentNode;

    public ScriptParser(LinkedHashMap parentNode){
        this.yamlNodeName = "script";
        this.nodeRequired = false;
        this.yaml = new Yaml();
        this.parentNode = parentNode;
    }

    @Override
    public Optional<ScriptModel> parse() {
        try {
            Object scripts = this.parentNode.get(this.yamlNodeName);
            if (scripts instanceof List) {
                return Optional.of(new ScriptModel((List<String>) scripts));
            } else {
                throw new PipelineAsYamlException(String.format("Unexpected type:%s", scripts.getClass().getName()));
            }
        }
        catch (PipelineAsYamlException p) {
            return Optional.empty();
        }
    }
}
