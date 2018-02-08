package de.cinovo.cloudconductor.api.enums;

/*
 * #%L
 * cloudconductor-api
 * %%
 * Copyright (C) 2013 - 2014 Cinovo AG
 * %%
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
 * #L%
 */

/**
 * Copyright 2013 Cinovo AG<br>
 * <br>
 *
 * @author psigloch
 */
public enum ServiceState {
	/**
	 * NEXT POSSIBLE STATE: STARTED, STOPPING <br>
	 * PREVIOUS STATE : STOPPED <br>
	 * [0]
	 */
	STARTING, /**
	 * NEXT POSSIBLE STATE: STOPPING, RESTARTING_STOPPING <br>
	 * PREVIOUS STATE : STARTING <br>
	 * [1]
	 */
	STARTED, /**
	 * NEXT POSSIBLE STATE: STOPPING, RESTARTING_STOPPING <br>
	 * PREVIOUS STATE : STARTED <br>
	 * [2]
	 */
	IN_SERVICE,

	/**
	 * NEXT POSSIBLE STATE: STOPPED, STARTING <br>
	 * PREVIOUS STATE : STARTED <br>
	 * [3]
	 */
	STOPPING, /**
	 * NEXT POSSIBLE STATE: STARTING <br>
	 * PREVIOUS STATE : STOPPING <br>
	 * [4]
	 */
	STOPPED,

	/**
	 * NEXT POSSIBLE STATE: RESTARTING_STARTING <br>
	 * PREVIOUS STATE : STARTED, IN_SERVICE <br>
	 * [5]
	 */
	RESTARTING_STOPPING, /**
	 * NEXT POSSIBLE STATE: STARTED <br>
	 * PREVIOUS STATE : RESTARTING_STOPPING <br>
	 * [6]
	 */
	RESTARTING_STARTING;

	/**
	 * states in flight/ in transition
	 */
	public static ServiceState[] INFLIGHT_STATES = new ServiceState[]{ServiceState.STARTING, ServiceState.STOPPING, ServiceState.RESTARTING_STOPPING, ServiceState.RESTARTING_STARTING};

	/**
	 * @param nextState the next desired state
	 * @return true, if the desired state is reachable
	 */
	public boolean isStateChangePossible(ServiceState nextState) {
		if(nextState == null) {
			return false;
		}
		switch(this) {
			case STARTING:
				return nextState == ServiceState.STARTED || nextState == ServiceState.STOPPING;
			case STARTED:
				return nextState == ServiceState.STOPPING || nextState == ServiceState.RESTARTING_STOPPING || nextState == ServiceState.IN_SERVICE;
			case IN_SERVICE:
				return nextState == ServiceState.STOPPING || nextState == ServiceState.RESTARTING_STOPPING;
			case STOPPING:
				return nextState == ServiceState.STOPPED || nextState == ServiceState.STARTING;
			case STOPPED:
				return nextState == ServiceState.STARTING;
			case RESTARTING_STOPPING:
				return nextState == ServiceState.RESTARTING_STARTING;
			case RESTARTING_STARTING:
				return nextState == ServiceState.STARTED;
		}
		return false;
	}

	/**
	 * @return find next state of an in-flight state
	 */
	public ServiceState next() {
		ServiceState current = ServiceState.valueOf(this.name());
		boolean inflight = false;
		for(ServiceState s : ServiceState.INFLIGHT_STATES) {
			if(s.equals(current)) {
				inflight = true;
				break;
			}
		}
		if(inflight) {
			switch(current) {
				case RESTARTING_STARTING:
					return ServiceState.STARTED;
				case RESTARTING_STOPPING:
					return ServiceState.RESTARTING_STARTING;
				case STARTING:
					return ServiceState.STARTED;
				case STOPPING:
					return ServiceState.STOPPED;
				default:
					break;

			}
		}
		return current;
	}
}
