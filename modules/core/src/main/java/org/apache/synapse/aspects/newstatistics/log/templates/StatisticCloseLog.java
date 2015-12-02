/*
 *   Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.aspects.newstatistics.log.templates;

import org.apache.synapse.MessageContext;
import org.apache.synapse.aspects.newstatistics.RuntimeStatisticCollector;

public class StatisticCloseLog implements StatisticReportingLog {

	private MessageContext messageContext;
	private String componentId;
	private String parentId;
	private Long endTime;

	public StatisticCloseLog(MessageContext messageContext, String componentId, String parentId, Long endTime) {
		this.messageContext = messageContext;
		this.componentId = componentId;
		this.parentId = parentId;
		this.endTime = endTime;
	}

	@Override
	public void process() {
		RuntimeStatisticCollector.recordStatisticCloseLog(messageContext, componentId, parentId, endTime);
	}
}
