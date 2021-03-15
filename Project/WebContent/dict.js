$(document).ready(function () {
    $("#lookup").click(function(event) {
        var word = $("#term").val();
        document.getElementById("definition").innerHTML = "";
        $.get("/OnlineDictionary/dictServlet", {term: word}, function(responseJson) {
            if (responseJson != null) {
                var i = 1;               
                $.each(responseJson, function(key, value) {
                    $("#definition").append(i + " (" + value['wordtype'] + ") :: " + value['definition'] + "<br>");
                    i++;
                });
            }
        });
    });   
});