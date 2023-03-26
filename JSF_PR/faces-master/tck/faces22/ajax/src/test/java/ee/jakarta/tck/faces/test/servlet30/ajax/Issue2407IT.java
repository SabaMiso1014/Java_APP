/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package ee.jakarta.tck.faces.test.servlet30.ajax; 

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

import ee.jakarta.tck.faces.test.util.arquillian.ITBase;
import jakarta.faces.component.behavior.AjaxBehavior;
import jakarta.faces.component.html.HtmlCommandButton;

public class Issue2407IT extends ITBase {

    /**
     * This test verifies that an attribute named 'value' can be successfully updated
     * from a partial response (over Ajax). 
     * 
     * @see AjaxBehavior
     * @see HtmlCommandButton#getValue()
     * @see https://github.com/eclipse-ee4j/mojarra/issues/2411
     */
    @Test
    public void testUpdateAttributeNamedValue() throws Exception {
        HtmlPage page = getPage("attributeNameIsValue.xhtml");
        assertTrue(page.asXml().contains("foo"));
        HtmlSubmitInput button = (HtmlSubmitInput)page.getElementById("form1:button");
        page = button.click();
        webClient.waitForBackgroundJavaScript(3000);
        assertTrue(page.asXml().contains("bar"));
    }
}
