/**
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008-2009 Sun Microsystems, Inc. All rights reserved.
 * Copyright 2011-2013 Tirasa. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License"). You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at https://oss.oracle.com/licenses/CDDL
 * See the License for the specific language governing permissions and limitations
 * under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at https://oss.oracle.com/licenses/CDDL.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */
package org.connid.bundles.db.table.security;

import java.io.UnsupportedEncodingException;
import org.identityconnectors.common.logging.Log;

public abstract class EncodeAlgorithm {

    /**
     * Setup logging for the {@link EncodeAlgorithm}.
     */
    protected static Log LOG = Log.getLog(EncodeAlgorithm.class);

    public abstract String encode(final String clearPwd, String charsetName)
            throws PasswordEncodingException, UnsupportedPasswordCharsetException;

    public abstract String decode(final String encodedPwd, String charsetName)
            throws PasswordDecodingException;

    public abstract String getName();

    public abstract void setKey(final String key)
            throws UnsupportedEncodingException;
}
