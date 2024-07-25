package com.dekankilic.performance;

import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest
@QuickPerfTest
@Import({ PerformanceApplicationConfuguration.class, QuickPerfSqlConfig.class})
public @interface UseCaseTest {
}
