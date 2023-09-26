package agent_ABCD;

import agent_ABCD.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if(p.getLocationState() == LocationState.DIRTY) {//trang thai co bui
			
			return Environment.SUCK_DIRT; // hut bui
		}else {//trang thai sach
			if(p.getAgentLocation().equals(Environment.LOCATION_A)) {
				return Environment.MOVE_RIGHT;
			}else if(p.getAgentLocation().equals(Environment.LOCATION_B)) {
				return Environment.MOVE_DOWN;
			}else if(p.getAgentLocation().equals(Environment.LOCATION_C)) {
				return Environment.MOVE_LEFT;
			}else {
				return Environment.MOVE_UP;
			}
		}
		
	}
	
}