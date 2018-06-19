public class TelemetryReader {

	private final DataInputStream in;

	public TelemetryReader(final DataInputStream in) {
		this.in = in;
	}

	Service readFromStream() {
		final int serviceType = in.readInt();
		switch (serviceType) {
			case 1: 
				readPing();
				break;
			case 2: 
				readPong();
				break;
		}
	}

	Ping readPing() throws IOException {
		final EInt secuence = in.writeInt();
		final ELong timestamp = in.writeLong();
	
		return new Ping(
		secuence, 
		timestamp
		);
	}
	
	Pong readPong() throws IOException {
		final EInt secuence = in.writeInt();
		final ELong timestamp = in.writeLong();
	
		return new Pong(
		secuence, 
		timestamp
		);
	}
	
}
