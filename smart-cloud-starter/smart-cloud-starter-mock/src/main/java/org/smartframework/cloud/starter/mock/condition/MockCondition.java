/*
 * Copyright © 2019 collin (1634753825@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartframework.cloud.starter.mock.condition;

import org.smartframework.cloud.starter.configure.constants.SmartConstant;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断mock配置是否生效
 *
 * @author collin
 * @date 2019-04-27
 */
public class MockCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        Boolean mockApi = environment.getProperty(SmartConstant.MOCK_API_CONDITION_PROPERTY, Boolean.class);
        Boolean mockMethod = environment.getProperty(SmartConstant.MOCK_METHOD_CONDITION_PROPERTY, Boolean.class);
        return (mockApi != null && mockApi) || (mockMethod != null && mockMethod);
    }

}