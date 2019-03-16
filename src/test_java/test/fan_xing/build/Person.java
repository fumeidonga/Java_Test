package test_java.test.fan_xing.build;


public class Person {
    private String name;
    private String age;
    private String sex;

    protected Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    public static class Builder<T, V> {
        private String name;
        private String age;
        private String sex;
        private V v;

        public Builder(String name) {
            this.name = name;
        }

        public T age(String age) {
            this.age = age;
            return self();
        }

        public T sex(String sex) {
            this.sex = sex;
            return self();
        }
        
        public T setV(V v){
            this.v = v;
            return self();
        	
        }
        
        private T self() {
            return (T) this;
        }

        public Person build() {
            return new Person(this);
        }

        public V build1() {
            return v;
        }
    }
}
