/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.tamaya.metamodel.ext;

import org.apache.tamaya.Configuration;
import org.apache.tamaya.ConfigurationProvider;
import org.apache.tamaya.metamodel.MetaConfiguration;
import org.junit.Test;

import java.net.URL;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by atsticks on 06.12.16.
 */
public class IntegrationTest {

    @Test
    public void checkSystemLoads(){
        assertNotNull(ConfigurationProvider.getConfiguration());
        System.out.println(ConfigurationProvider.getConfiguration());
    }

    @Test
    public void testEmptyConfig(){
        Configuration config = MetaConfiguration.createConfiguration(getConfig("IntegrationTests/empty-config.xml"));
        assertNotNull(config);
        assertTrue(config.getProperties().isEmpty());
        assertTrue(config.getContext().getPropertySources().isEmpty());
        assertTrue(config.getContext().getPropertyConverters().isEmpty());
        assertTrue(config.getContext().getPropertyFilters().isEmpty());
    }

    private URL getConfig(String resource) {
        return getClass().getClassLoader().getResource(resource);
    }

}