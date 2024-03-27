/*
 * Copyright 2024, FMR LLC.
 * All Rights Reserved.
 * Fidelity Confidential Information
 */
package reflect.bean;

/**
 * Add Java-doc for User
 *
 * @author a700971
 */
public class User
{
	private int age = 10;
	private String name = "CZ";

	public User()
	{
	}

	public User(final String name)
	{
		this.name = name;
	}

	private User(final int age, final String name)
	{
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "User{" +
				"age=" + age +
				", name='" + name + '\'' +
				'}';
	}
}
