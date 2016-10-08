var bodyOverFlow;
var submitLock = false;
//lock submit if ajax calling is ongoing
$(document).ajaxStart(function () {
    submitLock = true;
    // disable screen when ajax request is in progress
    bodyOverFlow = $('body').css("overflow");
    $('body').css("overflow","hidden");
    $("#ajaxLoadCover").show();
}).ajaxStop(function () {
    submitLock = false;
    // recover screen functionality after ajax stops
    $('body').css("overflow", bodyOverFlow);
    $("#ajaxLoadCover").hide();
});

function newDatePicker(dateFieldId) {

    $("#" + dateFieldId).datepicker({
        dateFormat: "yy-mm-dd",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showWeek: true,
        buttonImageOnly: true,
        beforeShow: function (input) {
            setTimeout(function () {
                var clearButton = $(input)
                    .datepicker("widget")
                    .find(".ui-datepicker-close");
                clearButton.unbind("click").bind("click", function () {
                    $.datepicker._clearDate(input);
                });
            }, 1);
        }
    });

    if ($("#" + dateFieldId).val() === "") {
        $("#" + dateFieldId).datepicker('refresh');
    }
}

function newDateTimePicker(dateFieldId) {

    $("#" + dateFieldId).datetimepicker({
        dateFormat: "yy-mm-dd",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showWeek: true,
        buttonImageOnly: true,
        timeFormat: 'hh:mm',
        stepHour: 1,
        stepMinute: 1,
        beforeShow: function (input) {
            setTimeout(function () {
                var clearButton = $(input)
                    .datepicker("widget")
                    .find(".ui-datepicker-close");
                clearButton.unbind("click").bind("click", function () {
                    $.datepicker._clearDate(input);
                });
            }, 1);
        }
    });

    if ($("#" + dateFieldId).val() === "") {
        $("#" + dateFieldId).datetimepicker('refresh');
    }
}

function closeDialog(id){
    $("#"+id)[0].dialogObj.close();
}
function resizeDialog(id){
    if($("#"+id)[0] !== undefined){
        $("#"+id)[0].dialogObj.getModalContent().css("top",0);
        $("#"+id)[0].dialogObj.getModalDialog().css("top",(document.documentElement.clientHeight-$("#"+id)[0].dialogObj.getModalDialog().height())/2);
    }
};
function addDialog(divId,title,msg,buttons,size,dialogOnHidden,dialogOnShown,position) {
    var newBootstrapDialog = BootstrapDialog.show({
        title:title,
        type:BootstrapDialog.TYPE_DEFAULT ,
        message: msg,
        animate:false,
        draggable: true,
        autodestroy:true,
        closeByBackdrop: false,
        onshown: function(dialogRef){
            dialogRef.getModalHeader().css("padding",4);
            dialogRef.getModalFooter().css("padding",8);
            dialogRef.getModalDialog().on('mousedown', function(event) {
                var src = event.target || window.event.srcElement;
                if(src.tagName === "INPUT" || src.tagName === "TEXTAREA" || src.tagName === "SELECT" ||src.tagName === "CHECKBOX"||src.tagName === "RADIO"||src.tagName === "BUTTON"){
                    return;
                }
                if(src.tagName === "DIV"){
                    if($(src).css('overflow') !== 'visible') return;
                }

                var dialog = dialogRef;
                dialog.draggableData.isMouseDown = true;
                var dialogOffset = dialog.getModalContent().offset();
                dialog.draggableData.mouseOffset = {
                    top: event.clientY - dialogOffset.top,
                    left: event.clientX - dialogOffset.left
                };
            });
            var offsetHorizontal = 0;
            if(position){
                offsetHorizontal = position;
            }
            if(size){
                dialogRef.getModalDialog().css("width",size[0]);
                dialogRef.getModalContent().css("height",size[1]);
                dialogRef.getModalDialog().css("height",size[1]);
            }
            dialogRef.getModalDialog().css("top",(document.documentElement.clientHeight-dialogRef.getModalDialog().height())/2+offsetHorizontal);

            if(dialogOnShown){
                dialogOnShown();
            }
            if($("#"+divId)[0]){
                $("#"+divId)[0].dialogObj=dialogRef;
            }

        },
        onhidden: function(dialogRef){
            if(dialogOnHidden){
                dialogOnHidden();
            }
        },
        buttons:buttons

    });
    return newBootstrapDialog;
}

function addWindow(divId,title,url,size,dialogOnHidden,dialogOnShown,position){
    var html = $.ajax({
        url: url,
        async: false
    }).responseText;
    var msg=$("<div id="+divId+"></div>").append(html);
    var buttons=[];
    var newBootstrapDialog = addDialog(divId,title,msg,buttons,size,dialogOnHidden,dialogOnShown,position);
    return newBootstrapDialog;
}


function addSubmitConfirm(message,doOkMethod,submit,refresh){
    if (typeof(submit) === "undefined") {
        submit = true;
    }
    if (typeof(refresh) === "undefined") {
        refresh = true;
    }
    var buttons=[{label: "确定",
        cssClass: 'btn-primary',
        action: function(dialogRef){
            if (!submitLock) {
                if (doOkMethod) {
                    doOkMethod();
                }
                if (submit) {
                    submitLock = true;
                }
            }

            if (!refresh) {
                submitLock = false;
                dialogRef.close();
            }
        }},{label: "取消",
        cssClass: 'btn-default',
        action: function(dialogRef){
            dialogRef.close();
        }}
    ];
    var dialog=addDialog("submitConfirmDialog",null,message,buttons,[425],null,null);
    dialog.getModalHeader().hide();
}
function addCloseConfirm(message,windowId){
    var buttons=[{label: "关闭",
        cssClass: 'btn-primary',
        action: function(dialogRef){
            dialogRef.close();
            if (windowId) {
                closeDialog(windowId);
            }
        }},{label: $('#confirmCancelBtn').val(),
        cssClass: 'btn-default',
        action: function(dialogRef){
            dialogRef.close();
        }}
    ];
    var dialog=addDialog("colseConfirmDialog",null,message,buttons,[400],null,null);
    dialog.getModalHeader().hide();
}

function addBackConfirm(message,callback){
    var buttons=[{label: "确定",
        cssClass: 'btn-primary',
        action: function(dialogRef){
            dialogRef.close();
        }}
    ];
    var dialog=addDialog("colseConfirmDialog",null,message,buttons,[400],callback,null);
    dialog.getModalHeader().hide();
}
