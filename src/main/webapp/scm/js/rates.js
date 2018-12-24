window.onload = function buildRatesTable() {
    $.ajax({
        type: 'GET',
        url : '/getRates',
        dataType: 'json',
        mimeType: 'application/json',
        success: function (data) {
            buildTable(data);
        }
    });
}

function buildTable(rates) {
    if (rates.length < 1){
        return;
    }
    var mainBlock = document.getElementById('rate_table');
    var rows = '';
    for (var i = 0; i < rates.length; i++) {
        var rate = rates[i];
        var className = '';
        if (i != rates.length - 1) {
            className = '';
        } else {
            className = ' scm-rates-last-cell';
        }
        rows += '<tr>' +
            '<td class="scm-rates-cell-right-border' + className + '">' + rate.deliveryMethod + '</td>' +
            '<td class="scm-rates-cell-right-border' + className + '">' + rate.ratePrice + '</td>' +
            '<td class="scm-rates-cell-right-border' + className + '">' + rate.averageSpeed + '</td>' +
            '<td class="scm-rates-cell-right-border' + className + '"><a href="/carrier/editRate/' + rate.rateId + '">' + 'Изменить' + '</a></td>' +
            '<td class="' + className + '"><a href="/carrier/removeRate/' + rate.rateId + '">' + 'Удалить' + '</a></td>' +
            '</tr>';
    }
    mainBlock.innerHTML = '<div class="scm-profile-form-row">' +
        '<table class="scm-rates-table">' +
            '<tr>' +
                '<th class="scm-rates-cell-right-border">Тип доставки</th>' +
                '<th class="scm-rates-cell-right-border">Тариф, BYN</th>' +
                '<th class="scm-rates-cell-right-border">Средняя скорость, км/ч</th>' +
                '<th class="scm-rates-cell-right-border">Изменение</th>' +
                '<th class="scm-rates-cell">Удаление</th>' +
            '</tr>' +
            rows +
        '</table>' +
        '</div>';
}