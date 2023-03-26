/*
 * Copyright (c) 2023 Contributors to the Eclipse Foundation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GPL-2.0 with Classpath-exception-2.0 which
 * is available at https://openjdk.java.net/legal/gplv2+ce.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 or Apache-2.0
 */
package ee.jakarta.tck.faces.test.util.selenium;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * Standard Arquilian runner, which triggers the default Arquilian/HTMLUnit based test System
 * if <code>test.selenium</code> is not set as system property.
 */
public class BaseArquilianRunner extends Arquillian {

    public BaseArquilianRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected boolean isIgnored(FrameworkMethod child) {
        if ("true".equals(System.getProperty("test.selenium"))) {
            return true;
        }

        return super.isIgnored(child);
    }

}
