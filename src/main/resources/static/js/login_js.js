/**
 * 元素绑定方法
 */
$(document).ready(function () {
    /* 登录 注册*/
    submitFun();
    /* 切换 */
    switcher();
    /*日期选择*/
    selectDate();
    /*下拉选择*/
    getAddressDataAll();
});

/**
 * 日期选择
 */
function selectDate() {
    $("#datetime").datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
}

/**
 * 切换到注册
 */
function goRegister() {
    /* 隐藏登录form*/
    $("#login_frame").hide();
    /* 展示注册form*/
    $("#register_frame").show();
}

/**
 * 切换显示登录div
 */
function goLogin() {
    /* 显示登录*/
    $("#login_frame").show();
    /* 隐藏注册*/
    $("#register_frame").hide();
}
/**
 * 切换
 */
function switcher() {
    /* 切换到注册 */
    $("#go-register-btn").bind("click",function(){
        goRegister();
    });
    /*切换到登录*/
    $("#go-cancel-btn").bind("click",function(){
        goLogin();
    });
}

/**
 * 登录
 */
function doLogin() {
    $("#login-btn").bind("click",function(){
        /* todo */
        console.log("to do login.");
        const userName = $("#user-name").val();
        if (isNullOrEmpty(userName)) {
            toastr.warning('请输入账号!');
            return;
        }
        const password = $("#password").val();
        if (isNullOrEmpty(password)) {
            toastr.warning('请输入密码!');
            return;
        }
        const params = {
            userName: userName,
            password: password
        }
        const url = 'user/login';
        goAjaxLogin(params, url);
    });
}

/**
 * 发送ajax请求---登录
 */
function goAjaxLogin(params, url) {
    $.ajax({
        type: 'POST',
        url: url,
        dataType: 'json',
        data: params,
        success: function(res) {
            if (res.code === 200) {
                toastr.success('登录成功');
                /** 根据不同的标志进入不同的登录页*/
                location.href = './view/manger/role_manger.html'
            } else {
                toastr.warning(res.message);
            }
        },
        error: function(res) {
            toastr.warning('后台错误，请联系管理员!');
        }
    });
}

/**
 * 注册
 */
function doRegister() {
    $("#register_btn").bind("click",function(){
        const userName = $("#reg-user-name").val();
        if (isNullOrEmpty(userName)) {
            toastr.warning('请输入账号!');
            return;
        } else if (userName.length < 8){
            toastr.warning('账号长度不足8位!');
            return;
        }
        let userNick = $("#reg-user-nick").val();
        const password = $("#reg-password").val();
        if (isNullOrEmpty(password)) {
            toastr.warning('请输入密码!');
            return;
        } else if (password.length < 8) {
            toastr.warning('密码不小于8位!');
            return;
        } else if (!isChaOrEng(password)) {
            toastr.warning('密码支持中文、英文!');
            return;
        }
        const rePassword = $("#reg-re-password").val();
        if (isNullOrEmpty(rePassword)) {
            toastr.warning('请输入确认密码!');
            return;
        }
        if (password !== rePassword) {
            toastr.warning('密码和确认密码必须一致!');
            return;
        }
        const email = $("#reg-re-email").val();
        if (isNullOrEmpty(email)) {
            toastr.warning('请输入邮箱!');
            return;
        } else if (!validateMail(email)) {
            toastr.warning('邮箱格式错误!');
            return;
        }
        const sex = $('input[name="sex"]:checked').val();
        if (isNullOrEmpty(sex)) {
            toastr.warning('请选择性别!');
            return;
        }
        const birthday = $("#datetime").val();
        if (isNullOrEmpty(birthday)) {
            toastr.warning('请选择生日!');
            return;
        }
        const address = $("#address").find("option:selected").attr("value");
        if (isNullOrEmpty(address)) {
            toastr.warning('请选择家庭住址!');
            return;
        }
        // 如果没有填写nick, 则将账号赋值给nick
        if (isNullOrEmpty(userNick)) {
            userNick = userName;
        }
        const params = {
            userName: userName,
            userNick: userNick,
            password: password,
            email: email,
            sex: sex,
            birthday: birthday,
            address: address
        }
        const param = {
            params: JSON.stringify(params)
        };
        // 注册
        const url = 'user/register';
        goAjaxRegister(param, url);
    });
}

/**
 * 发送ajax请求进行---注册
 */
function goAjaxRegister(params, url) {
    $.ajax({
        type: 'POST',
        url: url,
        data: params,
        dataType: 'json',
        success: function (res) {
            if (res.code === 200) {
                toastr.success(res.message);
                // 表单重置
                $("input[type=reset]").trigger("click");//触发reset按钮
                // 去登录页
                goLogin();
            } else {
                toastr.warning('用户名已存在, 请重新注册!');
            }
        },
        error: function (res) {
            toastr.warning('后台错误，请联系管理员!');
        }
    });
}
/**
 * 校验邮箱
 */
function validateMail(mail){//校验邮箱
    if(mail !== ""){
        const strRegex = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if(!strRegex.test(mail)){
            return false;
        }
    }
    return true;
}

/* 按钮提交*/
function submitFun() {
    // 登录
    doLogin();
    // 注册
    doRegister();
}
/*下拉选择*/
function getAddressDataAll() {
    $("#address").append($("<option value=''>" + '请选择' + "</option>"));
    const url = 'address/getAllBirthPlace';
    goAjaxAddSubSelector(url);
}

/**
 * 发送ajax请求--查询所有的家庭住址
 */
function goAjaxAddSubSelector(url) {
    $.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        success: function (res) {
            if (res.data.length !== 0) {
                for (let item in res.data) {
                    $("#address").append($("<option value='" + res.data[item].id + "'>" + res.data[item].value + "</option>"));
                }
                $("#address").selectpicker('refresh');
            }
        }
    });
}
/**
 * 判断字符串中是否只含有中文和英文
 */
function isChaOrEng(str) {
    const reg = new RegExp('^[A-Za-z\u4e00-\u9fa5]+$');
    return (reg.test(str));
}

/**
 * 判断字符串为空
 */
function isNullOrEmpty(data) {
    return data === null || data === undefined|| data === '';
}

/**
 * 判断字典为空
 * @param data
 */
function isNullOrEmptyJson(data) {
    return JSON.stringify(data) === '{}';
}

/**
 * 判断数组为空
 * @param data
 */
function isNullOrEmptyArray(data) {
    return data.length === 0;
}
