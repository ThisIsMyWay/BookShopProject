package com.playingwithee.dal.utils;

import org.apache.commons.io.IOUtils;
import org.hibernate.tool.hbm2ddl.ImportSqlCommandExtractor;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.io.Reader;


public class ImportSqlCustomSeparator implements ImportSqlCommandExtractor {

    private Logger logger = Logger.getLogger(ImportSqlCustomSeparator.class);

    @Override
    public String[] extractCommands(Reader reader) {

        try {
            String allCommands = IOUtils.toString(reader);
            return allCommands.split("--\\*\\*\\*\\*\\*\\*\\*\\*--");
        } catch (IOException e) {
            logger.error("error reading import commands", e);
            return new String[0];
        }
    }
}
