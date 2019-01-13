package com.bdogg.herotracker.dao;

import com.bdogg.herotracker.Application;
import com.bdogg.herotracker.model.Address;
import com.bdogg.herotracker.model.Location;
import org.apache.tomcat.jni.Library;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RelationshipsTest {

    @Autowired
    private TestRestTemplate template;

    private static String HERO_ENDPOINT = "http://localhost:8085/heroes/";
    private static String POWER_ENDPOINT = "http://localhost:8085/powers/";
    private static String ADDRESS_ENDPOINT = "http://localhost:8085/addresses/";
    private static String LOCATION_ENDPOINT = "http://localhost:8085/locations/";
    private static String SIGHTING_ENDPOINT = "http://localhost:8085/sightings";

    private static String HERO_NAME = "Sailor Moon";
    private static String POWER_NAME = "The Power of Love";
    private static String LOCATION_NAME = "The Library";
    private static String ADDRESS_STRING = "123 Main Street";

    @Test
    public void whenSaveOneToOneRelationship_thenCorrect() {

        // Save a Location
        Location location = new Location();
        location.setName(LOCATION_NAME);
        template.postForEntity(LOCATION_ENDPOINT, location, Location.class);

        // Save an Address
        Address address = new Address();
        address.setAddress(ADDRESS_STRING);
        template.postForEntity(ADDRESS_ENDPOINT, address, Address.class);

        // Associate the Location with the Address using HTTP-PUT

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");
        HttpEntity<String> httpEntity
                = new HttpEntity<>(ADDRESS_ENDPOINT + "/2", requestHeaders);
        template.exchange(LOCATION_ENDPOINT + "/1/locationAddress",
                HttpMethod.PUT, httpEntity, String.class);

        ResponseEntity<Location> locationGetResponse
                = template.getForEntity(ADDRESS_ENDPOINT + "/2/location", Location.class);
        assertEquals("location is incorrect",
                locationGetResponse.getBody().getName(), LOCATION_NAME);
    }
}
