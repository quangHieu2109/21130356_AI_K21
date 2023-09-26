package agent_AB;

import agent_AB.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState() == LocationState.DIRTY) {//trang thai co bui
			
			return Environment.SUCK_DIRT; // hut bui
		}else {//trang thai sach
			if(p.getAgentLocation().equals(Environment.LOCATION_A)) {
				return Environment.MOVE_RIGHT;
			}else {
				return Environment.MOVE_RIGHT;
			}
		}
		
	}
	
}