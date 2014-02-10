public class Elevator{
	private short totalFloor;
	private short currentFloor;
	private byte status;

	public short getTotalFloor() {
	    return this.totalFloor;
	}

	public short getCurrentFloor() {
	    return this.currentFloor;
	}

	public byte getStatus() {
	    return this.status;
	}

	public void setTotalFloor(short totalFloor) {
	    this.totalFloor = totalFloor;
	}

	public void setCurrentFloor(short currentFloor) {
	    this.currentFloor = currentFloor;
	}

	public void setStatus(byte status) {
	    this.status = status;
	}

	public Elevator(){
		this.totalFloor = 0;
		this.currentFloor = 1;
		this.status = 0;
	}

	public Elevator(short totalFloor, short currentFloor){
		this.totalFloor = totalFloor;
		this.currentFloor = currentFloor;
		this.status = 0;
	}

	public short move(short target){
		
		if (target > this.currentFloor) {
			this.status = 1;
		}else if (target < this.currentFloor) {
			this.status = -1;
		}else if (target == this.currentFloor) {
			this.status = 0;
		}
		short i = this.currentFloor;
		while(this.currentFloor != target){
			System.out.println("Floor: " + i);
			if(this.status == 1) {
				i++;
			}else if (this.status == -1){
				i--;
			}
			this.currentFloor = i;
		}
		return target;
	}
}