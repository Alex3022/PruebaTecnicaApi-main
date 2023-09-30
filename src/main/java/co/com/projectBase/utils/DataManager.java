package co.com.projectBase.utils;


import co.com.projectBase.model.*;

public class DataManager {

    public static BodyEmpleado getDataEmpleado(){
        return BodyEmpleado.builder().name("Alexandra").salary("$5000").age("25").build();
    }

    public static ResponseDataEmpleado getDataResponseEmpleado() {
        return ResponseDataEmpleado.builder()
                .status("success")
                .data(Data.builder().name("Alexandra").salary("$5000").age("25").build())
                .message("Successfully! Record has been updated.")
                .build();
    }
    public static DeleteResponseData getDataResponseDelete (){
        return DeleteResponseData.builder()
                .status("success")
                .message("Successfully! Record has been deleted")
                .build();
    }

    public static ResponseGetId getResponseGetId (){
        return ResponseGetId.builder()
                .status("success")
                .data(ResponseDataId.builder().id(1).employeeName("Tiger Nixon").employeeSalary(320800).employeeAge(61).profileImage("").build())
                .message("Successfully! Record has been fetched.").build();

    }

    public static ResponseGetAll getResponseGetAll (){
        return ResponseGetAll.builder()
                .status("success")
                .message("Successfully! Record has been fetched.").build();

    }
}
