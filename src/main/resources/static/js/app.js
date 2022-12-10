$('#forgot-pass-btn').on('click', function (e) {
    let email = $('#forgot-pass-input').val();
    $.ajax({
        url: '/reset-password',
        method: 'post',
        data: {'email': email},
        success: function (data) {
            window.location.href = "/thong-bao?type=1";
        }
    })
})
