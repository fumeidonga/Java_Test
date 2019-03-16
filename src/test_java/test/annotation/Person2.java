package test_java.test.annotation;

@TargetClassClass(uri = "Person2")
public class Person2 {

	public Person2() {
		// TODO Auto-generated constructor stub
		System.out.println("person");
	}
	
    @TargetField1Name("Person2")
    private String name;

    @TargetField2Gender(gender = TargetField2Gender.GenderType.Female)
    private String gender;

    @TargetFiedl3Profile(id = 1002, height = 182, nativePlace = "C2N")
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
