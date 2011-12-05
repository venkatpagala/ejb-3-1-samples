package com.sample.ejb3.singleton.simple;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

import com.sample.ejb3.Constants;
import com.sample.ejb3.session.exception.ResourceNotFoundAppException;

@Singleton
@Startup
@Remote(MyCacheBusinessRemote.class)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MyCacheCommonBase implements MyCacheBusinessRemote {

	private static Logger LOGGER = Logger.getLogger(MyCacheCommonBase.class);

	private List<String> resources = new ArrayList<String>();

	@Override
	@Lock(LockType.READ)
	@SuppressWarnings("unchecked")
	public String getResource(Integer index) {
		String retValue = "";

		if (index < 1 || index > resources.size())
			throw new ResourceNotFoundAppException(
					Constants.MSG_ERROR_INDEX_OUT_OF_BOUND);
		retValue = new String(resources.get(index - 1));

		LOGGER.info("SERVER - read value at " + index + " as " + retValue);

		return new String(resources.get(index - 1));
	}

	@Override
	@Lock(LockType.WRITE)
	@SuppressWarnings("unchecked")
	public String updateResource(Integer position, String value) {
		LOGGER.info("SERVER - update value at " + position + " to " + value);
		String retValue = "";
		if (position == -1) {
			resources.add(value);
		} else {
			retValue = resources.set(position - 1, value);
		}

		LOGGER.info("SERVER - value updated");

		return retValue;

	}

	@PostConstruct
	public void refresh() {
		resources.add("FirstValue");
	}

	@Override
	@Lock(LockType.READ)
	@SuppressWarnings("unchecked")
	public List<String> getList() {

		LOGGER.info("SERVER - Get list of resources. Count = "
				+ resources.size());

		return copyOf(resources);
	}

	@SuppressWarnings("unchecked")
	private List<String> copyOf(List<String> resources2) {
		List<String> clonedList = new ArrayList<String>();
		for (String origValue : resources2) {
			clonedList.add(new String(origValue));
		}

		return clonedList;
	}

}
