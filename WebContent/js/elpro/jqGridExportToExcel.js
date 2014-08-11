﻿function ExportJQGridDataToExcel(tableCtrl, excelFilename) {
    //  Export the data from our jqGrid into a (real !) Excel .xlsx file.
    //
    //  We'll build up a (very large?) tab-separated string containing the data to be exported, then POST them 
    //  off to a .ashx handler, which creates the Excel file.

    var allJQGridData = $(tableCtrl).jqGrid('getGridParam', 'data');

    var jqgridRowIDs = $(tableCtrl).getDataIDs();                // Fetch the RowIDs for this grid
    var headerData = $(tableCtrl).getRowData(jqgridRowIDs[0]);   // Fetch the list of "name" values in our colModel

    //  For each visible column in our jqGrid, fetch it's Name, and it's Header-Text value
    var columnNames = new Array();       //  The "name" values from our jqGrid colModel
    var columnHeaders = new Array();     //  The Header-Text, from the jqGrid "colNames" section
    var inx = 0;
    var allColumnNames = $(tableCtrl).jqGrid('getGridParam', 'colNames');

    for (var headerValue in headerData) {
        //  If this column ISN'T hidden, and DOES have a column-name, then we'll export its data to Excel.
        var isColumnHidden = $(tableCtrl).jqGrid("getColProp", headerValue).hidden;
        if (!isColumnHidden && headerValue != null) {
            columnNames.push(headerValue);
            columnHeaders.push(allColumnNames[inx]);
        }
        inx++;
    }

    //  We now need to build up a (potentially very long) tab-separated string containing all of the data (and a header row)
    //  which we'll want to export to Excel.

    //  First, let's append the header row...
    var excelData = '';
    for (var k = 0; k < columnNames.length; k++) {
        excelData += columnHeaders[k] + "\t";
    }
    excelData = removeLastChar(excelData) + "\r\n";

    //  ..then each row of data to be exported.
    var cellValue = '';
    for (i = 0; i < allJQGridData.length; i++) {

        var data = allJQGridData[i];

        for (var j = 0; j < columnNames.length; j++) {

            // Fetch one jqGrid cell's data, but make sure it's a string
            cellValue = '' + data[columnNames[j]];

            if (cellValue == null)
                excelData += "\t";
            else {
                if (cellValue.indexOf("a href") > -1) {
                    //  Some of my cells have a jqGrid cell with a formatter in them, making them hyperlinks.
                    //  We don't want to export the "<a href..> </a>" tags to our Excel file, just the cell's text.
                    cellValue = $(cellValue).text();
                }
                //  Make sure we are able to POST data containing apostrophes in it
                cellValue = cellValue.replace(/'/g, "&apos;");

                excelData += cellValue + "\t";
            }
        }
        excelData = removeLastChar(excelData) + "\r\n";
    }

    //  Now, we need to POST our Excel Data to our .ashx file *and* redirect to the .ashx file.
    postAndRedirect("/Helpers/ExportGridToExcel.ashx?filename=" + excelFilename, { excelData: excelData });
}

function removeLastChar(str) {
    //  Remove the last character from a string
    return str.substring(0, str.length - 1);
}

function postAndRedirect(url, postData) {
    //  Redirect to a URL, and POST some data to it.
    //  Taken from:
    //  http://stackoverflow.com/questions/8389646/send-post-data-on-redirect-with-javascript-jquery
    //
    var postFormStr = "<form method='POST' action='" + url + "'>\n";

    for (var key in postData) {
        if (postData.hasOwnProperty(key)) {
            postFormStr += "<input type='hidden' name='" + key + "' value='" + postData[key] + "'></input>";
        }
    }

    postFormStr += "</form>";

    var formElement = $(postFormStr);

    $('body').append(formElement);
    $(formElement).submit();
}

