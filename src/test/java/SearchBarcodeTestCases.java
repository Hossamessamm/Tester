import Data.Urls;
//import io.qameta.allure.Description;
//import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.HttpUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.AssertionUtils.assertStatusCode;
import static utils.AssertionUtils.assertValue;
import static utils.utils.getDataFromJson;

public class SearchBarcodeTestCases {

    @Test
    public void ValidSearchData() {
    Response response = HttpUtils.getRequestWithSerial(Urls.Getbarcodedata,getDataFromJson("ValidbarcodeSerial"));
    response.prettyPrint();
    assertStatusCode(response,200);
    assertValue(response,"data.barCode",getDataFromJson("ValidbarcodeSerial"));
    }
    @Test
    public void InValidSearchData() {
        Response response = HttpUtils.getRequestWithSerial(Urls.Getbarcodedata,getDataFromJson("InvalidbarcodeSerial"));
        response.prettyPrint();
        assertStatusCode(response,404);
        assertValue(response,"error","Barcode not found");
    }
    @Test
    public void EmptyData() {
        Response response = HttpUtils.getRequestWithSerial(Urls.Getbarcodedata,getDataFromJson("EmptyData"));
        response.prettyPrint();
        assertStatusCode(response,400);
        assertThat(response.jsonPath().getString("data.error")).contains("Serial number must be at least 5 characters long");

    }
    @Test
    public void ShortLengthSerial() {
        Response response = HttpUtils.getRequestWithSerial(Urls.Getbarcodedata,getDataFromJson("ShortLengthSerial"));
        response.prettyPrint();
        assertStatusCode(response,400);
        assertThat(response.jsonPath().getString("data.error")).contains("Serial number must be at least 5 characters long");
    }


}
