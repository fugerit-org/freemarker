/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.freemarker.core.graal;

import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloFreeMarker {

    private final static Logger log = Logger.getLogger(HelloFreeMarker.class.getName());

    public static void main( String[] args ) throws Exception {
        try (StringWriter buffer = new StringWriter()) {
            Version version = Configuration.getVersion();   // using latest version
            // creates FreeMarker configuration
            Configuration cfg = new Configuration( version );
            cfg.setClassForTemplateLoading(HelloDataModel.class, "/freemarker-templates/");
            // creates data model
            HelloDataModel data = new HelloDataModel();
            data.setName( "FreeMarker Native Demo" );
            data.setVersion( version.toString() );
            log.info( String.format( "name : %s, version : %s", data.getName(), data.getVersion() ) );
            Map<String, Object> input = new HashMap<>();
            input.put( "data", data );
            // process template
            Template template = cfg.getTemplate( "hello-world.ftl" );
            template.process( input, buffer );
            log.info( String.format( "result :\n%s", buffer ) );
        }
    }

}
