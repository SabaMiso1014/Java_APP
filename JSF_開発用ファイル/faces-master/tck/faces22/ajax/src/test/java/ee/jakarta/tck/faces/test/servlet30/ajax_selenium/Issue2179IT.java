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

package ee.jakarta.tck.faces.test.servlet30.ajax_selenium;

import ee.jakarta.tck.faces.test.util.selenium.BaseITNG;
import ee.jakarta.tck.faces.test.util.selenium.WebPage;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.PartialViewContext;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class Issue2179IT extends BaseITNG {
    
    /**
     * @see PartialViewContext
     * @see ExceptionHandler
     * @see https://github.com/eclipse-ee4j/mojarra/issues/2183
     */
    @Test
    public void testEncodeException() throws Exception {
        WebPage page = getPage("issue2179-page1.xhtml");
        int responseStatus = page.getResponseStatus();
        assertTrue(responseStatus == 500);
    }

    /**
     * @see PartialViewContext
     * @see ExceptionHandler
     * @see https://github.com/eclipse-ee4j/mojarra/issues/2183
     */
    @Test
    public void testDecodeException() {
        // the major change is to shift the textarea over
        // apparently they used the text attribute which does not work
        // on new browsers, innerText must be used
        // or a div with innerHTML which always will work, also value does work
        WebPage page = getPage("issue2179-page2.xhtml");
        WebElement button = page.findElement(By.id("form:submit"));
        button.click();
        //page.waitReqJs();

        assertTrue(page.isInPageTextReduced("Name: form:submit Error: serverError"));
    }
}
