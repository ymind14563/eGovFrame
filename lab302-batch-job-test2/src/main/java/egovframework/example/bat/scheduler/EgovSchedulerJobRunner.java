package egovframework.example.bat.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.egovframe.rte.bat.core.launch.support.EgovSchedulerRunner;

/**
 * @author 배치실행개발팀
 * @since 2012. 07.25
 * @version 1.0
 * @see
 *  <pre>
 *      개정이력(Modification Information)
 *
 *  수정일                수정자                 수정내용
 *  ----------   -----------   ---------------------------
 *  2012.07.25   배치실행개발팀       최초 생성
 *  2021.11.18   신용호                 배치실행환경 v4.0 적용
 *  
 *  </pre>
 */

public class EgovSchedulerJobRunner {

	/**
	 * Scheduler를 이용하여 Batch Job을 실행
	 * @param args
	 */
	public static void main(String[] args) {

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
