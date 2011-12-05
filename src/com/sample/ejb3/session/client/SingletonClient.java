package com.sample.ejb3.session.client;

import java.util.List;

import javax.naming.InitialContext;

import com.sample.ejb3.Constants;
import com.sample.ejb3.singleton.simple.MyCache;

public class SingletonClient {

	private static InitialContext ctx;
	private static long startTimeMillis;

	public static void main(String[] args) throws Exception {

		ctx = new InitialContext();

		final MyCache simpleCache = (MyCache) ctx
				.lookup(Constants.BUSINESS_REMOTE_CACHE);
		startTimeMillis = System.currentTimeMillis();

		Runnable updater = new Runnable() {

			private String resValueSuffix = "Value--";

			@Override
			public void run() {
				for (int count = 1; count < 6; count++) {
					simpleCache.updateResource(-1, resValueSuffix
							+ (new Double(Math.random()).intValue()));
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		new Thread(updater).start();

		for (int readCounter = 0; readCounter < 10; readCounter++) {
			printList(simpleCache.getList());
		}

	}

	private static void printList(List<String> list) {
		StringBuffer strBuff = new StringBuffer();
		for (String str : list)
			strBuff.append(str);

		System.out.println("CLIENT List: " + strBuff + ".\t time: "
				+ (System.currentTimeMillis() - startTimeMillis));

	}

}
