/*******************************************************************************
 * * Copyright 2018 T Mobile, Inc. or its affiliates. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  * use this file except in compliance with the License.  You may obtain a copy
 *  * of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  * License for the specific language governing permissions and limitations under
 *  * the License.
 ******************************************************************************/
package com.tmobile.selenium.sam.action.actions;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.tmobile.selenium.sam.action.types.ActionType;
import com.tmobile.selenium.sam.action.types.NavigateType;

/**
 * The Class Navigate.
 *
 * @author Rob Graff (RGraff1)
 */
public class Navigate extends Action implements IAction {

	/** The nav type. */
	private NavigateType navType;

	/**
	 * Instantiates a new navigate.
	 *
	 * @param driver the driver
	 * @param navType the nav type
	 * @param params the params
	 */
	public Navigate(WebDriver driver, NavigateType navType, ActionParams params) {
		super(driver, params);
		this.type = ActionType.Navigate;
		this.navType = navType;
		this.preExit = null;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.eqre.auto.sam.action.actions.Action#mainAction()
	 */
	@Override
	public void mainAction() throws Exception {
		try {
			Navigate.class.getDeclaredMethod(navType.name()).invoke(this);
		} catch (InvocationTargetException e) {
			throw (Exception) e.getCause();
		}
	}

	/**
	 * Refresh.
	 */
	private void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * Back.
	 */
	private void back() {
		driver.navigate().back();
	}

	/* (non-Javadoc)
	 * @see com.tmobile.eqre.auto.sam.action.actions.Action#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " navigate["+navType.name()+"]";
	}
}
