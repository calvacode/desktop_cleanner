package com.estudo.domains;

import java.io.File;
import java.util.List;

public class Context {

    private List<RuleType> ruleTypeList;

    private List<File> directories;

    public List<File> getDirectories() {
        return directories;
    }

    public void setDirectories(final List<File> directories) {
        this.directories = directories;
    }

    public List<RuleType> getRuleTypeList() {
        return ruleTypeList;
    }

    public void setRuleTypeList(final List<RuleType> ruleTypeList) {
        this.ruleTypeList = ruleTypeList;
    }
}
