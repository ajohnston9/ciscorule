/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.johnstonconsulting.ciscoruletool.xml;

import com.johnstonconsulting.ciscoruletool.utils.Rule;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import nu.xom.Document;
import nu.xom.Element;

/**
 *
 * @author andrew
 */
public class RuleSaver {
    
    private String mName;
    private String mDesc;
    private String mSeverity;
    private ArrayList<Rule> mRules;
    
    public RuleSaver(String name, String desc, String severity, ArrayList<Rule> rules) {
        mName  = name;
        mDesc  = desc;
        mSeverity = severity;
        mRules = rules;
    }
    
    public void saveToXML() throws IOException {
        Element root = new Element("RuleDefinition");
        
        Element name = new Element("Name");
        name.appendChild(mName);
        root.appendChild(name);
        
        Element desc = new Element("Description");
        desc.appendChild(mDesc);
        root.appendChild(desc);
        
        Element severity = new Element("Severity");
        severity.appendChild(mSeverity);
        root.appendChild(severity);
        
        Element rules = new Element("Rules");
        for (Rule r : mRules) {
            Element rule = new Element("Rule");
            
            Element setting = new Element("Parameter");
            setting.appendChild(r.getParam());
            rule.appendChild(setting);
            
            Element param = new Element("Argument");
            param.appendChild(r.getArg());
            rule.appendChild(param);
            
            rules.appendChild(rule);
        }
        root.appendChild(rules);
        Document doc = new Document(root);
        String docName = getDocName(mName);
        FileWriter f = new FileWriter(docName);
        PrintWriter p = new PrintWriter(f);
        p.write(doc.toXML());
        p.flush();
        p.close();
    }
    
    private String getDocName(String name) {
        String doc = name.toLowerCase().replace(" ", "-");
        return doc + ".xml";
    }
    
}
