$(function(){
    // h1.title을 클릭 시 .music-list를 slidedown 효과
    $("h1.title").click(function(){
        $("ul.music-list").slideDown('slow');
    })

    // 노래 제목 클릭 시 이벤트
    $("ul.music-list li").click(function(){
        // 노래 제목 얻기
        let title=$(this).text();
        // h1.title에 넣기
        $("h1.title").text(title);
        // 클릭한 곳의 class 얻기
        let selectClass=$(this).attr("class");
        // cd effect 효과
        $("#cd").animate({width:"0"},"slow",function(){
            // cd 변경하기
            $("#cd").attr("class",selectClass);
            // 다시 너비 300으로
            $(this).animate({width:"300"},"slow");
        })

        // 마지막에 노래 목록 slideup
        $("ul.music-list").slideUp("slow");
    })
})