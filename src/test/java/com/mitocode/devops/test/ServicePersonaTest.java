package com.mitocode.devops.test;

import static io.restassured.RestAssured.given;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.github.javafaker.Faker;
import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.mitocode.devops.model.Persona;

/**
 * Pruebas unitarias de servicios de Personas
 * @author Roman Albarracin
 * @version 1.0.0
*/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServicePersonaTest {
	private static String URL = "http://localhost:8090";
	private static String END_POINT = "/devops/services/persona/";
	WireMockServer wireMockServer;
	
	@Before
    public void setup () {
        wireMockServer = new WireMockServer(8090);
        wireMockServer.start();
        setupStub();
    }
	
	@After
    public void teardown () {
        wireMockServer.stop();
    }
	
	public void setupStub() {
        wireMockServer.stubFor(get(urlEqualTo(END_POINT))
                .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        ));
        wireMockServer.stubFor(post(urlEqualTo(END_POINT))
                .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        ));
        wireMockServer.stubFor(put(urlEqualTo(END_POINT))
                .willReturn(aResponse().withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        ));
    }
	
	@Test
    public void testConsultarPersonas() {
        given().
	        when().
	        	get(URL + END_POINT).
	        then().
	        	assertThat().statusCode(200);
    }
	
	@Test
	public void testCrearPersona() {
		Faker fake = new Faker();
		Persona persona = new Persona();
		persona.setDocumento(fake.number().digits(10));
		persona.setNombres(fake.name().firstName());
		persona.setApellidos(fake.name().lastName());
		persona.setSexo(getRandomSexo());
		persona.setEmail(fake.name().username() + "@domain.com");
		persona.setDireccion(fake.address().streetAddress());
		persona.setTelefono(fake.phoneNumber().phoneNumber());
		given()
			.body(persona)
		.when()
			.post(URL + END_POINT)			
		.then()
			.assertThat().statusCode(200);
	}
	
	@Test
	public void testActualizarPersona() {
		Faker fake = new Faker();
		Persona persona = new Persona();
		persona.setId(1);
		persona.setDocumento(fake.number().digits(10));
		persona.setNombres(fake.name().firstName());
		persona.setApellidos(fake.name().lastName());
		persona.setSexo(getRandomSexo());
		persona.setEmail(fake.name().username() + "@domain.com");
		persona.setDireccion(fake.address().streetAddress());
		persona.setTelefono(fake.phoneNumber().phoneNumber());
		given()
			.body(persona)
		.when()
			.put(URL + END_POINT)			
		.then()
			.assertThat().statusCode(200);
	}

	private String getRandomSexo() {
		String[] arr = {"M", "F"};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        return arr[randomNumber];
	}
}
