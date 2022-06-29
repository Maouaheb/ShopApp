package AOPfinal;

public aspect ColorBlind {

	pointcut colorblind(boolean h) : execution(void User.setColorblind(boolean))&& args(h);
	after(boolean h) returning() : colorblind(h) {
		System.out.println("aspect color blind");

		User.fileColorblind="../colorBlind.css";
	}
}
