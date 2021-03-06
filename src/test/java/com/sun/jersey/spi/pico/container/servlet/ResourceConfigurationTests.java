/*
 * Copyright (c) 2012, Thomas Czarniecki
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *  * Neither the name of Thomas Czarniecki, tomczarniecki.com nor
 *    the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.sun.jersey.spi.pico.container.servlet;

import org.junit.Test;
import org.picocontainer.MutablePicoContainer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ResourceConfigurationTests {

    @Test
    public void shouldRegisterGivenClassesAsRequestScopeComponents() {
        MutablePicoContainer scope = mock(MutablePicoContainer.class);

        ResourceConfiguration configuration = new ResourceConfiguration(String.class, Map.class);
        configuration.registerResourceScope(scope);

        verify(scope).addComponent(String.class);
        verify(scope).addComponent(Map.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldRegisterGivenClassesAsResources() {
        Set<Class<?>> resources = new HashSet<Class<?>>();

        ResourceConfiguration configuration = new ResourceConfiguration(String.class, Map.class);
        configuration.registerResources(resources);

        assertThat(resources, hasItems(String.class, Map.class));
    }
}
