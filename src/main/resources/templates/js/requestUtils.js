var requestUtils = {
    showProgress: true,
    showError: true,
    url: 'https://8080-e1a93fea-4369-4d90-b701-80c67c5c874b.ws-us02.gitpod.io/',
//    url: 'http://localhost:8080/',
    doPostFile: function (path, dataItens, callback) {
        loading();
        $.ajax({
            url: requestUtils.url + path,
            type: "POST",
            // dataType: 'json',
            headers: { },
            data: dataItens,
            processData: false,
            contentType: false,
            statusCode: {
                201: callback,
                400: function () {
                    if (requestUtils.showError) {

                    }
                },
                500: function (error) {}
            },
        });
    },
};
function loading() {
    if (requestUtils.showProgress) {
        Swal.fire({
            title: 'Processando ...',
            timerProgressBar: true,
            onBeforeOpen: () => {
                Swal.showLoading()
            }
        });
    }
}
