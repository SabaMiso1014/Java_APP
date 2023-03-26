/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
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

package ee.jakarta.tck.faces.test.javaee8.flash;

import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;

@Model
public class Issue4167 {

    public String keepAndRedirect() {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("message", "issue4167");
        return "issue4167?faces-redirect=true";
    }
    
    public String keepAndGet() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.keep("message");
        return (String) flash.get("message");
    }
    
}
