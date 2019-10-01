package com.pages.portal;

import com.pages.mis.*;
import com.pages.portal.PortalDashboard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

@Component
public interface PortalPage {

    default PortalDashboard portalDashboard() throws IOException {
        return new PortalDashboard();
    }
}
