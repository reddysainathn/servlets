package test;

import beans.User;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello");

		User user = new User("John@caveofprogramming.com", "ewdsdsdeee");

		if (user.validate()) {
			System.out.println("Beans Validate OK.");
		} else {
			System.out.println(user.getMessage());
		}
	}
}
