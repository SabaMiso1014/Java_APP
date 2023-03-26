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

package ee.jakarta.tck.faces.test.javaee8.facelets;

import jakarta.enterprise.inject.Model;

@Model
public class DataBacking {

	private Child11 child11 = new Child11("11-member 1", "11-member 2");
	private Child11 child111 = new Child111("111-member 1", "111-member 2");
	
	public Child11 getData11() {
		return child11;
	}
	
	public Child11 getData111() {
		return child111;
	}
	
}
