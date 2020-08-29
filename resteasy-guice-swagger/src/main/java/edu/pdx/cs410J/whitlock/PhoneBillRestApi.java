package edu.pdx.cs410J.whitlock;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Path("PhoneBill")
@Tag(name = "Phone Bill")
@Produces(MediaType.TEXT_PLAIN)
public class PhoneBillRestApi {

  private final Map<String, PhoneBill> phoneBills = new HashMap<>();

  public PhoneBillRestApi() {
    for (int i = 1; i <= 10; i++) {
      addPhoneBill(i);
    }
  }

  private void addPhoneBill(int number) {
    String customer = getCustomer(number);
    PhoneBill bill = new PhoneBill(customer);
    for (int i = 0; i < number; i++) {
      bill.addPhoneCall(new PhoneCall());
    }

    this.phoneBills.put(customer, bill);
  }

  private String getCustomer(int number) {
    return "Customer " + number;
  }

  @GET
  @Path("{customer}/calls")
  @Operation(
    summary = "Returns the phone calls in a customer's phone bill",
    responses = {
      @ApiResponse(responseCode = "200", description =  "The customer was found"),
      @ApiResponse(responseCode = "404", description =  "The customer was not found")
    }
  )
  public Response getCalls(
    @PathParam("customer") @Parameter(description = "The name of the customer") String customer) {
    PhoneBill bill = phoneBills.get(customer);

    if (bill != null) {
      StringWriter sw = new StringWriter();
      PrettyPrinter pretty = new PrettyPrinter(new PrintWriter(sw, true));
      pretty.dump(bill);
      String entity = sw.toString();
      return Response.ok(entity, MediaType.TEXT_PLAIN_TYPE).build();

    } else {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

  }
}
