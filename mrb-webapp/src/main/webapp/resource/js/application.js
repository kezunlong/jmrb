function SearchPageData(page, container, url) {
    $(container).fadeTo(200, 0.2, function () { });
    $.ajax({
        url: url,
        data: $("form").serialize() + "&page=" + page,
        type: "get",
        success: function (data) {
            $(container).html(data);
        },
        error: function (jqxhr, status, errorMsg) {
            var exception = $("<div>").addClass("error").text("Status: " + status + " Error: " + errorMsg);
            $(container).html(exception);
        },
        complete: function (jqxhr, status) {
            $(container).fadeTo(500, 1, function () { });
        }
    })
}