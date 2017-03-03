/**
 * Created by Qiang on 01/03/2017.
 */
/**
 * 用户登陆注册
 */
jQuery(document).ready(function($){
    var $form_modal = $('.cd-user-modal-1'),
        $my_pop = $('.my-pop-1'),
        $form_modal_2 = $('.cd-user-modal-2'),
        $my_pop_2 = $('.my-pop-2'),
        $form_modal_3 = $('.cd-user-modal-3'),
        $my_pop_3 = $('.my-pop-3'),
        $form_modal_4 = $('.cd-user-modal-4'),
        $my_pop_4 = $('.my-pop-4');


    //弹出窗口
    $my_pop.on('click', function(event){
        $form_modal.addClass('is-visible');
    });
    $my_pop_2.on('click', function(event){
        $form_modal_2.addClass('is-visible');
    });
    $my_pop_3.on('click', function(event){
        $form_modal_3.addClass('is-visible');
    });
    $my_pop_4.on('click', function(event){
        $form_modal_4.addClass('is-visible');
    });

    //关闭弹出窗口
    $('.modal-cancel').on('click', function(event){
        $form_modal.removeClass('is-visible');
        $form_modal_2.removeClass('is-visible');
        $form_modal_3.removeClass('is-visible');
        $form_modal_4.removeClass('is-visible');
    });
    //使用Esc键关闭弹出窗口
    $(document).keyup(function(event){
        if(event.which=='27'){
            $form_modal.removeClass('is-visible');
            $form_modal_2.removeClass('is-visible');
            $form_modal_3.removeClass('is-visible');
            $form_modal_4.removeClass('is-visible');
        }
    });


    // $('.modal-apply').on('click', function(e){
    //     e.preventDefault();
    //     var form = $(this).parent().parent().parent();
    //     var action = form.find('input[name="action"]').val();
    //     var inputs = '';
    //     var isreg = (action == 'signup') ? true : false
    //
    //     if( !action ){
    //         return
    //     }
    //
    //     // if( isreg ){ // 注册
    //     //     verifycode = form.find('input[name="verifycode"]').val();
    //     //     email = form.find('input[name="email"]').val();
    //     //     name = form.find('input[name="name"]').val();
    //     //     password = form.find('input[name="password"]').val();
    //     //     password2 = form.find('input[name="password2"]').val();
    //     //     inputs = {verifycode:verifycode,name:name,password:password,email:email,password2:password2,action:action};
    //     // }else{ // 登陆
    //     //     username = form.find('input[name="password"]d('input[name="username"]').val();
    //     //     password = form.fin').val();
    //     //     if($('#remember-me').prop('checked')) {
    //     //         remember = 1;
    //     //     } else {
    //     //         remember = 0;
    //     //     }
    //     //     inputs = {username:username,password:password,action:action,remember:remember};
    //     // }
    //
    //     $.ajax({
    //         type: "POST",
    //         url:  jsui.uri+'/option/user/log.php',
    //         data: inputs,
    //         dataType: 'json',
    //         success: function(data){
    //
    //             if( data.error ){
    //                 error_msg = '<p class="errtip">	<strong>错误</strong>：'+data.msg+'</p>'
    //                 $(".err-msg").html(error_msg);
    //                 return
    //             }
    //
    //             if( isreg ){
    //                 location.reload();
    //             }else{
    //                 location.reload();
    //             }
    //         }
    //     });
    // });


});


