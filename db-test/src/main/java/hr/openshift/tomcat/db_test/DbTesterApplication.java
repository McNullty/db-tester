/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package hr.openshift.tomcat.db_test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Component(value = "dbTesterApplication")
@Scope(value = "prototype")
public class DbTesterApplication extends Application
{
    private Window window;

    @Override
    public void init()
    {
        window = new Window("Vaadin DB Tester");
        window.setSizeFull();
        setMainWindow(window);
        setTheme("runo");
        
        Panel panel = new MainPanel();
        window.addComponent(panel);
        
    }
    
}
