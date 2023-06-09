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

import com.cloud.desktop.cluster.DesktopCluster;
import com.cloud.desktop.cluster.DesktopClusterVO;
import com.cloud.utils.db.GenericDao;
import com.cloud.utils.fsm.StateDao;

public interface DesktopClusterDao extends GenericDao<DesktopClusterVO, Long>,
        StateDao<DesktopCluster.State, DesktopCluster.Event, DesktopCluster> {

    List<DesktopClusterVO> listByAccount(long accountId);
    List<DesktopClusterVO> findDesktopClustersToGarbageCollect();
    List<DesktopClusterVO> findDesktopClustersInState(DesktopCluster.State state);
    List<DesktopClusterVO> listByNetworkId(long networkId);
    List<DesktopClusterVO> listAllByDesktopVersion(long desktopVersionId);
}
