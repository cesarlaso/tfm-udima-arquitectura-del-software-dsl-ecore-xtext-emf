public class TelemetryWriter {

	private final DataOutputStream out;

	public TelemetryWriter(final DataOutputStream out) {
		this.out = out;
	}

	public
	
	void writePing(final Ping value) throws IOException {
		out.writeInt(1);
		writeStatusService
		
		out.writeInt(secuence);
		out.writeLong(timestamp);
	}
	public
	
	void writePong(final Pong value) throws IOException {
		out.writeInt(2);
		writeStatusService
		
		out.writeInt(secuence);
		out.writeLong(timestamp);
	}
}
