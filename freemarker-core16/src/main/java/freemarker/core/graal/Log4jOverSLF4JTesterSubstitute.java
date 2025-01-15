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

package freemarker.core.graal;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import freemarker.log._Log4jOverSLF4JTester;

/**
 * avoid a class not found on org.apache.log4j.MDC
 *
 * NOTE: class added via "JEP 238: Multi-Release JAR Files" only for jdk 16+
 * (minimum required version is actually jdk 11+,
 * but as GraalVM currently support JDK 17+ there is no need to create another module)
 */
@TargetClass(_Log4jOverSLF4JTester.class)
public final class Log4jOverSLF4JTesterSubstitute {

    @Substitute
    public static final boolean test() {
        return false;
    }
}
