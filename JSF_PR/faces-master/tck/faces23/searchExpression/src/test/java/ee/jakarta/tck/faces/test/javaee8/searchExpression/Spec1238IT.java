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

package ee.jakarta.tck.faces.test.javaee8.searchExpression;


import static java.lang.System.getProperty;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;

import java.io.File;
import java.net.URL;

import ee.jakarta.tck.faces.test.util.selenium.BaseArquilianRunner;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlLabel;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import jakarta.faces.component.search.SearchKeywordResolver;

@RunWith(BaseArquilianRunner.class)
public class Spec1238IT {

    @ArquillianResource
    private URL webUrl;
    private WebClient webClient;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return create(ZipImporter.class, getProperty("finalName") + ".war")
                .importFrom(new File("target/" + getProperty("finalName") + ".war"))
                .as(WebArchive.class);
    }

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setJavaScriptTimeout(120000);
    }

    /**
     * @see SearchKeywordResolver
     * @see https://github.com/jakartaee/faces/issues/1238
     */
    @Test
    public void test() throws Exception {
        webClient.setIncorrectnessListener((ignore, nothing) -> {});

        testSearchExpression();
    }

    public void testSearchExpression() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "spec1238.xhtml");
        webClient.waitForBackgroundJavaScript(60000);

        HtmlLabel label = (HtmlLabel) page.getHtmlElementById("label");
        HtmlTextInput input = (HtmlTextInput) page.getHtmlElementById("spec1238ITinput1");
        
        Assert.assertEquals(label.getAttribute("for"), input.getId());
        
        String onchange = input.getAttribute("onchange");

        if (onchange.contains("@this")) {
            Assert.assertFalse(onchange.contains("spec1238ITinput1"));
        }
        else {
            Assert.assertTrue(onchange.contains("spec1238ITinput1"));
        }

        Assert.assertTrue(onchange.contains("spec1238ITinput2"));
    }

    @After
    public void tearDown() {
        webClient.close();
    }

}
