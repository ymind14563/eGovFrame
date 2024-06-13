package com.springboot.main;

import java.util.ArrayList;
import java.util.List;

import org.egovframe.rte.bat.core.launch.support.EgovSchedulerRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 배치실행개발팀
 * @since 2021. 11.25
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *  수정일               수정자                 수정내용
 *  ----------   -----------   ---------------------------
 *  2021.11.25   신용호                 최초 생성
 *  
 *  </pre>
 */

public class EgovBootApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovBootApplication.class);

	public static void main(String[] args) {
		//SpringApplication.run(EgovBootApplication.class, args);

		System.out.println("##### EgovSampleBootApplication Start #####");

		SpringApplication springApplication = new SpringApplication(EgovBootApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.setHeadless(false);
		springApplication.setBannerMode(Banner.Mode.CONSOLE);
		springApplication.run(args);
		
		System.out.println("##### EgovSampleBootApplication End #####");
	}
	
	@Override
    public void run(String... args) throws Exception {
		
		List<String> jobPaths = new ArrayList<String>();

		/*
		 * 1. SAM 실행 예제(File To File)에서 사용 할 Batch Job이 기술 된 xml파일 경로들((jobPaths)
		 */
		jobPaths.add("/egovframework/batch/job/delimitedToDelimitedJob.xml");
		jobPaths.add("/egovframework/batch/job/fixedLengthToFixedLengthJob.xml");

		/*
		 * 2. SAM 실행 예제(File To DB)에서 사용 할 Batch Job이 기술 된 xml파일 경로들((jobPaths)
		 */
		jobPaths.add("/egovframework/batch/job/fixedLengthToMybatisJob.xml");
		jobPaths.add("/egovframework/batch/job/fixedLengthToJdbcJob.xml");

		/*
		 * EgovSchedulerRunner에 contextPath, schedulerJobPath, jobPaths를 인수로 넘겨서 실행한다.
		 * contextPath: Batch Job 실행에 필요한 context 정보가 기술된 xml파일 경로
		 * schedulerJobPath: Scheduler의 Trigger가 수행할 SchedulerJob(ex: QuartzJob)이 기술된 xml파일 경로
		 * jobPaths: Batch Job이 기술 된 xml 파일 경로들
		 * delayTime: Scheduler 실행을 위해 ApplicationContext를 종료를 지연시키는 시간(실행시간)
		 *            (기본 30000 milliseconds: 30초)
		 */
		EgovSchedulerRunner egovSchedulerRunner = new EgovSchedulerRunner("/egovframework/batch/context-batch-scheduler.xml", "/egovframework/batch/context-scheduler-job.xml",
				jobPaths, 30000);
		egovSchedulerRunner.start();
		
    }

}
