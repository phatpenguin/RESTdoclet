package com.iggroup.oss.sample.web.controller.test;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iggroup.oss.sample.domain.Sample;
import com.iggroup.oss.sample.domain.test.BarList;
import com.iggroup.oss.sample.domain.test.BarObject;

/**
 * Test controller to allow more exotic controller behaviour to be validated
 */
@Component
@Controller("testController")
public class TestController implements TestInterface {

	/**
	 * Test recursive response types
	 * 
	 *  This is a
	 *          multiline comment with
	 * 
	 * 				some funny formatting
	 * 
	 * @return nothing of value
	 */
	@RequestMapping(value = { "/test/base" }, method = { RequestMethod.GET })
	@ResponseBody
	public BarList<BarObject> getBase() {
		return new BarList<BarObject>();
	}

	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = { "/test/interfacedoc" }, method = { RequestMethod.GET })
	@ResponseBody
	@Override
	public Sample testInterfaceDocInheritance(@RequestParam String foo,
			@RequestParam String bar) {

		return null;
	}

	/**
	 * Deprecated URI tester
	 * 
	 * @param request the http request
	 * @param dealId the dealId of the position to look up#
	 * @return the full detailed ticket information set for the given working
	 *         order
	 * @throws Exception in case of any server error
	 * @uriDeprecated {"/test/markets/details/positions/{dealId}",
	 *                "/test/marketdata/otc/{dealId:^[^\\.]+$}",
	 *                "/test/markets/details/position/{dealId}"}
	 * @deprecated use MarketDataV2Controller.openPositionData instead. URI :
	 *             /v2/markets/details/positions/{dealId}
	 */
	@Deprecated
	@RequestMapping(value = { "/test/markets/details/positions/{dealId}",
			"/test/markets/details/position/{dealId}",
	"/test/marketdata/otc/{dealId:^[^\\.]+$}" }, method = { RequestMethod.GET })
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Sample testDeprecated(HttpServletRequest request,
			@PathVariable String dealId) throws Exception {
		return null;
	}

	/**
	 * Test hashMap and list in URI
	 * <ul>
	 * <li><code>X-IG-CLIENT_FLAVOUR</code> - for example <i>CFD</i>. Note this
	 * is provided in upper case whereas other references to the client
	 * application are in lower case.
	 * <li><code>X-IG-CLIENT_VERSION</code> - for example <i>1.24.41</i>
	 * <li><code>X-IG-DEVICE_OS_NAME</code> - for example <i>Blackberry_OS</i>
	 * <li><code>X-IG-DEVICE_OS_VERSION</code> - for example <i>4.6.0.92</i>
	 * <li><code>X-IG-DEVICE_MANUFACTURER</code> - for example <i>Research In
	 * Motion</i>
	 * <li><code>X-IG-DEVICE_MODEL</code> - for example <i>9000</i>
	 * <li><code>X-IG-DEVICE_LOCALE</code> - for example <i>en-GB</i>
	 * <li><code>X-IG-DEVICE_CARRIER</code> - for example <i>Default 3G
	 * Network</i>
	 * </ul>
	 * 
	 * @return test hashmap
	 * @uriDeprecated {"/test/deprecated"}
	 */
	@RequestMapping(value = { "/test/map", "/test/deprecated" }, method = { RequestMethod.GET })
	@ResponseBody
	public HashMap<String, Sample> testMap() {

		return null;
	}

}