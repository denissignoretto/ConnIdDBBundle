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
package org.connid.bundles.db.table.mapping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.identityconnectors.common.Assertions;
import org.connid.bundles.db.common.SQLParam;
import org.connid.bundles.db.common.SQLUtil;


/**
 * The SQL get/set strategy class implementation convert attributes back to database types
 * @version $Revision 1.0$
 * @since 1.0
 */
public class JdbcConvertor implements MappingStrategy {

    MappingStrategy delegate;
    
    /**
     * Final sql mapping
     * @param delegate
     */
    public JdbcConvertor(MappingStrategy delegate) {
        Assertions.nullCheck(delegate, "MappingStrategy delegate");
        this.delegate = delegate;
    }
    
    /* (non-Javadoc)
     * @see org.identityconnectors.databasetable.MappingStrategy#getSQLParam(java.sql.ResultSet, int, int)
     */
    public SQLParam getSQLParam(ResultSet resultSet, int i, String name, final int sqlType) throws SQLException {
        //Default processing otherwise
        return delegate.getSQLParam(resultSet, i, name, sqlType);
    } 
    
    /* (non-Javadoc)
     * @see org.identityconnectors.databasetable.MappingStrategy#getSQLAttributeType(int)
     */
    public Class<?> getSQLAttributeType(int sqlType) {
        return delegate.getSQLAttributeType(sqlType);
    }
    
    /* (non-Javadoc)
     * @see org.identityconnectors.databasetable.MappingStrategy#setSQLParam(java.sql.PreparedStatement, int, org.identityconnectors.dbcommon.SQLParam)
     */
    public void setSQLParam(final PreparedStatement stmt, final int idx, SQLParam parm) throws SQLException {
        final Object val = SQLUtil.attribute2jdbcValue(parm.getValue(), parm.getSqlType());
        delegate.setSQLParam(stmt, idx, new SQLParam(parm.getName(), val, parm.getSqlType()));
    }    
}

