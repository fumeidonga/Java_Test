package test_java.test.annotation;

@TargetClassClass(uri = "123")
public class Person {

	@TargetConstructor(value="987")
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("person");
	}

	public Person(String name) {
		System.out.println("Person " + name);
	}
	
    @TargetField1Name("阿特罗伯斯1")
    private String name;

    @TargetField2Gender(gender = TargetField2Gender.GenderType.Male)
    private String gender;

    @TargetFiedl3Profile(id = 1001, height = 180, nativePlace = "CN")
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
