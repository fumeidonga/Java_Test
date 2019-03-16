/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test_java.test;

/**
 * Log工具，类似android.util.Log。 tag自动产生，格式:
 * customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 */
public class UtilsLog {

	public static String customTagPrefix = "";
	public final static String TAG = "hrl";

	private UtilsLog() {
	}

	public static boolean allowD = true;
	public static boolean allowE = true;
	public static boolean allowI = true;
	public static boolean allowV = true;
	public static boolean allowW = true;
	public static boolean allowWtf = true;
	
	public static boolean isEmpty(String string){
		if(string == null || string.equals("")){
			return true;
		}
		
		return false;
	}

	private static String generateTag(StackTraceElement caller) {
		String tag = "%s.%s(L:%d)";
		String callerClazzName = caller.getClassName();
		callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
		tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
		tag = isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
		return tag + " ---> ";
	}

	/**
	 * 获取调用当前方法的前5步
	 * @param caller
	 * @return
	 */
	private static String generateTag(StackTraceElement[] caller) {
		String tag = " ";
		String formatString = "%s.%s(L:%d)";
		StringBuilder tempString = new StringBuilder();
		for (int i = 4; i <= 8; i++) {
			StackTraceElement callers = caller[i];
			String callerClazzName = callers.getClassName();
			callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
			tag = String.format(formatString, callerClazzName, callers.getMethodName(), callers.getLineNumber());
			tag = isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
			tempString.append("   " + tag + " \n ");
		}
		return " ----------> \n " + tempString.toString() + " ----------> ";
	}

	public static void d() {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);
		System.out.println(TAG + tag);
	}

	/**
	 * 获取方法调用堆栈
	 * @see #getStackTraceElement()
	 */
	public static void d1() {
		if (!allowD)
			return;
		StackTraceElement[] caller = getStackTraceElement();
		String tag = generateTag(caller);
		System.out.println(TAG + tag);
	}


	public static void d(String content) {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);

		System.out.println(TAG + tag + content);
	}
	
	public static void d(Object content) {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);

		System.out.println(TAG + tag + content);
	}

	public static void d(String content, Throwable tr) {
		if (!allowD)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);

		System.out.println(TAG + tag + content + tr);
	}

	public static void e(Object content) {
		if (!allowE)
			return;
		StackTraceElement caller = getCallerStackTraceElement();
		String tag = generateTag(caller);

		System.out.println(TAG + tag + content);
	}

	public static StackTraceElement getCurrentStackTraceElement() {
		return Thread.currentThread().getStackTrace()[3];
	}

	public static StackTraceElement getCallerStackTraceElement() {
		return Thread.currentThread().getStackTrace()[4];
	}

	/**
	 * 
	 * @return StackTraceElement[]
	 */
	public static StackTraceElement[] getStackTraceElement() {
		return Thread.currentThread().getStackTrace();
	}

}
