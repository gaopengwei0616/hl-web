$(function () {
  qiehuan(0);
  //header杞挱
  // $(".header_lunbo").carousel({
  //   interval: 2000
  // });
  $(".zishu").each(function () {
    var maxwidth = 12;
    if ($(this).text().length >= maxwidth) {
      $(this).text($(this).text().substring(0, maxwidth));
      $(this).text($(this).text() + "...");
    }
  });

  $(".zishu1").each(function () {
    var maxwidth = 22;
    if ($(this).text().length >= maxwidth) {
      $(this).text($(this).text().substring(0, maxwidth));
      $(this).text($(this).text() + "...");
    }
  });
  $(".zishu2").each(function () {
    var maxwidth = 30;
    if ($(this).text().length >= maxwidth) {
      $(this).text($(this).text().substring(0, maxwidth));
      $(this).text($(this).text() + "...");
    }
  });
  $(".zishu3").each(function () {
    var maxwidth = 18;
    if ($(this).text().length >= maxwidth) {
      $(this).text($(this).text().substring(0, maxwidth));
      $(this).text($(this).text() + "...");
    }
  });
  $('#hot_myTab li').eq(0).addClass('active');
  $('#hot_right .tab-content .tab-pane').eq(0).addClass('active');
  //main杞挱
  $("#news_left .carousel").carousel({
    interval: 3000,
    pause: "hover"
  });

  $("#news_left .left").click(function () {
    $("#news_left .carousel").carousel("prev");
  });
  $("#news_left .right").click(function () {
    $("#news_left .carousel").carousel("next");
  });
  $("#news_left .carousel-indicators").css({
    top: "90%"
  });

  $("#news_right #myTab a").mouseover(function (e) {
    e.preventDefault();
    $(this).tab("show");
  });

  $("#hot_myTab li").mouseover(function () {
    $(this).siblings().removeClass('active');
    $(this).addClass('active');
    var index = $("#hot_myTab li").index(this);
    $('#hot_right .tab-content .tab-pane').removeClass('active');
    $('#hot_right .tab-content .tab-pane').eq(index).addClass('active');
  });

  $("#open_myTab a").mouseover(function (e) {
    e.preventDefault();
    $(this).tab("show");
  });

  $('.work_left #myTab a').mouseover(function (e) {
    e.preventDefault();
    $(this).tab("show");
  });

  $(".navs>.nav>.col-lg-3").mouseover(function () {
    $(this).siblings().removeClass('active');
    $(this).addClass('active');
    var index = $(".navs>.nav>.col-lg-3").index(this);
    qiehuan(index);
  });

  function qiehuan(a) {
    $('.qiehuan>div').css('display', 'none');
    $('.qiehuan>div').eq(a).css('display', 'block');
  }
  //鏉″舰杞挱鍥�
  //澶撮儴杞挱
  // $('.lunbos').height($('.lunbos img').height());
  // $('.lunbos .lunbo').height($('.lunbos img').height());
  // $('.lunbos .item').height($('.lunbos img').height());
  var curIndex = 0;
  var autoChange = setInterval(function () {
    if (curIndex < $(".lunbo li").length - 1) {
      curIndex++;
    } else {
      curIndex = 0;
    };
    //璋冪敤鍙樻崲澶勭悊鍑芥暟
    changeTo(curIndex);
  }, 5000);

  function changeTo(num) {
    $(".lunbo").find("li").removeClass("active").hide().eq(num).fadeIn().addClass("active");
  }
});

function more(catCode) {
  var siteid = $("#siteid").val();
  var arr = new Array();
  arr=catCode.split('+');
  var catid = arr[3];
  if(catid==undefined){
      window.location.href="/more?siteid="+siteid+"&catCode="+arr[0]+"&name="+arr[1]+"&flag="+arr[2];
  }else{
      window.location.href="/more2?siteid="+siteid+"&catid="+arr[3]+"&name="+arr[1];
  }
}