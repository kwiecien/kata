package codewars.killergaragedoor;

public class KillerGarageDoor {
	private enum State {
		OPEN {
			@Override
			public State close() {
				return State.ALMOST_OPEN;
			}

			@Override
			public State open() {
				return this;
			}

			@Override
			public String print() {
				return "5";
			}
		},
		ALMOST_OPEN {
			@Override
			public State close() {
				return State.HALFWAY_OPEN;
			}

			@Override
			public State open() {
				return State.OPEN;
			}

			@Override
			public String print() {
				return "4";
			}
		},
		HALFWAY_OPEN {
			@Override
			public State close() {
				return HALFWAY_CLOSED;
			}

			@Override
			public State open() {
				return ALMOST_OPEN;
			}

			@Override
			public String print() {
				return "3";
			}
		},
		HALFWAY_CLOSED {
			@Override
			public State close() {
				return ALMOST_CLOSED;
			}

			@Override
			public State open() {
				return HALFWAY_OPEN;
			}

			@Override
			public String print() {
				return "2";
			}
		},
		ALMOST_CLOSED {
			@Override
			public State close() {
				return CLOSED;
			}

			@Override
			public State open() {
				return HALFWAY_CLOSED;
			}

			@Override
			public String print() {
				return "1";
			}
		},
		CLOSED {
			@Override
			public State close() {
				return this;
			}

			@Override
			public State open() {
				return ALMOST_CLOSED;
			}

			@Override
			public String print() {
				return "0";
			}
		};

		public abstract State close();

		public abstract State open();

		public abstract String print();

		public State nextState(Direction direction) {
			if (direction == Direction.OPENING) {
				return open();
			} else {
				return close();
			}
		}
	}

	private enum Direction {
		CLOSING {
			@Override
			public Direction changeDirection() {
				return OPENING;
			}
		},
		OPENING {
			@Override
			public Direction changeDirection() {
				return CLOSING;
			}
		};

		public abstract Direction changeDirection();
	}

	private static State state = State.CLOSED;
	private static Direction direction = Direction.CLOSING;
	private static boolean pause = true;

	public static String run(String events) {
		reset();
		if (events.length() == 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		for (String event : events.split("")) {
			if (buttonPressed(event)) {
				if (state == State.CLOSED || state == State.OPEN) {
					direction = direction.changeDirection();
					pause = false;
				} else {
					pause = !pause;
				}
			} else if (obstacleDetected(event)) {
				direction = direction.changeDirection();
			}
			state = pause ? state : state.nextState(direction);
			builder.append(state.print());
		}
		return builder.toString();
	}

	private static void reset() {
		state = State.CLOSED;
		direction = Direction.CLOSING;
		pause = true;
	}

	private static boolean obstacleDetected(String event) {
		return "O".equals(event);
	}

	private static boolean buttonPressed(String event) {
		return "P".equals(event);
	}
}
