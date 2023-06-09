// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.desktop.cluster.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloud.desktop.cluster.DesktopClusterIpRangeVO;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchCriteria;
import com.cloud.utils.db.SearchBuilder;

@Component
public class DesktopClusterIpRangeDaoImpl extends GenericDaoBase<DesktopClusterIpRangeVO, Long> implements DesktopClusterIpRangeDao {

    private final SearchBuilder<DesktopClusterIpRangeVO> DesktopClusterSearch;

    public DesktopClusterIpRangeDaoImpl() {
        DesktopClusterSearch = createSearchBuilder();
        DesktopClusterSearch.and("desktopClusterId", DesktopClusterSearch.entity().getDesktopClusterId(), SearchCriteria.Op.EQ);
        DesktopClusterSearch.done();
    }

    @Override
    public List<DesktopClusterIpRangeVO> listByDesktopClusterId(long desktopClusterId) {
        SearchCriteria<DesktopClusterIpRangeVO> sc = DesktopClusterSearch.create();
        sc.setParameters("desktopClusterId", desktopClusterId);
        return listBy(sc);
    }
}
