/*
 * Copyright 2021 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.storage.impl.sql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import io.apicurio.registry.storage.impexp.GlobalRuleEntity;
import io.apicurio.registry.types.RuleType;

/**
 * @author eric.wittmann@gmail.com
 */
public class GlobalRuleEntityMapper implements RowMapper<GlobalRuleEntity> {

    public static final GlobalRuleEntityMapper instance = new GlobalRuleEntityMapper();

    /**
     * Constructor.
     */
    private GlobalRuleEntityMapper() {
    }

    /**
     * @see org.jdbi.v3.core.mapper.RowMapper#map(java.sql.ResultSet, org.jdbi.v3.core.statement.StatementContext)
     */
    @Override
    public GlobalRuleEntity map(ResultSet rs, StatementContext ctx) throws SQLException {
        GlobalRuleEntity entity = new GlobalRuleEntity();
        entity.ruleType = RuleType.fromValue(rs.getString("type"));
        entity.configuration = rs.getString("configuration");
        return entity;
    }

}