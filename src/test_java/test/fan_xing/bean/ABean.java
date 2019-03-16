package test_java.test.fan_xing.bean;

import test_java.test.fan_xing.FanXingClass;

public class ABean extends FanXingClass<CBean, BBean>{

	public ABean(){
		System.out.println("A()");
	}
	
	public ABean(CBean t, BBean v) {
		super(t, v);
		System.out.println("A(t, v)");
	}
	
	public <T> T getT(T t, T v){
		return v;
	}

    public static class Builder<T, V> {

        protected int mGravity = -1;
        protected V v;

        public T setmGravity(int mGravity) {
            this.mGravity = mGravity;
            return self();
        }
        
        public T setV(V v){
        	this.v = v;
        	return self();
        }


        private T self() {
            return (T) this;
        }

        public V build() {
            return v;
        }
    }
}
