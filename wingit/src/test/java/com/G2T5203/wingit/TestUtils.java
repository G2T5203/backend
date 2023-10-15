package com.G2T5203.wingit;

import com.G2T5203.wingit.plane.Plane;
import com.G2T5203.wingit.route.Route;
import com.G2T5203.wingit.routeListing.RouteListing;
import com.G2T5203.wingit.routeListing.RouteListingPk;
import com.G2T5203.wingit.user.WingitUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestUtils {
    private final int port;
    private final BCryptPasswordEncoder encoder;

    public final String ADMIN_USERNAME = "admin";
    public final String ADMIN_PASSWORD = "pass";
    public final String SAMPLE_USERNAME_1 = "brandonDaddy";
    public final String SAMPLE_PASSWORD_1 = "goodpassword";
    public final String SAMPLE_USERNAME_2 = "DaddyChoy";
    public final String SAMPLE_PASSWORD_2 = "password";

    public TestUtils(int port, BCryptPasswordEncoder encoder) {
        this.port = port;
        this.encoder = encoder;
    }

    public URI constructUri(String path) throws URISyntaxException {
        String baseUrl = "http://localhost:";
        return new URI(baseUrl + port + "/" + path);
    }
    // Helper functions
    public WingitUser createSampleUser1() {
        return new WingitUser(
                SAMPLE_USERNAME_1,
                encoder.encode(SAMPLE_PASSWORD_1),
                "ROLE_USER",
                "Brandon",
                "Choy",
                LocalDate.parse("2001-12-04"),
                "brandon.choy.2037@scis.smu.edu.sg",
                "+65 8746 3847",
                "Mr");
    }
    public WingitUser createSampleUser2() {
        return new WingitUser(
                SAMPLE_USERNAME_2,
                encoder.encode(SAMPLE_PASSWORD_2),
                "ROLE_USER",
                "Jared",
                "Hong",
                LocalDate.parse("1996-10-03"),
                "jared.hong.2034@scis.smu.edu.sg",
                "+65 8455 0750",
                "Mrs");
    }
    public WingitUser createAdminUser() {
        return new WingitUser(
                ADMIN_USERNAME,
                encoder.encode(ADMIN_PASSWORD),
                "ROLE_ADMIN",
                "admin",
                "admin",
                LocalDate.parse("2000-01-01"),
                "admin@admin.com",
                "+65 6475 3846",
                "Master");
    }





    public Plane createSamplePlane1() { return new Plane("SQ123", 60, "B777"); }
    public Plane createSamplePlane2() { return new Plane("SQ456", 120, "A350"); }


    public Route createSampleRoute1() {
        return new Route(
                1, // NOTE: It can be overridden as this is generated value.
                "Singapore",
                "Taiwan",
                Duration.ofHours(5).plusMinutes(20));
    }
    public  Route createSampleRoute2() {
        return new Route(
                2, // NOTE: It can be overridden as this is generated value.
                "Taiwan",
                "Singapore",
                Duration.ofHours(7).plusMinutes(10));
    }

    // Create sample RouteListingPks
    public RouteListingPk createSampleRouteListingPk1() {
        Plane samplePlane1 = createSamplePlane1();
        Route sampleRoute1 = createSampleRoute1();
        LocalDateTime sampleLocalDatetime1 = LocalDateTime.parse("2023-12-01T00:00:00");
        return new RouteListingPk(samplePlane1, sampleRoute1, sampleLocalDatetime1);
    }

    public RouteListingPk createSampleRouteListingPk2() {
        Plane samplePlane2 = createSamplePlane2();
        Route sampleRoute2 = createSampleRoute2();
        LocalDateTime sampleLocalDatetime2 = LocalDateTime.parse("2023-12-02T00:00:00");
        return new RouteListingPk(samplePlane2, sampleRoute2, sampleLocalDatetime2);
    }

    // Create sample RouteListings
    public RouteListing createSampleRouteListing1() {
        RouteListingPk sampleRouteListingPk1 = createSampleRouteListingPk1();
        double sampleBasePrice1 = 100.0;
        return new RouteListing(sampleRouteListingPk1, sampleBasePrice1);
    }

    public RouteListing createSampleRouteListing2() {
        RouteListingPk sampleRouteListingPk2 = createSampleRouteListingPk2();
        double sampleBasePrice2 = 200.0;
        return new RouteListing(sampleRouteListingPk2, sampleBasePrice2);
    }
}
