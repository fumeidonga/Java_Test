package test_java.test.test_json;

import org.junit.Test;

import com.google.gson.Gson;

import test_java.test.test_json.benas.AdResponse;
import test_java.test.test_json.benas.HWinfo;
import test_java.test.test_json.benas.InviteCodeResponse;
import test_java.test.test_json.benas.InviteDataBean;
import test_java.test.test_json.benas.InviteDiscipleShareResponse;
import test_java.test.test_json.benas.MyDiscipleResponse;
import test_java.test.test_json.benas.UpdateResponse;
import test_java.test.test_json.benas.UserFragmentResponse;

public class GsonTest {
	
	public static String gson = "{\n" +
			"    \"data\": {\n" +
			"        \"money\": \"0.5\",\n" +
			"        \"vipDays\": 1,\n" +
			"        \"vipEndTime\": 12701,\n" +
			"    \"message\": \"测试内容232y\",\n" +
			"        \"currency\": 12701\n" +
			"		\n" +
			"    },\n" +
			"    \"message\": \"测试内容232y\",\n" +
			"    \"status\": 0\n" +
			"}";
	
	@Test
	public void test(){
		/*InviteCodeResponse re = new Gson().fromJson(gson, InviteCodeResponse.class);
		System.out.println(re);
		InviteDiscipleShareResponse red = new Gson().fromJson(gson1, InviteDiscipleShareResponse.class);
		System.out.println(red.getStatus());*/
		
		MyDiscipleResponse red1 = new Gson().fromJson(gson2, MyDiscipleResponse.class);
//		System.out.println(red1);
		
//		AdResponse adResponse = new Gson().fromJson(gsonstring, AdResponse.class);
//		System.out.println(adResponse);
		
		HWinfo info  = new Gson().fromJson(gsonstring2, HWinfo.class);
		//System.out.println(info);
		

		InviteDataBean info1  = new Gson().fromJson(gson111, InviteDataBean.class);
		//System.out.println(info1);

//		InviteDataBean info2  = new Gson().fromJson(test0, UserFragmentResponse.class);
//		System.out.println(info2);

		UpdateResponse updateResponse = new Gson().fromJson(update, UpdateResponse.class);
		System.out.println(updateResponse);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static String update = "{    \"appkey\": \"test\",    \"channel\": \"test\",    \"downurl\": \"edd\",    \"filename\": \"freer.apk\",    \"filesize\": \"10014583\",    \"md5\": \"11112ec86a82870ed7e7fcb425038ca2\",    \"need_update\": \"\",    \"packname\": \"com.kmxs.reader\",    \"updatelog\": \"test\",    \"updatetype\": \"update\",    \"user_version\": \"1.1\",    \"version\": \"10100\",    \"upgrade_interval\":[\"1\", \"2\"]}";
	
	
	
	
	public static String gson2 = "{\n" +
			"    \"data\": {\n" +
			"        \"apprentice_list\": [\n" +
			"            {\n" +
			"                \"count_contribution\": \"测试内容pl4r\",\n" +
			"                \"phone\": \"测试内容w87t\",\n" +
			"                \"user_image\": \"测试内容y147\",\n" +
			"                \"user_name\": \"测试内容u9s0\",\n" +
			"                \"user_passid\": \"测试内容9c1p\"\n" +
			"            }\n" +
			"        ],\n" +
			"        \"apprentice_num\": 74841,\n" +
			"        \"apprentice_page_count\": 27532\n" +
			"    },\n" +
			"    \"message\": \"测试内容w265\",\n" +
			"    \"status\": 86112\n" +
			"}";
	
	public static String gson1 = "{\n" +
			"    \"data\": {\n" +
			"        \"has_open\": 57108,\n" +
			"        \"introduction\": {\n" +
			"            \"inactivated_share\": {\n" +
			"                \"share_content\": \"测试内容1i64\",\n" +
			"                \"share_title\": \"测试内容x403\",\n" +
			"                \"share_url\": \"测试内容7xl4\"\n" +
			"            },\n" +
			"            \"share_type\": 57255\n" +
			"        },\n" +
			"        \"invite_friends\": {\n" +
			"            \"detail_rulesurl\": \"测试内容6u34\",\n" +
			"            \"inactivated_list\": [\n" +
			"                {\n" +
			"                    \"red_envelope_id\": \"测试内容5e01\",\n" +
			"                    \"red_envelope_money\": \"测试内容u3t4\",\n" +
			"                    \"user_image\": \"测试内容m56q\",\n" +
			"                    \"user_name\": \"测试内容nm7p\",\n" +
			"                    \"withdraw_type\": 80688\n" +
			"                }\n" +
			"            ],\n" +
			"            \"income_details\": [\n" +
			"                {\n" +
			"                    \"red_envelope_money\": \"测试内容55sm\",\n" +
			"                    \"user_image\": \"测试内容o5h8\",\n" +
			"                    \"user_name\": \"测试内容u67t\",\n" +
			"                    \"withdraw_type\": 74643\n" +
			"                }\n" +
			"            ],\n" +
			"            \"invite_code\": \"测试内容oj62\",\n" +
			"            \"invite_codedescurl\": \"测试内容10j8\",\n" +
			"            \"invite_data\": {\n" +
			"                \"share_list\": [\n" +
			"                    {\n" +
			"                        \"qrcode_url\": \"测试内容6o4r\",\n" +
			"                        \"share_content\": \"测试内容53w5\",\n" +
			"                        \"share_title\": \"测试内容2de4\",\n" +
			"                        \"share_url\": \"测试内容y916\",\n" +
			"                        \"show_title\": \"测试内容x2v9\",\n" +
			"                        \"type\": 75804\n" +
			"                    }\n" +
			"                ],\n" +
			"                \"share_type\": 42468\n" +
			"            },\n" +
			"            \"marqueeview_data\": [\n" +
			"                {\n" +
			"                    \"red_envelope_money\": \"测试内容j679\",\n" +
			"                    \"user_image\": \"测试内容2fg1\",\n" +
			"                    \"user_name\": \"测试内容m135\",\n" +
			"                    \"withdraw_type\": 52330\n" +
			"                }\n" +
			"            ],\n" +
			"            \"step\": 17547\n" +
			"        }\n" +
			"    },\n" +
			"    \"status\": 36314\n" +
			"}";
	
	public static String gsonstring = "{\"data\": [{\"frequency\": 10,\"id\": \"\",\"image_url\": \"https://book.km.com/bookimg/public/uploads/other/20171024152018.jpg\",\"link\": \"https://s.click.taobao.com/jXY5BZw\",\"offline\": 1522400058,\"online\": 1521881651,\"showtime\": 5,\"statistics\": \"abc\",\"type\": 1},{\"frequency\": -1,\"id\": \"\",\"image_url\": \"https://book.km.com/bookimg/public/uploads/other/3.jpg\",\"link\": \"reader://download?url=https%3A%2F%2Fdownload.km.com%2Fbook%2Fyytj%2Fxiguashipin.apk&filename=aaa&pkg=bbbb&notify_url=https%3A%2F%2Fyuedu.km.com%2Fapi%2Fstat%2Fscreen%2Fdownloads%3Fapp%3Daaa%26sign%3D2025a0246f80581bd2f94d575e59f1da\",\"offline\": 1521786424,\"online\": 1521613626,\"showtime\": 15,\"statistics\": \"123123\",\"type\": 1}],\"modified\": 0,\"status\": 1}";

	
	public static String gsonstring2 ="{\"amount\":\"1.00\",\"applicationID\":\"100040861\",\"country\":\"CN\",\"currency\":\"CNY\",\"extReserved\":\"\",\"merchantId\":\"890086000102053751\",\"merchantName\":\"\\u68a7\\u6850\\u9605\\u8bfb\",\"productDesc\":\"\\u6850\\u5e01100\\u4e2a\",\"productName\":\"\\u6850\\u5e01\",\"requestId\":\"WTZW_20180403164739756856\",\"sdkChannel\":\"1\",\"serviceCatalog\":\"X5\",\"sign\":\"c10nJHNa%2Fv0YqC1hXwOiKk%2FloHiwTvp5qRE23VxdnY1ckibZaeNkk%2F6DFfaHy6hPlxykP%2BrzWW5e8shPHKDs6xsOS25LTKaVfj8%2FJNuHtLndTBSYiKKUXVC3feeMhxQUwLMiKpxTamsejE%2BatHUZlubDmTd%2BRUi75arVwDf3M%2FFrcEr6rVPh4e3YFS3fYsEf%2F7e%2FEbKU5JUDyjez0xZ3hDLrvv1u5EK8Hi4B5%2Ba52of8tsPbE5mGPkP%2Bzf1c%2Fk9iLwg4IMH2PojlmkuiCJaMjGN7ZRaPVMgNYuZZbfDhTMV1wIupHVbapncMVBktpjoymlsgJCiXP%2BQwePfauPx04A%3D%3D\",\"urlVer\":\"2\"}";


	public static String test0 = "{    \"data\": {    \"banners\": [            {                \"id\": \"1\",                \"image_url\": \"http://a.hiphotos.baidu.com/image/pic/item/b64543a98226cffceee78e5eb5014a90f703ea09.jpg\",                \"link_url\": \"https://www.km.com/\",                \"type\": \"o1x7\"            },            {                \"id\": \"1\",                \"image_url\": \"http://f.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c6d203c4c79116fdfaae51670c.jpg\",                \"link_url\": \"https://www.km.com/\",                \"type\": \"o1x7\"            },            {                \"id\": \"1\",                \"image_url\": \"http://c.hiphotos.baidu.com/image/pic/item/b3119313b07eca80275d15039d2397dda04483fd.jpg\",                \"link_url\": \"https://www.km.com/\",                \"type\": \"o1x7\"            }],    \"cash\": \"2610.06\",    \"coin\": \"0\",    \"id\": \"1\",    \"meta\": {        \"banners_show_type\": \"1\"    },    \"title\": \"me\",    \"today_read_duration\": \"0\",    \"type\": \"my_centers\",    \"user_entrances\": [        [            {                \"button_lnk_url\": \"\",                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://invitation_invitefriend\",                \"icon_url\": \"\",                \"id\": \"0\",                \"is_button_click\": \"0\",                \"link_type\": \"3661\",                \"link_url\": \"freereader://invitation_invitefriend?param={url='https://www.km.com'}\",                \"second_title\": \"freereader://invitation_invitefriend\",                \"show_type\": \"2\",                \"statistical_code\": \"1xir\",                \"type\": \"6914\"            }        ],        [            {                \"button_lnk_url\": \"freereader://exchange_one\",                \"button_title\": \"exchange_one\",                \"callback_url\": \"\",                \"first_title\": \"freereader://taskcenter\",                \"icon_url\": \"https://www\",                \"id\": \"1\",                \"is_button_click\": \"0\",                \"link_type\": \"\",                \"link_url\": \"freereader://taskcenter?param={url='https://www.km.com'}\",                \"second_title\": \"freereader://taskcenter\",                \"show_type\": \"3\",                \"statistical_code\": \"\",                \"type\": \"6914\"            }        ],        [             {                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://invitecode\",                \"icon_url\": \"https://www\",                \"id\": \"2\",                \"link_type\": \"\",                \"link_url\": \"freereader://invitecode\",                \"second_title\": \"freereader://invitecode\",                \"show_type\": \"1\",                \"statistical_code\": \"1xir\",                \"type\": \"6914\"            },            {                \"button_title\": \"\",                \"callback_url\": \"8k77\",                \"first_title\": \"freereader://message\",                \"icon_url\": \"https://www\",                \"id\": \"3\",                \"link_type\": \"\",                \"link_url\": \"freereader://message?param={url='https://www.km.com'}\",                \"second_title\": \"\",                \"show_type\": \"1\",                \"statistical_code\": \"\",                \"type\": \"6914\"            },            {                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://myfriend\",                \"icon_url\": \"https://www\",                \"id\": \"4\",                \"link_type\": \"\",                \"link_url\": \"freereader://myfriend\",                \"second_title\": \"\",                \"show_type\": \"1\",                \"statistical_code\": \"1xir\",                \"type\": \"6914\"            },            {                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://mywallet\",                \"icon_url\": \"https://www\",                \"id\": \"5\",                \"link_type\": \"\",                \"link_url\": \"freereader://mywallet?param={url='https://www.km.com'}\",                \"second_title\": \"\",                \"show_type\": \"1\",                \"statistical_code\": \"1xir\",                \"type\": \"6914\"            },            {                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://exchange\",                \"icon_url\": \"https://www\",                \"id\": \"6\",                \"link_type\": \"\",                \"link_url\": \"freereader://exchange?param={url='https://www.km.com'}\",                \"second_title\": \"freereader://exchange\",                \"show_type\": \"1\",                \"statistical_code\": \"1xir\",                \"type\": \"6914\"            }        ],        [           {                \"button_title\": \"\",                \"callback_url\": \"\",                \"first_title\": \"freereader://settings\",                \"icon_url\": \"r5https://www\",                \"id\": \"6\",                \"link_type\": \"\",                \"link_url\": \"freereader://settings\",                \"second_title\": \"\",                \"show_type\": \"1\",                \"statistical_code\": \"\",                \"type\": \"6914\"            }        ]    ]}}";

	public static String gson111 = "{				\"invite_code\": \"KM14428769\",   				\"share_list\": [					{						\"title\": \"免费电子书，热门小说应有尽有，小说阅读就用阅读王\",						\"qrcode_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"link\": \"http://www.kmpage.cn/?invitecode=KM14428769\",						\"desc\": \"这里有最热的男频小说，由最宠的女频小说，由凡人成圣，有霸道总裁。\",						\"type\": \"TEXT\",						\"img_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"thumbimage\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"callback\": \"\",						\"share_title\": \"微信好友\",						\"share_path\": 0					},					{						\"title\": \"免费电子书，热门小说应有尽有，小说阅读就用阅读王\",						\"qrcode_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"link\": \"http://www.kmpage.cn/?invitecode=KM14428769\",						\"desc\": \"这里有最热的男频小说，由最宠的女频小说，由凡人成圣，有霸道总裁。\",						\"type\": \"LINK\",						\"img_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"thumbimage\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"callback\": \"\",						\"share_title\": \"微信朋友圈\",						\"share_path\": 1					},					{						\"title\": \"免费电子书，热门小说应有尽有，小说阅读就用阅读王\",						\"qrcode_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"link\": \"http://www.kmpage.cn/?invitecode=KM14428769\",						\"desc\": \"这里有最热的男频小说，由最宠的女频小说，由凡人成圣，有霸道总裁。\",						\"type\": \"IMAGEURL\",						\"img_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"thumbimage\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"callback\": \"\",						\"share_title\": \"二维码\",						\"share_path\": 2					},					{						\"title\": \"免费电子书，热门小说应有尽有，小说阅读就用阅读王\",						\"qrcode_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"link\": \"http://www.kmpage.cn/?invitecode=KM14428769\",						\"desc\": \"这里有最热的男频小说，由最宠的女频小说，由凡人成圣，有霸道总裁。\",						\"type\": \"IMAGEURL\",						\"img_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"thumbimage\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"callback\": \"\",						\"share_title\": \"QQ\",						\"share_path\": 3					},					{						\"title\": \"免费电子书，热门小说应有尽有，小说阅读就用阅读王\",						\"qrcode_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"link\": \"http://www.kmpage.cn/?invitecode=KM14428769\",						\"desc\": \"这里有最热的男频小说，由最宠的女频小说，由凡人成圣，有霸道总裁。\",						\"type\": \"TEXT_AND_IMAGE\",						\"img_url\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"thumbimage\": \"http://a.app.qq.com/o/simple.jsp?pkgname=com.book2345.reader\",						\"callback\": \"\",						\"share_title\": \"QQ空间\",						\"share_path\": 4					}				]			}";
}
