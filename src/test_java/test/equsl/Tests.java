package test_java.test.equsl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import test_java.test.equsl.bean.Name;
import test_java.test.equsl.bean.UserFragmentEntity;
import test_java.test.equsl.bean.UserFragmentEntity.Meta;
import test_java.test.equsl.bean.UserFragmentEntity.Panel;
import test_java.test.equsl.bean.UserFragmentEntity.UserEntrances;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		int j = 2;
		if(i == 1) {
			System.out.println("i == 1");
		}else if(j == 2) {
			System.out.println("j == 2");
			
		}
	}
	
	@Test
	public void testq(){
		List<Name> nameList1 = new ArrayList<>();
		List<Name> nameList2 = new ArrayList<>();

		nameList1.add(new Name("1", "2"));
		nameList2.add(new Name("1", "2"));
		System.out.println(nameList1.equals(nameList2));
	}
	
	@Test
	public void testt(){
		UserFragmentEntity user1 = getf();
		
		UserFragmentEntity user2 = getf();
		
		
		System.out.println(user1.equals(user2));
	}
	
	private UserFragmentEntity getf(){

		UserFragmentEntity user1 = new UserFragmentEntity();
		user1.setCash("1.00");
		user1.setCoin("100");
		user1.setId("id");
		user1.setTitle("我的");
		user1.setToday_read_duration("130");
		user1.setType("个人中心资源");
		Meta meta = new Meta();
		meta.setBanners_show_type("1");
		user1.setMeta(meta);
		List<Panel> panels = new ArrayList();
		for (int j = 0; j < 3; j++) {
			Panel panel = new Panel();
			ArrayList<UserEntrances> uslist = new ArrayList();
			for(int i = 0; i < 2; i++) {
				UserEntrances us = new UserEntrances();
				us.setButton_lnk_url("" + i + j);
				us.setFirst_title("你");
				us.setIcon_url("" + i + j);
				us.setId("" + i + j);
				us.setIs_button_click(true);
				us.setLink_type("2");
				us.setLink_url("2");
				us.setShow_type("" + i + j);
				us.setType("" + i + j);
				uslist.add(us);
			}
			panel.setList(uslist);
			panels.add(panel);
		}
		user1.setUserEntrances(panels);
		return user1;
	}

}
