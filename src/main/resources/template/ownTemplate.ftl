package ${sourceClassPackageName};

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
import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
<#list importPackageList as importPackage>
import ${importPackage};
</#list>

/**
 * ${className}的测试类
 *
 * @author ${author}
 * @date ${date}
 */
@RunWith(PowerMockRunner.class)
public class ${className}Test extends PowerMockTestCase {

    @InjectMocks
    private ${canonicalText} ${testClassMemberName};

    <#list fields as field>
    <#if field.shouldBeMocked>
    @Mock
    </#if>
    private ${field.type} ${field.classMemberName};

    </#list>

    <#list methods as method>
    @Test
    public void test${method.methodName}() throws Exception {

       // Setup prepare when the return ...
        <#list method.setUpList as setUp>
        when(${setUp.when}).thenReturn(${setUp.thenReturn});

        </#list>
       // Run the test.
       ${testClassMemberName}.${method.methodNameNormal}(<#list method.methodParams as methodParamStruct>${methodParamStruct.methodParam}<#if methodParamStruct.endFlag>,</#if></#list>);

       // Verify the results actually we don't do that.

    }

    </#list>
}