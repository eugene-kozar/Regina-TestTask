package com.csvcounter.spring.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.csvcounter.spring.dao.MyDataDAO;
import com.csvcounter.spring.domain.MyData;
import com.csvcounter.spring.model.CompanyQuotes;
import com.csvcounter.spring.service.CSVExternalDataService;
import com.csvcounter.spring.service.MyDataService;
import com.csvcounter.spring.test.util.CompanyQuotesBuilder;

public class SaveDataTest extends AbstractTest<Serializable> {

	@Autowired
	private MyDataDAO myDataDAO;
	@Autowired
	private MyDataService myDataService;

	@Test
	public void saveMyDataTest() {
		MyData myData = new MyData();
		myData.setId(2000);
		myData.setData("Some data");
		myDataDAO.saveOrUpdate(myData);
		List<MyData> myDataList = myDataService.readData();
		assertEquals("Some data", myDataList.get(myDataList.size()-1).getData());
	}

	@Test
	public void concurrentTest() throws Exception {
		final List<CompanyQuotes> quotesListDummy = getMockedDataFromService();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 50; j++) {
						System.out.println("Thread:" + index + " Function:" + j);
						for (CompanyQuotes companyQuotes : quotesListDummy) {
							myDataService.saveRow(companyQuotes);
						}
					}
				}
			});
		}
		executor.shutdown();
		while (!executor.isTerminated()) {}
		System.out.println("Finished all threads");
		List<MyData> myDataList = myDataService.readData();
		assertEquals(1500, myDataList.size());
		for (int i = 0; i < myDataList.size(); i++) {
			int actualIndex = myDataList.get(i).getId();
			assertEquals(i, actualIndex);
		}

	}

	private List<CompanyQuotes> getMockedDataFromService() {
		List<CompanyQuotes> quotesListDummy = CompanyQuotesBuilder.createQuotes();
		CSVExternalDataService mock = createMock(CSVExternalDataService.class);
		expect(mock.readDataFromURL()).andReturn(quotesListDummy);
		replay(mock);		 
		List<CompanyQuotes> quotesList = mock.readDataFromURL();
		return quotesList;
	}

}
