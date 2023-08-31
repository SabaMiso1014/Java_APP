/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
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

package ee.jakarta.tck.faces.test.javaee6web.viewscope;

import java.io.Serializable;
import java.util.Map;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ViewScopedBean implements Serializable {

    private static final String SESSION_KEY = ViewScopedBean.class.getName() + "_KEY";
    private static final long serialVersionUID = 8437531843054754394L;

    private int myCount = 0;
    private String value;

    public ViewScopedBean() {
        myCount = increment();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getMyCount() {
        return myCount;
    }

    private synchronized int increment() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Integer result = (Integer) sessionMap.get(SESSION_KEY);
        if (result == null) {
            result = 0;
            sessionMap.put(SESSION_KEY, result);
        }
        sessionMap.put(SESSION_KEY, ++result);
        return result;

    }

}
