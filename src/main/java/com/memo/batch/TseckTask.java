package com.memo.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TseckTask {
	
	@Scheduled(cron="* * 3 * * *")
	public void tesktask() {
		// job 내용
	
		
	}
}
