package com.day.day.up.main.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import java.util.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.stubbing.Answer;
import org.springframework.beans.BeanUtils;
import com.xhqb.pay.common.util.PayDozerUtil;
import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
import com.day.day.up.main.service.impl.Apple;

/**
 * Apple的测试类
 *
 * @author wf
 * @date 2021-04-16 16:54:02
 */
@PrepareForTest(value = {BeanUtils.class,PayDozerUtil.class})
@RunWith(PowerMockRunner.class)
public class AppleTest extends PowerMockTestCase {

    @InjectMocks
    private Apple apple;


    @Test
    public void testEat() throws Exception {

       // Setup prepare when the return ...
       // Run the test.
       apple.eat();

       // Verify the results actually we don't do that.

    }

    @Test
    public void testEat() throws Exception {

       // Setup prepare when the return ...
       // Run the test.
       apple.eat();

       // Verify the results actually we don't do that.

    }

}