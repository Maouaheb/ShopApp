
package AOPfinal;

public aspect Presbytie {

	pointcut presbytie(boolean h) : execution(void User.setPresbytie(boolean))&& args(h);
	after(boolean h) returning() : presbytie(h) {
		System.out.println("aspect presbytie");
		User.filePresbytie="../PresbytieSize.css";
	}

}
