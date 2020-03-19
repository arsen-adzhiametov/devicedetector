package com.test.devicedetector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("show")
public class DeviceDetectorController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceDetectorController.class);

    private static final String MOBILE = "MOBILE";
    private static final String TABLET = "TABLET";
    private static final String DESKTOP = "DESKTOP";

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Device device, HttpServletRequest request) {
        String deviceData=request.getHeader("user-agent");
        if (device.isMobile()) {
            model.addAttribute("message", "Hello mobile user!");
            logger.info(MOBILE + " " + deviceData);
        } else if (device.isTablet()) {
            model.addAttribute("message", "Hello tablet user!");
            logger.info(TABLET + " " + deviceData);
        } else {
            model.addAttribute("message", "Hello desktop user!");
            logger.info(DESKTOP + " " + deviceData);
        }
        model.addAttribute("useragent", deviceData);
		return "hello";
	}
}