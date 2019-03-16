package test_java.test.fan_xing.build;

public class Customer extends Person {
    private long phone;
    private String address;
    private String alias;
    private String intro;

    private Customer(Builder builder) {
        super(builder);
        this.phone = builder.phone;
        this.alias = builder.alias;
        this.intro = builder.intro;
    }

    public static class Builder extends Person.Builder<Builder, Customer> {
        private long phone;
        private String address;
        private String alias;
        private String intro;

        public Builder(String name, long phone, String address) {
            super(name);
            this.phone = phone;
            this.address = address;
        }

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder intro(String intro) {
            this.intro = intro;
            return this;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }
    }
}
